package com.schnell.taskassist.automation.screen;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Profile {
    private WebDriver driver;

    public Profile(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.schnell.taskassist:id/profilePhotoIcon")
    private AndroidElement photo;

    @AndroidFindBy(id = "com.schnell.taskassist:id/emojiconEditText")
    private AndroidElement profileName;
    @AndroidFindBy(id = "com.schnell.taskassist:id/profileNextBtn")
    private AndroidElement nextBtn;

    @AndroidFindBy(id = "com.schnell.taskassist:id/galleryIcon")
    private AndroidElement galleryIcon;

    @AndroidFindBy(id = "com.schnell.taskassist:id/cameraIcon")
    private AndroidElement cameraIcon;

    @AndroidFindBy(id = "com.schnell.taskassist:id/photoAttachmentCancelButton")
    private AndroidElement cancelBtn;

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_deny_button")
    private AndroidElement denyBtn;

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private AndroidElement allowBtn;

    @AndroidFindBy(id = "com.schnell.taskassist:id/crop_image_menu_crop")
    private AndroidElement cropImg;

    @AndroidFindBy(id = "com.android.documentsui:id/icon_thumb")
    private AndroidElement selectGalleryImg;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Recent']")
    private AndroidElement recent;

    @AndroidFindBy(className = "android.widget.ImageButton")
    private AndroidElement menuGallery;

    @AndroidFindBy(id = "com.android.documentsui:id/roots_list")
    private AndroidElement rootList;

    @AndroidFindBy(id = "com.schnell.taskassist:id/deleteIcon")
    private AndroidElement deleteIcon;

    public void clickOnPhoto() {
        photo.click();
    }

    public void clickOnProfileName() {
        profileName.click();
    }

    public void deleteIcon() {
        deleteIcon.click();
    }

    public String emptyName() throws Exception {
        if (!profileName.getText().equals("Type your name here")) {
            profileName.clear();
        }
        nextBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        if (nextBtn.isEnabled()) {
            nextBtn.click();
        }
        Thread.sleep(1000);
        WebElement toast = driver.findElement(By.xpath("//android.widget.Toast[1]"));
        return toast.getText();
    }

    public String checkEmptyName() throws Exception {
        profileName.clear();
        Thread.sleep(1000);
        profileName.sendKeys("            ");
        Thread.sleep(1000);
        nextBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        if (nextBtn.isEnabled()) {
            nextBtn.click();
        }
        Thread.sleep(1000);
        WebElement toast = driver.findElement(By.xpath("//android.widget.Toast[1]"));
        return toast.getText();
    }

    public void galleryImgPick() throws Exception {
        photo.click();
        Thread.sleep(1500);
        galleryIcon.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.visibilityOf(allowBtn));
            if (allowBtn.isDisplayed()) {
                Thread.sleep(1000);
                allowBtn.click();
            }
        } catch (Exception e) {
            e.getMessage();
            System.out.println("====iiiii=====" + selectGalleryImg.isDisplayed());

        }

    }

    public void clickOnGalleryImg() throws Exception {
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOf(selectGalleryImg));
        System.out.println("=========" + selectGalleryImg.isDisplayed());
        if (selectGalleryImg.isDisplayed()) {
            selectGalleryImg.click();
        }
    }

    public void clickOnCropImg() throws Exception {
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOf(cropImg));
        System.out.println("=========" + cropImg.isDisplayed());
        if (cropImg.isDisplayed()) {
            cropImg.click();
            Thread.sleep(1500);
        }
    }

    public void cameraPermission() throws Exception {
        photo.click();
        Thread.sleep(1500);
        cameraIcon.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.visibilityOf(allowBtn));
            if (allowBtn.isDisplayed()) {
                Thread.sleep(1000);
                allowBtn.click();
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void openCameraClick() throws Exception {
        ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.CAMERA));
        Thread.sleep(1500);
        // driver.findElement(By.id("com.android.camera:id/v9_shutter_button_internal")).click();
        // Thread.sleep(1000);

    }


    public void cameraDoneClick() throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.camera:id/inten_done_apply")));
            driver.findElement(By.id("com.android.camera:id/inten_done_apply")).click();
        } catch (Exception e) {
            e.getMessage();
        }

    }

    public void clickOnNextBtn() {
        nextBtn.click();
    }

    public void clickOnCrop() {
        cropImg.click();
    }

    public AndroidElement getProfileName() {
        return profileName;
    }
}
