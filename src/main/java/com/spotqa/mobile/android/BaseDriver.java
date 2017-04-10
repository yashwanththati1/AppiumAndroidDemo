package com.spotqa.mobile.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by SpotQA on 10-04-2017.
 */
public class BaseDriver {

    AppiumDriver<MobileElement> driver;
    DesiredCapabilities capabilities;

    @BeforeSuite
    public void setUp(){
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platform", "Android");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("deviceName", "192.168.155.101:5555");
        capabilities.setCapability("app", System.getProperty("user.dir")+"\\resources\\paytm.apk");
        capabilities.setCapability("appPackage", "net.one97.paytm");
        capabilities.setCapability("appActivity", "net.one97.paytm.AJRJarvisSplash");
        //capabilities.setCapability("appActivity", "net.one97.paytm.languageSelector.AJRLanguageSelectorActivity");
        capabilities.setCapability("autoAcceptAlerts", true);

        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
    }

    public void popUp(String dialog_cotainer_id, String package_installer_id){
        if(driver.findElementsById(dialog_cotainer_id).size()>0){
            driver.findElementById(dialog_cotainer_id).findElementById(package_installer_id).click();
        }
    }
}