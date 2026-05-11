import org.testng.Assert;
import org.testng.annotations.Test;

public class TestingZone extends BaseClass {

    // 1. Successful Login

    @Test(priority = 1)

    public void CorrectLogin_01() {

        LoginPage obj01 = new LoginPage(driver);

        obj01.login(
                "John Doe",
                "ThisIsNotAPassword"
        );

        String currentUrl = driver.getCurrentUrl();

        System.out.println(currentUrl);

        Assert.assertTrue(
                currentUrl.contains("appointment")
        );
    }

    // 2. Invalid Login

    @Test(priority = 2)

    public void IncorrectLogin_01() {

        LoginPage obj01 = new LoginPage(driver);

        obj01.login(
                "wronguser",
                "wrongpassword"
        );

        String error = obj01.getErrorMessage();

        System.out.println(error);

        Assert.assertTrue(
                error.contains("Login failed")
        );
    }

    // 3. Logout Test

    @Test(priority = 3)

    public void LogoutTest_01() {

        LoginPage obj01 = new LoginPage(driver);

        obj01.login(
                "John Doe",
                "ThisIsNotAPassword"
        );

        obj01.logout();

        String currentUrl = driver.getCurrentUrl();

        System.out.println(currentUrl);

        Assert.assertEquals(
                currentUrl,
                "https://katalon-demo-cura.herokuapp.com/"
        );
    }

    // 4. Protected Page Access Without Login

    @Test(priority = 4)

    public void ProtectedPageWithoutLoginTest() {

        driver.get(
                "https://katalon-demo-cura.herokuapp.com/#appointment"
        );

        String currentUrl = driver.getCurrentUrl();

        System.out.println(currentUrl);

        Assert.assertTrue(currentUrl.contains("https://katalon-demo-cura.herokuapp.com/#appointment")
        );
    }

    // 5. Appointment Booking

    @Test(priority = 5)

    public void AppointmentBookingTest_02() {

        LoginPage obj01 = new LoginPage(driver);

        obj01.login(
                "John Doe",
                "ThisIsNotAPassword"
        );

        AppointmentPage obj02 = new AppointmentPage(driver);

        obj02.bookWithoutCheckbox(
                "Tokyo CURA Healthcare Center",
                "20/05/2026",
                "General Checkup"
        );

        Assert.assertEquals(
                obj02.getFacilityText(),
                "Tokyo CURA Healthcare Center"
        );

        Assert.assertEquals(
                obj02.getDateText(),
                "20/05/2026"
        );
    }

    // 6. Hospital Admission Booking

    @Test(priority = 6)

    public void HospitalAdmissionBookingTest() {

        LoginPage obj01 = new LoginPage(driver);

        obj01.login(
                "John Doe",
                "ThisIsNotAPassword"
        );

        AppointmentPage obj02 = new AppointmentPage(driver);

        obj02.bookWithCheckbox(
                "Hongkong CURA Healthcare Center",
                "25/05/2026",
                "Dental Checkup"
        );

        Assert.assertEquals(
                obj02.getHospitalReadmissionText(),
                "Yes"
        );
    }

    // 7. Past Date Validation

    @Test(priority = 7)

    public void PastDateBookingTest() {

        LoginPage obj01 = new LoginPage(driver);

        obj01.login(
                "John Doe",
                "ThisIsNotAPassword"
        );

        AppointmentPage obj02 = new AppointmentPage(driver);

        obj02.bookWithoutCheckbox(
                "Seoul CURA Healthcare Center",
                "01/01/2020",
                "Past Date Test"
        );

        String currentUrl = driver.getCurrentUrl();

        System.out.println(currentUrl);

        Assert.assertTrue(
                currentUrl.contains("appointment")
        );
    }
}