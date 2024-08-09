package com.schnell.taskassist.automation.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Dimension;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;


public class Util {
    static ExtentReports extent;
    private static String[] columns = {"Priority","Activity","Task Name", "System Default Target Date",
            "User Updated Target Date","Time Stamp"};

    public static void writeToExcel(int name, int photo) {
        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("CatchUp Data");
        //This data needs to be written (Object[])
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[]{"NAME", "PHOTO"});
        data.put("2", new Object[]{name, photo});
        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row row = ((XSSFSheet) sheet).createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer) obj);
            }
        }
        try {
            File file = new File("profile_updated.xlsx");
            if (!file.exists()) {
                FileOutputStream out = new FileOutputStream(file);
                workbook.write(out);
                out.close();
            }
            System.out.println("profile_updated.xlsx written successfully on disk.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> getProfilefromExcel() {
        List<Integer> list = new ArrayList<Integer>();
        try {

            FileInputStream file = new FileInputStream(new File("profile_updated.xlsx"));
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    //Check the cell type and format accordingly
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            list.add((int) cell.getNumericCellValue());
                            break;
                    }
                }
            }
            file.close();
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    public static void htmlReporter() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/testReport.html");
        //initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        //To add system or environment info by using the setSystemInfo method.
        extent.setSystemInfo("OS", "ubuntu");
        extent.setSystemInfo("Browser", "Chrome");
        //configuration items to change the look and feel
        //add content, manage tests etc
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("CatchUp Report");
        htmlReporter.config().setReportName("CatchUp Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }

    public static ExtentReports getExtent() {
        return extent;
    }

    public static String getDayAfterTommorrowDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd");
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 2);
        dt = c.getTime();
        dateFormat.format(dt);
        System.out.println("data & Time " + dateFormat.format(dt));
        return dateFormat.format(dt);
    }

    public static String getDayAfterTommorrowDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd MMM, yyyy");
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 2);
        dt = c.getTime();
        dateFormat.format(dt);
        System.out.println("data & Time " + dateFormat.format(dt));
        return dateFormat.format(dt);
    }

    public static String getUpdatedDate(int day) {
        DateFormat dateFormat = new SimpleDateFormat("dd MMM, yyyy");
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, day);
        dt = c.getTime();
        dateFormat.format(dt);
        System.out.println("data & Time " + dateFormat.format(dt));
        return dateFormat.format(dt);
    }

    public static String getUpdatedMonth() {
        DateFormat dateFormat = new SimpleDateFormat("dd MMM, yyyy");
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.MONTH, 1);
        dt = c.getTime();
        dateFormat.format(dt);
        System.out.println("data & Time " + dateFormat.format(dt));
        return dateFormat.format(dt);
    }

    public static void swipingHorizontal(AndroidDriver driver, double startPercentage, double finalPercentage, double anchorPercentage, int duration) throws InterruptedException {
        Dimension size = driver.manage().window().getSize();

        int anchor = (int) (size.height * anchorPercentage) + 100;
        int startPoint = (int) (size.width * startPercentage) + 100;
        int endPoint = 500;
        new TouchAction(driver).press(PointOption.point(startPoint, anchor)).waitAction().moveTo(PointOption.point(endPoint, anchor)).release().perform();
    }

    public static String getTaskDate(int days) {
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, days);
        dt = c.getTime();
        return new SimpleDateFormat("dd MMM, yyyy").format(dt);
    }


    public static void xlSheet() {
        try {

            Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

        /* CreationHelper helps us create instances of various things like DataFormat,
           Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
            CreationHelper createHelper = workbook.getCreationHelper();

            // Create a Sheet
            Sheet sheet = workbook.createSheet("CatchUp");

            // Create a Font for styling header cells
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 10);
            headerFont.setColor(IndexedColors.BLUE.getIndex());

            // Create a CellStyle with the font
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);

            // Create a Row
            Row headerRow = sheet.createRow(0);
            // Create cells
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
                cell.setCellStyle(headerCellStyle);
            }
            // Create Cell Style for formatting Date
            CellStyle dateCellStyle = workbook.createCellStyle();
            dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
            // Create Other rows and cells with employees data
            // Resize all columns to fit the content size
            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }
            // Write the output to a file
            File file = new File("catchup_input_data.xlsx");
            FileOutputStream fileOut = null;
            if (!file.exists()) {
                fileOut = new FileOutputStream(file);
                workbook.write(fileOut);
                fileOut.close();
            }
            // Closing the workbook
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void xlSheetCreation(Map<Integer,Object[]>  map) {
        try {
            FileInputStream file = new FileInputStream(new File("catchup_input_data.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            //Update the value of cell
            int rowNum = 0;
            rowNum = sheet.getLastRowNum() + 1;
            System.out.println("--------" + rowNum);
            Set < Integer > keyid = map.keySet();
            int rowid = 0;

            for (Integer key : keyid) {
                Row row = sheet.createRow(rowNum++);
                Object [] objectArr = map.get(key);
                int cellid = 0;

                for (Object obj : objectArr){
                    Cell cell = row.createCell(cellid++);
                    cell.setCellValue((String)obj);
                }
            }

            System.out.println("Time " );

            file.close();
            FileOutputStream outFile = new FileOutputStream(new File("catchup_input_data.xlsx"));
            workbook.write(outFile);
            outFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
