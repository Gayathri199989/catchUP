package com.schnell.taskassist.automation.testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.schnell.taskassist.automation.CapabilitiesConfiguration;
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

import java.util.List;

import io.appium.java_client.android.AndroidDriver;


public class DashBordTestcase {
    private AndroidDriver driver;
    private DashBordScreen dashBordScreen;
    private ExtentTest test;
    private ExtentReports extent;

    @BeforeClass
    public void setUp() throws Exception {
        System.out.println("DashBordTestcase");
        CapabilitiesConfiguration.setDesiredCabality();
        driver = CapabilitiesConfiguration.getAppDriver();
        Util.htmlReporter();
        extent = Util.getExtent();
        Util.xlSheet();
        dashBordScreen = new DashBordScreen(driver);
        Thread.sleep(1000);
    }


    @Test(priority = 1)
    public void clickOnRecylerView() {
        System.out.println("Verify the click on recylerview");
        test = extent.createTest("DashBoad: Verify the click on recylerview");
        test.log(Status.INFO, "Verify the click on recylerview");
        List<WebElement> list = driver.findElements(By.id("com.schnell.taskassist:id/userFullName"));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getText().equals(DataMembers.self)) {

            } else if (list.get(i).getText().substring(0, 3).equals("Gro")) {

            } else {
                DataMembers.participant = list.get(i).getText();
                list.get(i).click();
                break;
            }

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
    public void exit() {
        System.out.println("send the all reports.");
        extent.flush();
    }


}
