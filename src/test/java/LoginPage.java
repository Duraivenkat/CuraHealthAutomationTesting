import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By makeAppointment = By.id("btn-make-appointment");
    By username = By.id("txt-username");
    By password = By.id("txt-password");
    By loginBtn = By.id("btn-login");
    By errorMsg = By.xpath("//p[contains(@class,'text-danger')]");

    public void openLoginPage() {
        wait.until(ExpectedConditions.elementToBeClickable(makeAppointment)).click();
    }

    public void login(String user, String pass) {

        openLoginPage();

        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(user);
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pass);

        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();

        // IMPORTANT FIX
        wait.until(ExpectedConditions.urlContains("appointment"));
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg)).getText();
    }

    public boolean isLoginButtonEnabled() {
        openLoginPage();
        return driver.findElement(loginBtn).isEnabled();
    }
}