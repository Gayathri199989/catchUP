package com.schnell.taskassist.automation.testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.schnell.taskassist.automation.CapabilitiesConfiguration;
import com.schnell.taskassist.automation.screen.LoginScreen;
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


public class LoginTestCase {
    private AndroidDriver driver;
    private LoginScreen loginScreen;
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeClass
    public void setUp() throws Exception {
        CapabilitiesConfiguration.setDesiredCabality();
        System.out.println("App Insitalized");
        driver = CapabilitiesConfiguration.getAppDriver();
        loginScreen = new LoginScreen(driver);
        Util.htmlReporter();
        extent = Util.getExtent();
        Thread.sleep(1000);

    }

    @Test()
    public void login_UIvalidation() throws Exception {
        System.out.println("Verify the Catch Up Application login page");
        test = extent.createTest("Verify the Catch Up Application login page");
        test.log(Status.INFO, "Catch Up Application should be displayed login page" + " <br />" +
                "The following items should be displayed in Catch Up login page <br />" +
                "1. Half of the page displayed with Hammer icon <br />" +
                "2.'Enter your phone number' field <br />" +
                "3. VERIFY MY PHONE NUMBER");
        Assert.assertTrue(loginScreen.isElementDisplayed());
        Thread.sleep(1000);
    }

    @Test(priority = 1)
    public void login_UIvalidation_001() throws Exception {
        System.out.println("Verify the 'Enter your phone number' field availability in the Catch Up login page");
        test = extent.createTest("Verify the 'Enter your phone number' field availability in the Catch Up login page");
        test.log(Status.INFO, "Catch Up Application should be displayed login page" + " <br />" +
                "'Enter your phone number' field should be displayed with dash line in the Catch Up login page");
        Assert.assertTrue(loginScreen.verifyDefaultTextNumber());
        Thread.sleep(1000);
    }


    @Test(priority = 2)
    public void uIValidation_003() throws Exception {
        System.out.println("''VERIFY MY PHONE NUMBER' text link field should be displayed at the bottom of Catch Up login page with center alignment.");
        test = extent.createTest( "''VERIFY MY PHONE NUMBER' text link field should be displayed at the bottom of Catch Up login page with center alignment.");
        test.log(Status.INFO, "Catch Up Application should be displayed login page  <br />"+
                "'VERIFY MY PHONE NUMBER' text link field should be displayed at the bottom of Catch Up login page with center alignment.");
        Assert.assertTrue(loginScreen.verifyDefaultTextLogin());
        Thread.sleep(1000);
    }

    @Test(priority = 3)
    public void keybord_Validation_003() throws Exception {
        System.out.println("\"Enter your phone number\" field should be allowed only numerical values");
        loginScreen.clickMobileNumber();
        Thread.sleep(1000);
        test = extent.createTest("\"Enter your phone number\" field should be allowed only numerical values");
        test.log(Status.INFO, "Catch Up Application should be displayed login page  <br />" +
                "'VERIFY MY PHONE NUMBER' text link field should be displayed at the bottom of Catch Up login page with center alignment.");
        Assert.assertTrue(driver.isKeyboardShown());
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

    }

    @Test(priority = 4)
    public void login_004() throws Exception {
        loginScreen.mobileElement().click();
        System.out.println("Verify the error message when user enter less than 10 digits in \"Enter your phone number\" field");
        test = extent.createTest("Verify the error message when user enter less than 10 digits in \"Enter your phone number\" field");
        test.log(Status.INFO, "Catch Up Application should be displayed login page  <br />" +
                "Entered value should be displayed in \"Enter your phone number\" field <br />" +
                "\"Please enter your phone number\" error message should be displayed");
        typeNumber(DataMembers.less_phoneNumber);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(1000);
        loginScreen.clickOnVerify();
        WebElement toastView = driver.findElement(By.xpath("//android.widget.Toast[1]"));
        System.out.println("Toast " + toastView.getText());
        Assert.assertEquals(toastView.getText(), "Please enter your phone number.");

    }
    @Test(priority = 5)
    public void uIValidation_004() throws Exception {
        System.out.println("Verify the error message when user without enter any value in \"Enter your phone number\" field");
        loginScreen.mobileElement().clear();
        loginScreen.clickOnVerify();
        Thread.sleep(1000);
        test = extent.createTest("Verify the error message when user without enter any value in \"Enter your phone number\" field");
        test.log(Status.INFO, "Catch Up Application should be displayed login page  <br />" +
                "No value should be displayed in \"Enter your phone number\" field <br />" +
                "\"Please enter your phone number\" error message should be displayed");
        Assert.assertEquals(loginScreen.mobileElement().getText(), "Enter your phone number");
        Thread.sleep(1000);
    }

     @Test(priority = 6)
    public void login_005() throws Exception {
        loginScreen.mobileElement().clear();
        loginScreen.mobileElement().click();
        System.out.println("Verify the valid number to register.");
        test = extent.createTest("Verify the valid mobile number to register.");
        test.log(Status.INFO, "Catch Up Application should be displayed login page  <br />"+
                "Verify the valid mobile number to register <br />" +
                "Navigate to OTP screen");
        typeNumber(DataMembers.phoneNumber);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(1000);
        loginScreen.clickOnVerify();
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.schnell.taskassist:id/registrationOtpText")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void typeNumber(String[] numbers) throws Exception {
        for (String number : numbers) {
            driver.getKeyboard().pressKey(number);
            Thread.sleep(100);
        }
    }

    @AfterMethod
    public void getResult(ITestResult result) {
        System.out.println("Result of the test case.");
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
            test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
        } else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }

    @AfterTest
    public void exit() {
        System.out.println("send the all reports.");
        extent.flush();

    }
}
