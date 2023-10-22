import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pages.DashboardPage;
import org.pages.RegisterAccountPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static util.TestUtil.generateRandomEmail;


public class DashboardTests {
    private WebDriver driver;
    private RegisterAccountPage registerAccountPage;
    private DashboardPage dashboardPage;

 @BeforeClass
    public void setUp() {
        System.out.println("Initialize driver");
        driver = new ChromeDriver();
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");
     registerAccountPage = new RegisterAccountPage(driver);
     dashboardPage = new DashboardPage(driver);
        createdAccount();
    }


    @Test
    public void verifyDashboardFirstSection () {
        String expectedFirstSectionHeaderText = "My Account";
        String expectedEditAccountText = "Edit your account information";
        String expectedChangePasswordText = "Change your password";
        String expectedModifyAddressText = "Modify your address book entries";
        String expectedMyWishlistText = "Modify your wish list";
        String expectedNewsletterText = "Subscribe / unsubscribe to newsletter";
        driver.navigate().to("https://ecommerce-playground.lambdatest.io/index.php?route=account/account");

        Assert.assertEquals(dashboardPage.getFirstSectionHeaderText(), expectedFirstSectionHeaderText,
                "First section header text is not the expected one");
        Assert.assertEquals(dashboardPage.getEditAccountElementText(), expectedEditAccountText,
                "Edit account element text is not the expected one");
        Assert.assertEquals(dashboardPage.getChangePasswordElementText(), expectedChangePasswordText,
                "Change password text is not the expected one");
        Assert.assertEquals(dashboardPage.getModifyAddressElementText(), expectedModifyAddressText,
                "Modify address text is not the expected one");
        Assert.assertEquals(dashboardPage.getMyWishlistElementText(), expectedMyWishlistText,
                "My wishlist text is not the expected one");
        Assert.assertEquals(dashboardPage.getNewsletterElementText(), expectedNewsletterText,
                "Newsletter text is not the expected one");
    }

    @Test
    public void verifyDashboardSecondSections () {
        String expectedSecondSectionHeaderText = "My Orders";
        String expectedViewOrdersHistoryText = "View your order history";
        String expectedDownloadsText = "Downloads";
        String expectedRewardPointsText = "Your Reward Points";
        String expectedReturnRequestsText = "View your return requests";
        String expectedTransactionsTexts = "Your Transactions";
        String expectedRecurringPaymentsText = "Recurring payments";


        Assert.assertEquals(dashboardPage.getSecondSectionHeaderText(), expectedSecondSectionHeaderText,
                "Second section header text is not the expected one");
        Assert.assertEquals(dashboardPage.getViewOrderHistoryText(), expectedViewOrdersHistoryText,
                "View order history element text is not the expected one");
        Assert.assertEquals(dashboardPage.getDownloadsText(), expectedDownloadsText,
                "Downloads element text is not the expected one");
        Assert.assertEquals(dashboardPage.getRewardPointsText(), expectedRewardPointsText,
                "Reward points element text is not the expected one");
        Assert.assertEquals(dashboardPage.getReturnRequestsText(), expectedReturnRequestsText,
                "Return requests element text is not the expected one");
        Assert.assertEquals(dashboardPage.getTransactionsText(), expectedTransactionsTexts,
                "Transactions element text is not the expected one");
        Assert.assertEquals(dashboardPage.getRecurringPaymentsText(), expectedRecurringPaymentsText,
                "Recurring payments element text is not the expected one");

    }

    @Test
    public void verifyDashboardThirdSections () {
        String expectedThirdSectionHeaderText = "My Affiliate Account";
        String expectedRegisterForAnAffiliateAccountText = "Register for an affiliate account";

        Assert.assertEquals(dashboardPage.getThirdSectionHeaderText(), expectedThirdSectionHeaderText,
                "Third section header text is not the expected one");
        Assert.assertEquals(dashboardPage.getRegisterForAnAffiliateAccountText(), expectedRegisterForAnAffiliateAccountText,
                "Register for an affiliate account element text is not the expected one");

    }

    public void createdAccount() {
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



