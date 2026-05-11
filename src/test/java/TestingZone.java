import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestingZone extends BaseClass {

    // MODULE 1
    @Test
    public void validLogin() {
        LoginPage lp = new LoginPage(driver);
        lp.login("John Doe", "ThisIsNotAPassword");
        Assert.assertTrue(driver.getCurrentUrl().contains("appointment"));
    }

    @Test
    public void invalidLogin() {
        LoginPage lp = new LoginPage(driver);
        lp.login("wrong", "wrong");
        Assert.assertTrue(lp.getErrorMessage().length() > 0);
    }

    @Test
    public void logoutTest() {
        LoginPage lp = new LoginPage(driver);
        lp.login("John Doe", "ThisIsNotAPassword");

        driver.findElement(By.id("menu-toggle")).click();
        driver.findElement(By.linkText("Logout")).click();

        Assert.assertEquals(driver.getCurrentUrl(),
                "https://katalon-demo-cura.herokuapp.com/");
    }

    @Test
    public void protectedPageTest() {
        driver.get("https://katalon-demo-cura.herokuapp.com/#appointment");
        Assert.assertTrue(driver.getPageSource().contains("Login"));
    }

    // MODULE 2
    @Test
    public void appointmentTest() {
        LoginPage lp = new LoginPage(driver);
        lp.login("John Doe", "ThisIsNotAPassword");

        AppointmentPage ap = new AppointmentPage(driver);
        ap.book("Tokyo CURA Healthcare Center", "15/06/2026", "Checkup", false);

        Assert.assertEquals(ap.getFacility(), "Tokyo CURA Healthcare Center");
    }

    @Test
    public void hospitalCheckTest() {
        LoginPage lp = new LoginPage(driver);
        lp.login("John Doe", "ThisIsNotAPassword");

        AppointmentPage ap = new AppointmentPage(driver);
        ap.book("Hongkong CURA Healthcare Center", "20/06/2026", "Dental", true);

        Assert.assertEquals(ap.getHospital(), "Yes");
    }

    @Test
    public void pastDateTest() {
        LoginPage lp = new LoginPage(driver);
        lp.login("John Doe", "ThisIsNotAPassword");

        AppointmentPage ap = new AppointmentPage(driver);
        ap.book("Seoul CURA Healthcare Center", "01/01/2020", "Past", false);

        Assert.assertTrue(driver.getPageSource().contains("Appointment Confirmation"));
    }

    // MODULE 3
    @Test
    public void historyTest() {
        LoginPage lp = new LoginPage(driver);
        lp.login("John Doe", "ThisIsNotAPassword");

        HistoryPage hp = new HistoryPage(driver);
        hp.openHistory();

        Assert.assertFalse(hp.isHistoryLoaded());
    }

    // MODULE 4
    @Test
    public void multipleAppointments() {
        LoginPage lp = new LoginPage(driver);
        lp.login("John Doe", "ThisIsNotAPassword");

        AppointmentPage ap = new AppointmentPage(driver);

        ap.book("Tokyo CURA Healthcare Center", "15/06/2026", "A", false);

        driver.get("https://katalon-demo-cura.herokuapp.com/#appointment");

        ap.book("Hongkong CURA Healthcare Center", "20/06/2026", "B", false);

        HistoryPage hp = new HistoryPage(driver);
        hp.openHistory();

        Assert.assertTrue(hp.isHistoryLoaded());
    }

    // MODULE 5
    @Test
    public void emptyLoginTest() {
        LoginPage lp = new LoginPage(driver);
        Assert.assertTrue(lp.isLoginButtonEnabled());
    }

    @Test
    public void emptyDateTest() {
        LoginPage lp = new LoginPage(driver);
        lp.login("John Doe", "ThisIsNotAPassword");

        AppointmentPage ap = new AppointmentPage(driver);
        ap.book("Tokyo CURA Healthcare Center", "", "test", false);

        Assert.assertTrue(driver.getCurrentUrl().contains("appointment"));
    }

    @Test
    public void longCommentTest() {
        LoginPage lp = new LoginPage(driver);
        lp.login("John Doe", "ThisIsNotAPassword");

        AppointmentPage ap = new AppointmentPage(driver);

        String longText = "A".repeat(500);
        ap.book("Tokyo CURA Healthcare Center", "15/06/2026", longText, false);

        Assert.assertTrue(ap.getCommentText().length() > 200);
    }
}