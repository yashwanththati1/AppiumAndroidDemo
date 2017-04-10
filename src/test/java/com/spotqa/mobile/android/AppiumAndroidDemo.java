package com.spotqa.mobile.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by SpotQA on 10-04-2017.
 */
public class AppiumAndroidDemo {

    static AppiumDriver<MobileElement> driver;
    static DesiredCapabilities capabilities;

    public static void main(String[] args) throws MalformedURLException{
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platform", "Android");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("deviceName", "192.168.155.101:5555");
        capabilities.setCapability("app", System.getProperty("user.dir")+"\\resources\\paytm.apk");
        capabilities.setCapability("appPackage", "net.one97.paytm");
        capabilities.setCapability("appActivity", "net.one97.paytm.AJRJarvisSplash");
        capabilities.setCapability("autoAcceptAlerts", true);

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        driver.findElementById("net.one97.paytm:id/btn_language_continue_button").click();

        if(driver.findElementsById("com.android.packageinstaller:id/dialog_container").size()>0){
            driver.findElementById("com.android.packageinstaller:id/dialog_container").findElementById("com.android.packageinstaller:id/permission_allow_button").click();
        }

        if(driver.findElementsById("com.android.packageinstaller:id/dialog_container").size()>0){
            driver.findElementById("com.android.packageinstaller:id/dialog_container").findElementById("com.android.packageinstaller:id/permission_allow_button").click();
        }

        ((AndroidDriver)driver).findElementByAndroidUIAutomator("new UiSelector().text(\"Do It Later\")").click();
        ((AndroidDriver)driver).findElementByAndroidUIAutomator("new UiSelector().resourceId(\"net.one97.paytm:id/help_overlay\")").click();
    }
}