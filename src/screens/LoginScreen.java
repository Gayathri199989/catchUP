package com.schnell.taskassist.automation.screen;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginScreen {
    private WebDriver driver;

    public LoginScreen(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@text='']")
    private AndroidElement hammarIcon;

    @AndroidFindBy(id = "com.schnell.taskassist:id/phoneNumberText")
    private AndroidElement mobileNumber;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='VERIFY MY PHONE NUMBER']")
    private AndroidElement verifyNumber;

    public boolean isElementDisplayed() {
        if (hammarIcon.isDisplayed() && mobileNumber.isDisplayed() && verifyNumber.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyDefaultTextNumber() {
        if (mobileNumber.getText().equals("Enter your phone number")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyDefaultTextLogin() {
        if (verifyNumber.getText().equals("VERIFY MY PHONE NUMBER")) {
            return true;
        } else {
            return false;
        }
    }
    public boolean verifyNoNumber() {
        if (mobileNumber.getText().equals("Enter your phone number")) {
            return true;
        } else {
            return false;
        }
    }
    public void clickOnVerify() {
        verifyNumber.click();
    }

    public void clickMobileNumber() {
        mobileNumber.click();
    }

    public MobileElement mobileElement() {
        return mobileNumber;
    }
    public MobileElement verifyElement() {
        return verifyNumber;
    }


}
