package com.spotqa.mobile.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by SpotQA on 10-04-2017.
 */
public class AppiumAndroidDemo extends BaseDriver{

    @Test
    public void testOne() throws MalformedURLException{

        driver.findElementById("net.one97.paytm:id/btn_language_continue_button").click();

        popUp("com.android.packageinstaller:id/dialog_container", "com.android.packageinstaller:id/permission_allow_button");
        popUp("com.android.packageinstaller:id/dialog_container", "com.android.packageinstaller:id/permission_allow_button");

        ((AndroidDriver)driver).findElementByAndroidUIAutomator("new UiSelector().text(\"Do It Later\")").click();
        ((AndroidDriver)driver).findElementByAndroidUIAutomator("new UiSelector().resourceId(\"net.one97.paytm:id/help_overlay\")").click();
    }
}