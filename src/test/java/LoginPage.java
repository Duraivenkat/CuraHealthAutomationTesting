import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    WebDriver driver;


    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By makeAppointment = By.id("btn-make-appointment");
    By username = By.id("txt-username");
    By password = By.id("txt-password");
    By loginBtn = By.id("btn-login");
    By errorMsg = By.xpath("//p[contains(@class,'text-danger')]");
    By menu = By.id("menu-toggle");
    By logout = By.linkText("Logout");

    public void openLoginPage() {
        waitForElement(makeAppointment);
        driver.findElement(makeAppointment).click();
    }

    public void login(String user, String pass) {

        openLoginPage();

        waitForElement(username);
        driver.findElement(username).sendKeys(user);
        waitForElement(password);
        driver.findElement(password).sendKeys(pass);

        driver.findElement(loginBtn).click();
        wait.until(ExpectedConditions.urlContains("appointment"));

        // IMPORTANT FIX

    }

    public String getErrorMessage() {
        waitForElement(errorMsg);
        return driver.findElement(errorMsg).getText();
    }

    public boolean isLoginButtonEnabled() {
        openLoginPage();
        return driver.findElement(loginBtn).isEnabled();
    }
    public void logout() {

        wait.until(
                        ExpectedConditions.elementToBeClickable(menu))
                .click();

        wait.until(
                        ExpectedConditions.elementToBeClickable(logout))
                .click();
    }
}