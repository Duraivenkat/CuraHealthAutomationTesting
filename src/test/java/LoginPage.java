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

    // Locators

    By appButton = By.id("btn-make-appointment");

    By username = By.id("txt-username");

    By password = By.id("txt-password");

    By loginButton = By.id("btn-login");

    By errorMess = By.xpath("//p[@class='lead text-danger']");

    By menuToggle = By.id("menu-toggle");

    By logoutButton = By.linkText("Logout");

    // Actions

    public void clickMakeAppointment() {

        wait.until(
                ExpectedConditions.elementToBeClickable(appButton)
        ).click();
    }

    public void enterUsername(String user) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(username)
        ).sendKeys(user);
    }

    public void enterPassword(String pass) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(password)
        ).sendKeys(pass);
    }

    public void clickLoginButton() {

        wait.until(
                ExpectedConditions.elementToBeClickable(loginButton)
        ).click();
    }

    // Combined Login

    public void login(String user, String pass) {

        clickMakeAppointment();

        enterUsername(user);

        enterPassword(pass);

        clickLoginButton();
    }

    // Error Message

    public String getErrorMessage() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(errorMess)
        ).getText();
    }

    // Logout

    public void logout() throws InterruptedException {

        wait.until(
                ExpectedConditions.elementToBeClickable(menuToggle)
        ).click();

        Thread.sleep(2000);

        wait.until(
                ExpectedConditions.elementToBeClickable(logoutButton)
        ).click();
    }
}