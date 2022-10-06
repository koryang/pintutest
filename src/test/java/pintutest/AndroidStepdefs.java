package pintutest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import setup.Capabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class AndroidStepdefs extends Capabilities {
//    AndroidDriver driver;

//    @Before()
//    public void setup()throws Exception{
//        preparation();
//    }

    @Given("app is launched")
    public void appIsLaunched() throws MalformedURLException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("app", "/Users/koryanggraeni/test/apk/Tes_v4.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:7272/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @And("user register using data")
    public void userRegisterUsingData(DataTable userData) {
        List<String> data = userData.row(0);

        userClickNoAccountYetLink();
        userFillTheNameWith(data.get(0));
        userFillTheEmailWith(data.get(1));
        userFillThePasswordWith(data.get(0));
        userFillTheConfirmPasswordWith(data.get(0));
        userClickRegisterButton();
        driver.navigate().back();
    }


    @When("user fill the login email with {string}")
    public void userFillTheLoginEmailWith(String email) throws InterruptedException {
        driver.findElementById("com.loginmodule.learning:id/textInputEditTextEmail").sendKeys(email);
    }

    @And("user fill the login password with {string}")
    public void userFillTheLoginPasswordWith(String password) {
        driver.findElementById("com.loginmodule.learning:id/textInputEditTextPassword").sendKeys(password);
    }

    @And("user click login button")
    public void userClickLoginButton() {
        AndroidElement element = (AndroidElement) driver.findElementById("com.loginmodule.learning:id/appCompatButtonLogin");
        waitForElement(element).click();
    }

    @Then("user should see the home page")
    public void userShouldSeeTheHomePage() {
        assertTrue(driver.findElementById("com.loginmodule.learning:id/textViewName").isDisplayed());
    }

    @And("user click No account yet link")
    public void userClickNoAccountYetLink() {
        driver.findElementById("com.loginmodule.learning:id/textViewLinkRegister").click();
    }

    @When("user fill the name with {string}")
    public void userFillTheNameWith(String name) {
        driver.findElementById("com.loginmodule.learning:id/textInputEditTextName").sendKeys(name);
    }

    @And("user fill the email with {string}")
    public void userFillTheEmailWith(String email) {
        driver.findElementById("com.loginmodule.learning:id/textInputEditTextEmail").sendKeys(email);
    }

    @And("user fill the password with {string}")
    public void userFillThePasswordWith(String password) {
        driver.findElementById("com.loginmodule.learning:id/textInputEditTextPassword").sendKeys(password);
    }

    @And("user fill the confirm password with {string}")
    public void userFillTheConfirmPasswordWith(String confimpassword) {
        driver.findElementById("com.loginmodule.learning:id/textInputEditTextConfirmPassword").sendKeys(confimpassword);
    }

    @And("user click register button")
    public void userClickRegisterButton() {
        driver.findElementById("com.loginmodule.learning:id/appCompatButtonRegister").click();
    }

    @Then("user should see the login link")
    public void userShouldSeeTheLoginPage() {
        assertTrue(driver.findElementById("com.loginmodule.learning:id/appCompatTextViewLoginLink").isDisplayed());
    }

    @Then("user should stay register page")
    public void userShouldStayRegisterPage() {
        assertTrue(driver.findElementById("com.loginmodule.learning:id/appCompatButtonRegister").isDisplayed());
    }

    @Then("user validate {string}")
    public void userValidate(String status) {
        if(status == "invalid email format") {
            assumeTrue(driver.findElementByXPath("//*[contains(text(),'Enter Valid Email')]").isDisplayed());
        } else if (status == "invalid confirm password") {
            assumeTrue(driver.findElementByXPath("//*[contains(text(),'Password Does Not Matches')]").isDisplayed());
        } else if (status == "empty name") {
            assumeTrue(driver.findElementByXPath("//*[contains(text(),'Enter Full Name')]").isDisplayed());
        } else if (status == "empty email") {
            assumeTrue(driver.findElementByXPath("//*[contains(text(),'Enter Valid Email')]").isDisplayed());
        } else if (status == "empty password") {
            assumeTrue(driver.findElementByXPath("//*[contains(text(),'Enter Password')]").isDisplayed());
        } else if (status == "empty confirm password") {
            assumeTrue(driver.findElementByXPath("//*[contains(text(),'Password Does Not Matches')]").isDisplayed());
        }
    }

    @Then("user should stay on login page")
    public void userShouldStayOnLoginPage() {
        assertTrue(driver.findElementById("com.loginmodule.learning:id/appCompatButtonLogin").isDisplayed());
    }

    @And("user should this error message {string} where {string}")
    public void userShouldThisErrorMessageWhere(String message, String status) {
//        assumeTrue(driver.findElementByXPath("//*[contains(text(),'" + message + "')]").isDisplayed());
        WebElement element = null;
        if(status == "empty email") {
            element = driver.findElementByXPath("//android.widget.TextInputLayout[@id='com.loginmodule.learning:id'/textInputLayoutEmail/android.widget.LinearLayout/android.widget.TextView[@text='Enter Valid Email']]");
            System.out.println(element.getAttribute("text"));
        }
//        assertEquals(message,element.getAttribute("text"));

    }

    @After()
    public void stop(){
        stopDriver();
    }
}
