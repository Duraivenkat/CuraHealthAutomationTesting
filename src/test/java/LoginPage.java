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
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    // Locatorss for login page
    By appButton = By.id("btn-make-appointment");
    By username = By.id("txt-username");
    By password = By.id("txt-password");
    By loginbutton = By.id("btn-login");
    By errorMess = By.xpath("//p[@class='lead text-danger']");
    By menuToggle = By.id("menu-toggle");
    By logoutButton = By.linkText("Logout");

    // actions for login pages
    public void clickMakeAppointment() {
        wait.until(ExpectedConditions.elementToBeClickable(appButton)).click();
    }
    public void enterUsername(String user) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(user);
    }
    public void enterPassword(String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pass);
    }
    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginbutton)).click();
    }

    // combined codee for login

    public void login(String user, String pass) {

        clickMakeAppointment();
        enterUsername(user);
        enterPassword(pass);
        clickLoginButton();
    }

    // method for error
    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMess)).getText();
    }

    // method for logout button
    public void logout() {

        wait.until(ExpectedConditions.elementToBeClickable(menuToggle)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }
}