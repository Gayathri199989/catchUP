package com.schnell.taskassist.automation.testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.schnell.taskassist.automation.CapabilitiesConfiguration;
import com.schnell.taskassist.automation.screen.OTPScreen;
import com.schnell.taskassist.automation.util.DataMembers;
import com.schnell.taskassist.automation.util.Util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static com.schnell.taskassist.automation.util.DataMembers.OTP_COMMOM_TEXT;
import static com.schnell.taskassist.automation.util.DataMembers.OTP_TEST1;
import static com.schnell.taskassist.automation.util.DataMembers.OTP_TEST2;
import static com.schnell.taskassist.automation.util.DataMembers.OTP_TEST3;
import static com.schnell.taskassist.automation.util.DataMembers.OTP_TEST4;
import static com.schnell.taskassist.automation.util.DataMembers.OTP_TEST5;


public class OtpTestcase {
    private AndroidDriver driver;
    private OTPScreen otpScreen;
    private ExtentTest test;
    private ExtentReports extent;

    @BeforeClass
    public void setUp() {

        System.out.println("App otpScreen");
        driver = CapabilitiesConfiguration.getAppDriver();
        extent = Util.getExtent();
        otpScreen = new OTPScreen(driver);
    }

    @Test()
    public void otpElements() throws Exception {
        System.out.println(OTP_TEST1);
        test = extent.createTest(OTP_TEST1);
        test.log(Status.INFO, OTP_COMMOM_TEXT+" <br />"+
                "The following items should be displayed in OTP screen <br />" +
                "1. Half of the page displayed with Hammer icon <br />"+
                "2.'Enter your OTP' field <br />"+
                "3. RE-SEND OTP <br />"+
                "4. LOGIN");
        Assert.assertTrue(otpScreen.verifyElements());
        Thread.sleep(1000);
    }

    @Test(priority = 1)
    public void otp() throws Exception {
        System.out.println(OTP_TEST2);
        test = extent.createTest(OTP_TEST2);
        test.log(Status.INFO, OTP_COMMOM_TEXT+" <br />"+
                "'Enter your OTP' field should be displayed with dash line in the OTP screen");
        Assert.assertEquals(otpScreen.verifyOTPTextField(), "Enter your OTP");
        Thread.sleep(1000);
    }

    @Test(priority = 2)
    public void otpResend() throws Exception {
        System.out.println(OTP_TEST3);
        test = extent.createTest(OTP_TEST3);
        test.log(Status.INFO, OTP_COMMOM_TEXT+" <br />"+
                "'RE-SEND OTP text link should be displayed below the \"Enter your OTP\" dash line to the right side of the screen.");
        Assert.assertEquals(otpScreen.verifyResendTextField(), "RE-SEND OTP");
        Thread.sleep(1000);
    }

    @Test(priority = 3)
    public void otpLoginValidation() throws Exception {
        System.out.println(OTP_TEST4);
        test = extent.createTest(OTP_TEST4);
        test.log(Status.INFO, OTP_COMMOM_TEXT+" <br />"+
                "'LOGIN' text link field should be displayed at the bottom of OTP screen with center alignment.");
        Assert.assertEquals(otpScreen.verifyLoginTextField(), "LOGIN");
        Thread.sleep(1000);
    }

    @Test(priority = 4)
    public void otpLoginDefaultValidation() throws Exception {
        otpScreen.clickOnLogin();
        Thread.sleep(1000);
        WebElement toastView = driver.findElement(By.xpath("//android.widget.Toast[1]"));
        System.out.println("Toast " + toastView.getText());
        test = extent.createTest("Verify the error message when user without enter any value in 'Enter your OTP' field");
        test.log(Status.INFO, OTP_COMMOM_TEXT+" <br />"+
                "No value should be displayed in 'Enter your OTP' field <br />"+
                "'Please enter valid OT' error message should be displayed");
        Assert.assertEquals(toastView.getText(), "Enter your OTP");
    }

    @Test(priority = 5)
    public void keybordValidation() throws Exception {
        System.out.println(OTP_TEST5);
        test = extent.createTest(OTP_TEST5);
        test.log(Status.INFO, OTP_COMMOM_TEXT+" <br />"+
                "'Enter your OTP' field should be allowed only numerical values");
        otpScreen.clickOnOtp();
        Thread.sleep(1000);
        Assert.assertTrue(driver.isKeyboardShown());
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    @Test(priority = 6)
    public void otpLessNumbers() throws Exception {
        otpVerification(DataMembers.less_otp);
        test =extent.createTest("Verify the error message when user enter less than 6 digits in \"Enter your OTP\" field");
        test.log(Status.INFO, OTP_COMMOM_TEXT+" <br />"+
                "Entered value should be displayed in 'Enter your OTP' field <br />"+
                "'Please enter valid OTP' error message should be displayed");
    }

    @Test(priority = 7)
    public void otpZeroNumbers() throws Exception {
        otpScreen.getOtpFiled().clear();
        otpVerification(DataMembers.zero_otp);
        test = extent.createTest("Verify the error message when user enter all the values are zero in \"Enter your OTP\" field");
        test.log(Status.INFO, "Entered New User's value should be displayed in 'Enter your OTP' field <br />"+
                "'Please enter valid OTP' error message should be displayed");
    }
   // @Test(priority = 8)
    public void verifyNextScreen() {
        otpScreen.clickOnResend();
        try {
            otpScreen.getOtpFiled().clear();
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.schnell.taskassist:id/profileNextBtn")));
            System.out.println("Verify the OTP screen navigated to Profile Info screen when user enter valid OTP ");
            test = extent.createTest("Click on RE-SEND and Verify the OTP screen navigated to Profile Info screen when user enter valid OTP");
            test.log(Status.INFO, OTP_COMMOM_TEXT+" <br />"+
                    "Entered value should be displayed in 'Enter your OTP' field <br />"+
                    "OTP screen should be navigated to Profile Info screen");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @AfterMethod
    public void getResult(ITestResult result) {
        System.out.println("Result of the test case.");
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
    private void otpVerification(String[] keysValues) throws Exception {

        otpScreen.clickOnOtp();
        System.out.println("Enter less than 6 digits in \"Enter your OTP\" field");
        typeNumber(keysValues);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(500);
        otpScreen.clickOnLogin();
        Thread.sleep(2500);
        WebElement toastView = driver.findElement(By.xpath("//android.widget.Toast[1]"));
        System.out.println("Toast " + toastView.getText());
        Assert.assertEquals(toastView.getText(), "Please enter valid OTP");
    }

    private void typeNumber(String[] numbers) throws Exception {
        for (String number : numbers) {
            driver.getKeyboard().pressKey(number);
            Thread.sleep(100);
        }
    }


}
