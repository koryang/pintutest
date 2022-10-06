package setup;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Capabilities extends DesiredCapabilities {
    public static AndroidDriver driver;
    public static DesiredCapabilities capabilities = new DesiredCapabilities();


    public static AndroidElement waitForElement(AndroidElement element){
        WebDriverWait wait =  new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public static void stopDriver(){
        driver.quit();
    }

}
