package com.schnell.taskassist.automation.screen;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DashBordScreen {
    private WebDriver driver;

    public DashBordScreen(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.schnell.taskassist:id/action_search")
    private AndroidElement search;
    @AndroidFindBy(id = "com.schnell.taskassist:id/action_options")
    private AndroidElement options;

    @AndroidFindBy(id = "com.schnell.taskassist:id/createChatFloatingBtn")
    private AndroidElement floatingBtn;

    public void clickOnSearch() {
        search.click();
    }

    public void clickOnOptions() {
        options.click();
    }

    public void clickOnDFloatingBtn() {
        floatingBtn.click();
    }

    public void onClickItem(String activity,String itemName) {
        List<WebElement> list = driver.findElements(By.id("com.schnell.taskassist:id/userFullName"));
        for (int i = 0; i < list.size(); i++) {
            if(itemName.equals("Gro")){
                if (list.get(i).getText().substring(0,3).equals(itemName)) {
                    list.get(i).click();
                    break;
                }
            }else{
                if (list.get(i).getText().equals(itemName)) {
                    list.get(i).click();
                    break;
                }
            }

        }
    }
}
