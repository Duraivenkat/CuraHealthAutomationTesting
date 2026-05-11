import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage
{
    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }
    //Locators for an login
    By MenuButton = By.id("btn-make-appointment");
    By username = By.id("txt-username");
    By password = By.id("txt-password");
    By LoginButton = By.id("btn-login");
    By ErrorMessage = By.xpath("//p[@class='lead text-danger']");


    // action code for an login
    public void menuButton() {
        driver.findElement(MenuButton).click();
    }
    public void enterUsername(String user) {
        driver.findElement(username).sendKeys(user);
    }
    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }
    public void LoginButton() {
        driver.findElement(LoginButton).click();
    }

    // complete action high level of code
    public void login(String user, String pass) {
        menuButton();
        enterUsername(user);
        enterPassword(pass);
        LoginButton();


    }

    // seperate erroe message function
    public String ErrorMessage() {

        return driver.findElement(errorMessage).getText();
        ToggleButton();
    }
}
