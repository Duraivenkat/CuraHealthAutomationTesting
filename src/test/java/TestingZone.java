import org.testng.Assert;
import org.testng.annotations.Test;

public class TestingZone extends BaseClass {

    @Test(priority = '1')
    public void CorrectLogin_01() {

        LoginPage obj01 = new LoginPage(driver);
        obj01.login(
                "John Doe",
                "ThisIsNotAPassword"
        );
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("appointment"));
    }

    @Test(priority = '2')
    public void IncorrectLogin_01() {

        LoginPage obj02 = new LoginPage(driver);
        obj02.login(
                "xxxxyyyzzz",
                "xxpasswordyy"
        );
        String errorMessage = obj02.ErrorMessage();
        Assert.assertTrue(errorMessage.contains("Login failed"));
    }
}
