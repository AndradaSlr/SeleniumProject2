import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pages.LoginPage;
import org.pages.RegisterAccountPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {

//private WebDriver driver();
  WebDriver driver = new ChromeDriver();


    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");
    }

    @Test

    public void loginFields () {

        WebDriver driver = new ChromeDriver();
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.insertEmailAddress ("johndoe2@email.com");
        loginPage.insertPasswordInput("Password1234!");
        loginPage.clickLoginButton();
        String actualValue = loginPage.getErrorMessage();
        String expectedValue = " Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one");

    }

    @Test
    public void invalidCredentialsTest () {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.insertEmailAddress("random@email.com");
        loginPage.insertPasswordInput("randomPassword");
        loginPage.clickLoginButton();
        String actualValue = loginPage.getErrorMessage();
        String expectedValue = "Warning: no match for E-mail Address and/or Password";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one");
    }
}
