package com.schnell.taskassist.automation.testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.schnell.taskassist.automation.CapabilitiesConfiguration;
import com.schnell.taskassist.automation.screen.ChatScreen;
import com.schnell.taskassist.automation.screen.DashBordScreen;
import com.schnell.taskassist.automation.util.DataMembers;
import com.schnell.taskassist.automation.util.Util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static com.schnell.taskassist.automation.util.DataMembers.chat;


public class ChatScreenTestcase {
    private AndroidDriver driver;
    private ChatScreen chatScreen;
    private ExtentTest test;
    private ExtentReports extent;
    private Map<Integer,Object[]> map;
    @BeforeClass
    public void setUp() throws Exception {
        System.out.println("ChatScreenTestcase");
        driver = CapabilitiesConfiguration.getAppDriver();
        extent = Util.getExtent();
        chatScreen = new ChatScreen(driver);
        map = new HashMap<Integer,Object[]>();
        Thread.sleep(1000);
    }

    @Test()
    public void letsChat() throws Exception {
        System.out.println("letsChat ");
        test = extent.createTest("Lets Chat started");
        test.log(Status.INFO, "Chat creation.");
        chatScreen.clickOnChatmessage();
        typeNumber(chat);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(1000);

    }

    @Test(priority = 1)
    public void clickOnRecylerView() throws Exception {
        System.out.println("Create Task");
        createTask(DataMembers.participant);
    }

    @Test(priority = 2)
    public void createTaskonSame() throws Exception {
        System.out.println("Create same message with Another Task");
        sameTaskCreation(DataMembers.participant);
    }

    @Test(priority = 3)
    public void createTaskonCalender() throws Exception {
        //2
        System.out.println("Create Task -  Day after tommorw (Through Calendar)");
        test = extent.createTest("Personal: Create Task -  Day after tommorw (Through Calendar)");
        test.log(Status.INFO, "Create Task -  Day after tommorw (Through Calendar)");
        chatScreen.updateDate(DataMembers.participant,"Calender", 2);

    }

    @Test(priority = 4)
    public void taskCreationDay() throws Exception {
        //2
        System.out.println("Create Task -  1 Day");
        test = extent.createTest("Personal: Create Task -  1 Day");
        test.log(Status.INFO, "Create Task -  1 Day");
        chatScreen.updateDate(DataMembers.participant,"Day", 2);

    }

    @Test(priority = 5)
    public void taskCreationWeek() throws Exception {
        //3
        System.out.println("Create Task -  1 Week");
        test = extent.createTest("Personal: Create Task -  1 Week");
        test.log(Status.INFO, "Create Task -  1 Week");
        chatScreen.updateDate(DataMembers.participant,"Week", 3);
    }

    @Test(priority = 6)
    public void taskCreationMonth() throws Exception {
        //
        System.out.println("Create Task -  1 Month");
        test = extent.createTest("Personal: Create Task -  1 Month");
        test.log(Status.INFO, "Create Task -  1 Month");
        chatScreen.updateDate(DataMembers.participant,"Month", 3);
        Thread.sleep(1000);
    }

    @Test(priority = 7)
    public void startDashBord() throws Exception {
        System.out.println("DashBord Screen");
        test = extent.createTest("DashBord Screen: Self");
        DashBordScreen dashBordScreen = new DashBordScreen(driver);
        dashBordScreen.onClickItem(DataMembers.self,DataMembers.self);
        Thread.sleep(1000);
    }

    @Test(priority = 8)
    public void selfStart() throws Exception {
        System.out.println("Self lets Chat");
        test = extent.createTest("Self: lets Chat");
        chatScreen.clickOnChatmessage();
        typeNumber(chat);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(1000);
    }

    @Test(priority = 9)
    public void selfStartCreate() throws Exception {
        System.out.println("Self letsChat");
        createTask(DataMembers.self);
    }

    @Test(priority = 10)
    public void selfSameTask() throws Exception {
        System.out.println("self same task");
        sameTaskCreation(DataMembers.self);
    }

    @Test(priority = 11)
    public void selfSameCalenderTask() throws Exception {
        System.out.println("Create Task -  Day after tommorw (Through Calendar)");
        test = extent.createTest("Self: Create Task -  Day after tommorw (Through Calendar)");
        test.log(Status.INFO, "Create Task -  Day after tommorw (Through Calendar)");
        chatScreen.updateDate(DataMembers.self,"Calender", 2);

    }

    @Test(priority = 12)
    public void selTaskCreationDay() throws Exception {
        //2
        System.out.println("Create Task -  1 Day");
        test = extent.createTest("Self: Create Task -  1 Day");
        test.log(Status.INFO, "Create Task -  1 Day");
        chatScreen.updateDate(DataMembers.self,"Day", 2);

    }

    @Test(priority = 13)
    public void selfTaskCreationWeek() throws Exception {
        //3
        System.out.println("Create Task -  1 Week");
        test = extent.createTest("Self: Create Task -  1 Week");
        test.log(Status.INFO, "Create Task -  1 Week");
        chatScreen.updateDate(DataMembers.self,"Week", 3);

    }

    @Test(priority = 14)
    public void selfTaskCreationMonth() throws Exception {
        //
        System.out.println("Create Task -  1 Month");
        test = extent.createTest("Self: Create Task -  1 Month");
        test.log(Status.INFO, "Create Task -  1 Month");
        chatScreen.updateDate(DataMembers.self,"Month", 3);
        Thread.sleep(1000);
    }

    @Test(priority = 14)
    public void startDashbordGroup() throws Exception {
        System.out.println("DashBord Screen");
        test = extent.createTest("DashBord Screen: Group");
        DashBordScreen dashBordScreen = new DashBordScreen(driver);
        dashBordScreen.onClickItem(DataMembers.group,"Gro");
        Thread.sleep(1000);
    }

    @Test(priority = 15)
    public void groupStart() throws Exception {
        System.out.println("Group letsChat");
        test = extent.createTest("Group: Chat Created");
        chatScreen.clickOnChatmessage();
        typeNumber(chat);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(1000);
    }

    @Test(priority = 16)
    public void groupStartCreate() throws Exception {
        System.out.println("Self letsChat");
        createTask("Group");
    }

    @Test(priority = 17)
    public void groupSameTask() throws Exception {
        System.out.println("self same task");
        sameTaskCreation("Group");
    }

    @Test(priority = 18)
    public void groupSameCalenderTask() throws Exception {
        System.out.println("Create Task -  Day after tommorw (Through Calendar)");
        test = extent.createTest("Group: Create Task -  Day after tommorw (Through Calendar)");
        test.log(Status.INFO, "Create Task -  Day after tommorw (Through Calendar)");
        chatScreen.updateDate(DataMembers.group,"Calender", 2);

    }

    @Test(priority = 19)
    public void groupTaskCreationDay() throws Exception {
        System.out.println("Create Task -  1 Day");
        test = extent.createTest("Group: Create Task -  1 Day");
        test.log(Status.INFO, "Create Task -  1 Day");
        chatScreen.updateDate(DataMembers.group,"Day", 2);
    }

    @Test(priority = 20)
    public void groupTaskCreationWeek() throws Exception {
        System.out.println("Create Task -  1 Week");
        test = extent.createTest("Group: Create Task -  1 Week");
        test.log(Status.INFO, "Create Task -  1 Week");
        chatScreen.updateDate(DataMembers.group,"Week", 3);
        Thread.sleep(1000);
    }

    @Test(priority = 21)
    public void groupTaskCreationMonth() throws Exception {
        System.out.println("Create Task -  1 Month");
        test = extent.createTest("Group: Create Task -  1 Month");
        test.log(Status.INFO, "Create Task -  1 Month");
        chatScreen.updateDate(DataMembers.group,"Month", 21);
        Thread.sleep(1000);
        List<WebElement> list = driver.findElements(By.id("com.schnell.taskassist:id/timeDurationTextView"));
        list.get(2).click();
        Thread.sleep(1000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(1000);

    }

    @Test(priority = 22)
    public void groupTaskAssign() throws Exception {
        System.out.println("Create Task -  1 Day (Assign to someone)");
        test = extent.createTest("Assign to someone : 1 Day ");
        test.log(Status.INFO, "Create a Task -  1 Day (Assign to someone)");
        Util.swipingHorizontal(driver, 0.9, 0.01, 0.5, 3000);
        Thread.sleep(1000);
        chatScreen.assignTask("Day");
        Thread.sleep(1000);

    }

    @Test(priority = 23)
    public void groupTaskAssignWeek() throws Exception {
        System.out.println("Create Task -  1 Week (Assign to someone)");
        test = extent.createTest("Assign to someone : 1 Week ");
        test.log(Status.INFO, "Create a Task -  1 Week (Assign to someone)");
        Util.swipingHorizontal(driver, 0.9, 0.01, 0.5, 3000);
        Thread.sleep(1000);
        chatScreen.assignTask("Week");
        Thread.sleep(1000);

    }

    @Test(priority = 24)
    public void groupTaskAssignMonth() throws Exception {
        System.out.println("Create Task -  1 Month (Assign to someone)");
        test = extent.createTest("Assign to someone : 1 Month ");
        test.log(Status.INFO, "Create a Task -  1 Month (Assign to someone)");
        Util.swipingHorizontal(driver, 0.9, 0.01, 0.5, 3000);
        Thread.sleep(1000);
        chatScreen.assignTask("Month");

    }

    @AfterMethod
    public void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILD ", ExtentColor.RED));
            test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
        } else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIP ", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }


    @AfterTest
    public void exit() {
        System.out.println("send the all reports.");
        extent.flush();
    }

    private void typeNumber(String[] numbers) {
        for (String number : numbers) {
            driver.getKeyboard().pressKey(number);
            chatScreen.clickOnsendBtn();
        }
    }


    public void createTask(String activityName) throws Exception {
        test = extent.createTest("Create Task");
        test.log(Status.INFO, "Create a Task");
        chatScreen.createTask();
        List<WebElement> list = driver.findElements(By.id("com.schnell.taskassist:id/task_name"));
        map.clear();
        map.put(0,new Object[]{"1",activityName,list.get(0).getText(),
                Util.getUpdatedDate(1),"",""+new Timestamp(new Date().getTime())});
        Util.xlSheetCreation(map);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(1000);
    }

    public void sameTaskCreation(String activityName) throws Exception {
        test = extent.createTest("Create same message with Another Task");
        test.log(Status.INFO, "Create same message with Another Task");
        chatScreen.createTask();
        List<WebElement> list = driver.findElements(By.id("com.schnell.taskassist:id/task_name"));
        map.clear();
        map.put(0,new Object[]{"1",activityName,list.get(1).getText(),
                Util.getUpdatedDate(1),"",""+new Timestamp(new Date().getTime())});
        Util.xlSheetCreation(map);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(1000);
    }

}
