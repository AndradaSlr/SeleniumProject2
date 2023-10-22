import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pages.RegisterAccountPage;
import org.pages.SearchResultsPage;
import org.pages.WishlistPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static util.TestUtil.generateRandomEmail;

public class WishlistFlowsTests {

    WebDriver driver = new ChromeDriver();
    private RegisterAccountPage registerAccountPage;
    private WishlistPage wishlistPage;
    private SearchResultsPage searchResultsPage;

    private String loginPageURL = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";


    @BeforeClass
    public void setUp() {
        System.out.println("Initialize driver");
        driver = new ChromeDriver();
        registerAccountPage = new RegisterAccountPage(driver);
        wishlistPage = new WishlistPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");
        createdAccount();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Navigate to" + loginPageURL);
        driver.get(loginPageURL);

    }

    @Test

    public void addItemToWishlist () {
        wishlistPage.clickWishlist();
        String actualResult = wishlistPage.getNoResultsElementText();
        String expectedResult = "No results!";
        Assert.assertEquals(actualResult, expectedResult, "Text from element is not the expected one");
        wishlistPage.enterTextToSearch("Apple Cinema 30\"");
        wishlistPage.clickSearchButton();
        searchResultsPage.clickFirstItem();

    }

    public void createdAccount () {
        System.out.println("Creating new account to be used in tests");
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("0123456789");
        registerAccountPage.setPassword("Password1234!");
        registerAccountPage.setConfirmPassword("Password1234!");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinueButton();

    }
}
