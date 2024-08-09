package com.schnell.taskassist.automation.testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.schnell.taskassist.automation.CapabilitiesConfiguration;
import com.schnell.taskassist.automation.screen.Profile;
import com.schnell.taskassist.automation.util.DataMembers;
import com.schnell.taskassist.automation.util.Util;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class ProfileTestcase {
    private AndroidDriver driver;
    private Profile profile;
    private ExtentTest test;
    private ExtentReports extent;

    @BeforeClass
    public void setUp() throws Exception {
        System.out.println("App otpScreen");
        CapabilitiesConfiguration.setDesiredCabality();
        driver = CapabilitiesConfiguration.getAppDriver();
        Util.htmlReporter();
        extent = Util.getExtent();
        profile = new Profile(driver);
        Thread.sleep(1000);
    }

    @Test()
    public void checkLastProfileNamePhoto() {
        test = extent.createTest("verify the fields of Profile photo & Name for registered user.");
        test.log(Status.INFO, "The last saved Profile name & photo should be displayed");
        List<Integer> list = Util.getProfilefromExcel();
        if (!Util.getProfilefromExcel().isEmpty()) {
            boolean isName = false, isPhoto = false;
            if (list.get(0) == 1) {
                isName = true;
            }
            if (list.get(1) == 1) {
                isPhoto = true;
            }
            if (isName && isPhoto) {
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
            }
        }
        System.out.println("verify the fields of Profile photo & Name for registered user.");
    }

    @Test(priority = 1)
    public void profileNameEmpty() throws Exception {
        System.out.println("Verify the Error message while leaving profile name field as empty for new user");
        test = extent.createTest("Verify the Error message while leaving " +
                "profile name field as empty for new user");
        test.log(Status.INFO, "Clear the profile name field <br />"+"" +
                "Click Ok button <br />"+"" +
                "The error message of 'Please enter your profile name to proceed' should be displayed.");
        Assert.assertEquals(profile.emptyName(), "Please enter your profile name to proceed");
    }

    @Test(priority = 2)
    public void checkProfileName() throws Exception {
        System.out.println("The error message of \"Please enter your profile name to proceed\" should be displayed");
        test = extent.createTest("Verify the Error message while providing space in the profile name field for new user");
        test.log(Status.INFO, "Clear the profile name field <br />"+
                "Type space on profile name <br />"+
                "Click Ok button <br />"+"" +
                "The error message of 'Please enter your profile name to proceed' should be displayed.");
        Assert.assertEquals(profile.checkEmptyName(), "Please enter your profile name to proceed");
    }

   @Test(priority = 3)
    public void openGallery() throws Exception {
        profile.galleryImgPick();
        test = extent.createTest("1.Verfiy  able to update profile photo for register user from gallery.");
       test.log(Status.INFO, "1.The new profile photo should be displayed ");
        System.out.println("Test_case_001-Verify  able to update profile photo for register user from gallery.");
    }

    @Test(priority = 4)
    public void clickOnGalleryImg() throws Exception {
        profile.clickOnGalleryImg();
        test = extent.createTest("2.Verfiy  able to update profile photo for register user from gallery.");
        test.log(Status.INFO, "2.The new profile photo should be displayed ");
        System.out.println("Test_case_002-Verify  able to update profile photo for register user from gallery.");
    }

    @Test(priority = 5)
    public void clickOnCropImg() throws Exception {
        profile.clickOnCropImg();
        test = extent.createTest("3.Verfiy  able to update profile photo for register user from gallery.");
        test.log(Status.INFO, "3.The new profile photo should be displayed ");
        System.out.println("Test_case_003-Verify able to update profile photo for register user from gallery.");
    }

    @Test(priority = 6)
    public void cameraPermission() throws Exception {
        profile.cameraPermission();
        test = extent.createTest("1.Verfiy  able to update profile photo for register user from camera");
        test.log(Status.INFO, "1.The new profile photo should be displayed");
        System.out.println("Test_case_001-Verify able to update profile photo for register user from gallery.");
    }

    @Test(priority = 7)
    public void openCamera() throws Exception {
        profile.openCameraClick();
        test = extent.createTest("2.Verfiy  able to update profile photo for register user from camera");
        test.log(Status.INFO, "2.The new profile photo should be displayed");
        System.out.println("Test_case_002-Verify able to update profile photo for register user from gallery.");
    }

    @Test(priority = 8)
    public void cameraDoneClick() throws Exception {
        profile.cameraDoneClick();
        Thread.sleep(1000);
        test = extent.createTest("3.Verfiy  able to update profile photo for register user from camera");
        test.log(Status.INFO, "3.The new profile photo should be displayed");
        System.out.println("Test_case_003-Verify able to update profile photo for register user from gallery.");
    }

    @Test(priority = 9)
    public void cameraCropClick() {
        profile.clickOnCrop();
        test = extent.createTest("4.Verfiy  able to update profile photo for register user from camera");
        test.log(Status.INFO, "4.The new profile photo should be displayed");
        System.out.println("Test_case_004-Verify able to update profile photo for register user from gallery.");
    }

    // @Test(priority = 10)
    public void clickOnNext() throws Exception {
        sendProfileName();
        System.out.println("Uploaded with Photo and Name");
        try {
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/alertTitle")));
            Util.writeToExcel(1, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 10)
    public void withoutPhoto() throws Exception {
        Thread.sleep(1500);
        profile.clickOnPhoto();
        Thread.sleep(1500);
        profile.deleteIcon();
        Thread.sleep(1000);
        profile.getProfileName().clear();
        sendProfileName();
        test = extent.createTest("Verify that new user’s Profile Name and Photo displayed as empty.");
        test.log(Status.INFO, "The user is registered without profile photo.");
        try {
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/alertTitle")));
            Util.writeToExcel(1, 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
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
    public void sendProfileName() throws Exception {
        Thread.sleep(1000);
        System.out.println("Verify that new user’s Profile Name and Photo displayed as empty.");
        profile.clickOnProfileName();
        typeKeys(DataMembers.profile_name);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        profile.clickOnNextBtn();

    }

    @AfterTest
    public void exit() {
        System.out.println("send the all reports.");
        extent.flush();
    }

    private void typeKeys(String[] numbers) throws Exception {
        for (String number : numbers) {
            driver.getKeyboard().pressKey(number);
            Thread.sleep(100);
        }
    }


}
