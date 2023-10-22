import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pages.AccountCreatedPage;
import org.pages.RegisterAccountPage;
import org.testng.Assert;
import org.testng.annotations.*;
import static util.TestUtil.generateRandomEmail;
public class RegisterAccountTests {

 private WebDriver driver;

    //    Am declarat obiectul regAccPage la nivel de clasa pt a avea acces in orice metoda, dar nu l-am initializat
//    se initializeaza in before method
    private RegisterAccountPage registerAccountPage;
    private String loginPageURL = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";


    @BeforeClass
    public void setUp() {
        System.out.println("Initialize driver");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Navigate to" + loginPageURL);
        driver.navigate().to(loginPageURL);
        registerAccountPage = new RegisterAccountPage(driver);
    }


    @Test

    public void registerNewAccountMandatoryFields() throws Exception {
//       WebDriver driver = new ChromeDriver();
//        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("0745168174");
        registerAccountPage.setPassword("Password123");
        registerAccountPage.setConfirmPassword("Password123");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinueButton();
        //  Thread.sleep(5000);
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        String actualText = accountCreatedPage.getParagraphText();
        String expectedText = "Congratulations! Your new account has been successfully created!";
        Assert.assertEquals(actualText, expectedText, "Actual text is not the expected one.");

    }

    @Test
    public void registerWithoutPrivacyPolicyTest() throws InterruptedException {
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        System.out.println("Used email is:" + generateRandomEmail());
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("0123456789");
        registerAccountPage.setPassword("Password1234!");
        registerAccountPage.setConfirmPassword("Password1234!");
        registerAccountPage.clickContinueButton();
        Thread.sleep(2000);
        String actualValue = registerAccountPage.getErrorMessage();
        String expectedValue = "Warning: You must agree to the Privacy Policy!";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one");

    }

    @Test

    public void registerAccountWithoutFirstNameTest() {
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("0123456789");
        registerAccountPage.setPassword("Password1234!");
        registerAccountPage.setConfirmPassword("Password1234!");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinueButton();
        String actualValue = registerAccountPage.getFirstNameErrorMessage();
        String expectedValue = "First name must be between 1 and 32 characters";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one");

    }

    @Test

    public void registerAccountWithoutLastNameTest() {
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("0123456789");
        registerAccountPage.setPassword("Password1234!");
        registerAccountPage.setConfirmPassword("Password1234!");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinueButton();
        String actualValue = registerAccountPage.getLastNameErrorMessage();
        String expectedValue = "Last name must be between 1 and 32 characters";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one");
    }

    @Test

    public void registerWithoutEmailTest() {
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertPhoneNumber("0123456789");
        registerAccountPage.setPassword("Password1234!");
        registerAccountPage.setConfirmPassword("Password1234!");
        registerAccountPage.clickContinueButton();
        String actualValue = registerAccountPage.getEmailErrorMessage();
        String expectedValue = "E-mail Address does not appear to be valid";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one");
    }

    @Test

    public void registerAccountTelephoneNumberTest() {
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.setPassword("Password1234!");
        registerAccountPage.setConfirmPassword("Password1234!");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinueButton();
        String actualValue = registerAccountPage.getTelephoneErrorMessage();
        String expectedValue = "Telephone must be between 3 and 32 characters";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one");
    }

    @Test

    public void registerWithoutPasswordTest() {
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("0123456789");
        registerAccountPage.setConfirmPassword("Password1234!");
        registerAccountPage.clickContinueButton();
        String actualValue = registerAccountPage.getPasswordErrorMessage();
        String expectedValue = "Password must be between 4 and 20 characters!";
        Assert.assertEquals(actualValue, expectedValue, "Error message is not the expected one");
    }

        @AfterTest
        public void tearDown () {
            driver.quit();
        }
    }

