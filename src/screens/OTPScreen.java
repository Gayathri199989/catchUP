package com.schnell.taskassist.automation.screen;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OTPScreen {
    private WebDriver driver;

    public OTPScreen(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@text='']")
    private AndroidElement hammarIcon;

    @AndroidFindBy(id = "com.schnell.taskassist:id/registrationOtpText")
    private AndroidElement otp;
    @AndroidFindBy(id = "com.schnell.taskassist:id/resendOTP")
    private AndroidElement resend;

    @AndroidFindBy(id = "com.schnell.taskassist:id/registrationLoginBtn")
    private AndroidElement login;

    public void clickOnOtp() {
        otp.click();
    }

    public void clickOnLogin() {
        login.click();
    }
    public void clickOnResend() {
        resend.click();
    }

    public MobileElement getOtpFiled() {
        return otp;
    }

    public boolean verifyElements() {
        if (hammarIcon.isDisplayed() && otp.isDisplayed() && resend.isDisplayed() && login.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public String verifyOTPTextField() {
        return otp.getText();
    }

    public String verifyResendTextField() {
        return resend.getText();
    }

    public String verifyLoginTextField() {
        return login.getText();
    }
}
