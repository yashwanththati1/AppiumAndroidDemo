package com.spotqa.mobile.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

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

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        System.out.println(driver.getTitle());
    }
}