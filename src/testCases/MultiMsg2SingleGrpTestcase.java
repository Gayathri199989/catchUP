package testCases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import screens.ChatScreen;
import utility.Constant;
import utility.Log;
import utility.ReadPropertyFile;

public class MultiMsg2SingleGrpTestcase {
private static AndroidDriver driver;
	
	static ReadPropertyFile property = PageFactory.initElements(driver, ReadPropertyFile.class);
	
	Log log = new Log();
	
	static String extentReportFile;
	static ExtentReports extent;
	static String extentReportImage;
	static ExtentTest extentTest;
	static String date = Constant.DateTimeFormat();
	 //define an Excel Work Book
	  static HSSFWorkbook workbook;
	  //define an Excel Work sheet
	  static HSSFSheet sheet;
	  //define a test result data object
	static Map<String, Object[]> testresultdata;
	
	@BeforeClass
	public static void BeforeClass() throws Exception{
		extentReportFile = property.getExtentReportFile()+"extentReportFile"+date+"."+"html";
		extentReportImage = property.getExtentReportImg()+"extentReportImage"+date+"."+"png";
		// Create object of extent report and specify the report file path.
		extent = new ExtentReports(extentReportFile, false);
		Constant.logFile("CatchUp");
		 //Browser Initialization
		DOMConfigurator.configure("log4j.xml");
		//create a new work book
		workbook = new HSSFWorkbook();
		//create a new work sheet
		sheet = workbook.createSheet("Multiple Messages");
		testresultdata = new LinkedHashMap<String, Object[]>();
		//add test result excel file column header
		// write the header in the first row
		testresultdata.put("1", new Object[] {"S.No", "Scenario", "Expected Result","Pass/Fail"});
		
	}
	 
	@BeforeTest(alwaysRun = true)
	@Parameters({"platform","udid", "systemPort","url_"})
	public static void AppSetting(String platform, String udid, String systemPort, String url_) throws Exception{
		ReadPropertyFile property = PageFactory.initElements(driver, ReadPropertyFile.class);
		String[] platformInfo = platform.split(" ");
	
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabilities.setCapability("platformVersion", platformInfo[1]);
		capabilities.setCapability("platformName", platformInfo[0]);
		capabilities.setCapability("udid", udid);
		capabilities.setCapability("systemPort", systemPort);
		capabilities.setCapability("app", property.getAppLocation());
		capabilities.setCapability("appPackage", property.getAppPackage());
		capabilities.setCapability("appActivity", property.getAppActivity());
		capabilities.setCapability("autoAcceptAlerts", true);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator1");
		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("resetKeyboard", true);
		capabilities.setCapability(MobileCapabilityType.NO_RESET,"true");
		capabilities.setCapability(MobileCapabilityType.FULL_RESET,"false");
		capabilities.setCapability("avdArgs", "-no-window");
		capabilities.setCapability("isHeadless", true); 
		capabilities.setCapability("adbExecTimeout", "5000000");
		Constant.uninstallSettings_7();
//		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver = new AndroidDriver(new URL("http://"+url_), capabilities);
	}
	
	@Test
	public void test001_MultipleMsg2Group(){
		Log.startTestCase("Multiple Message group");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Multiple Message group",
				"Verify Multiple Message to group");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.sendTextMsg_GroupChat(1);
			if(flag == true){
				Constant.log.info("test001_MultipleMsg2Group: Multiple messages sent to single group test case is successful");
				extentTest.log(LogStatus.PASS, "Multiple messages sent to single group Successful");
				testresultdata.put("2", new Object[] {1d, "Login", "Multiple messages sent to single group is successful","Pass"});
			}else{
				System.err.println("test001_MultipleMsg2Group: Multiple messages sent to single group test case failed ");
				Constant.captureScreen_Negative("Multiple messages group");
				extentTest.log(LogStatus.FAIL, "Multiple messages to group failed");
				testresultdata.put("2", new Object[] {1d, "Multiple Message to group", "Multiple messages sent to single group failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Multiple Message to group");
	}
	

	 @AfterTest
		public void After(){
//		 	nurseScreen.logout();
		 	 //write excel file and file name is TestResult.xls 
	        Set<String> keyset = testresultdata.keySet();
	        int rownum = 0;
	        for (String key : keyset) {
	            Row row = sheet.createRow(rownum++);
	            Object [] objArr = testresultdata.get(key);
	            int cellnum = 0;
	            for (Object obj : objArr) {
	                Cell cell = row.createCell(cellnum++);
	                if(obj instanceof Date) 
	                    cell.setCellValue((Date)obj);
	                else if(obj instanceof Boolean)
	                    cell.setCellValue((Boolean)obj);
	                else if(obj instanceof String)
	                    cell.setCellValue((String)obj);
	                else if(obj instanceof Double)
	                    cell.setCellValue((Double)obj);
	            }
	        }
	        try {
	            FileOutputStream out =new FileOutputStream(new File("CatchUp.xls"));
	            workbook.write(out);
	            out.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    
		}
		
		@AfterClass
		public static void AfterClass() throws Exception{
			driver.quit();
			extentTest.log(LogStatus.INFO, "Browser closed");
			// close report.  
			extent.endTest(extentTest);
			// writing everything to document.
	    	extent.flush();
		}
}
