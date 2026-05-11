import org.testng.Assert;
import org.testng.annotations.Test;

public class TestingZone extends BaseClass {

    @Test(priority = 1)
    public void CorrectLogin_01() {

        LoginPage obj01 = new LoginPage(driver);
        obj01.login(
                "John Doe",
                "ThisIsNotAPassword"
        );
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("appointment")
        );
    }

    @Test(priority = 2)
    public void IncorrectLogin_01() {

        LoginPage obj01 = new LoginPage(driver);
        obj01.login(
                "wronguser",
                "wrongpassword"
        );
        String error = obj01.getErrorMessage();
        Assert.assertTrue(error.contains("Login failed")
        );
    }

    @Test(priority = 3)
    public void LogoutTest_01() {
        LoginPage obj01 = new LoginPage(driver);

        obj01.login(
                "John Doe",
                "ThisIsNotAPassword"
        );

        obj01.logout();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("homepage")
        );
    }

    @Test(priority = 4)
    public void AppointmentBookingTest_02() {

        LoginPage obj01 = new LoginPage(driver);

        obj01.login(
                "John Doe",
                "ThisIsNotAPassword"
        );
        AppointmentPage obj02 = new AppointmentPage(driver);
        obj02.bookwithoutcheckbox(
                "Tokyo CURA Healthcare Center",
                "20/05/2026",
                "General Checkup"
        );
        Assert.assertEquals(obj02.getFacilityText(), "Tokyo CURA Healthcare Center");
        Assert.assertEquals(obj02.getDateText(), "20/05/2026");
    }

    @Test(priority = 5)
    public void HospitalAdmissionBookingTest() {

        LoginPage obj01 = new LoginPage(driver);
        obj01.login(
                "John Doe",
                "ThisIsNotAPassword"
        );
        AppointmentPage obj02 = new AppointmentPage(driver);
        obj02. bookWithCheckbox(
                "Hongkong CURA Healthcare Center",
                "25/05/2026",
                "Dental Checkup"
        );

    }
}