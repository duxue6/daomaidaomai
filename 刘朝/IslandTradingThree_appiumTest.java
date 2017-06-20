package com.daomaidaomai.islandtrading;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.URL;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
/**
 * Created by 阿朝 on 2017/6/20.
 */

public class IslandTradingThree_appiumTest {
    private AppiumDriver<AndroidElement> driver;

    @Before
    public void setUp() throws Exception {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "../../.../apps/app-release");
        File app = new File(appDir, "app-release.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("noReset", true);
        capabilities.setCapability("deviceName","HTCm8Sw");
        capabilities.setCapability("platformVersion","4.4.2");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.daomaidaomai.islandtrading.app-release");
        capabilities.setCapability("appActivity", "ui.Login");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void appiumTest(){
        driver.findElementById("login_user").sendKeys("liuchao520");
        driver.findElementById("login_password").sendKeys("237017");
        WebElement el = driver.findElement(By.xpath(".//*[@text='登录']"));
        el.click();
        TouchAction ta = new TouchAction(driver);
    }

}