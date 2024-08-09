package com.schnell.taskassist.automation;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;

public class CapabilitiesConfiguration {
    static AndroidDriver driver;

    public static void setDesiredCabality() throws Exception {
        File app = new File("/home/karuppasamy/Documents/apk", "catchup-debug.apk");
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("device", "Android");
        capability.setCapability(CapabilityType.BROWSER_NAME, "");
        capability.setCapability(CapabilityType.VERSION, "9");
        capability.setCapability("app", app.getAbsolutePath());
        capability.setCapability("deviceName", "Mi A2");
        capability.setCapability("platformName", "Android");
        capability.setCapability("noReset", true);
        capability.setCapability("app-package", "com.schnell.taskassist");
        capability.setCapability("app-activity", "taskassist.SplashScreen");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
    }

    public static AndroidDriver getAppDriver() {
        return driver;
    }
}
