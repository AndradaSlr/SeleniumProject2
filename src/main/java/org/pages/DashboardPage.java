package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {
        this.driver = driver;

    }

    private By firstSectionHeader = By.xpath(".//div[@id = 'content']/div[1]/h2");
    private By editAccountElement = By.xpath(".//div[@id='content']//a[contains(@href, 'account/edit')]");
    private By changePasswordElement = By.xpath(".//div[@id='content']//a[contains(@href, 'account/password')]");
    private By modifyAddressElement = By.xpath(".//div[@id='content']//a[contains(@href, 'account/address')]");
    private By myWishlistElement = By.xpath(".//div[@id='content']//a[contains(@href, 'account/wishlist')]");
    private By newsletterElement = By.xpath(".//div[@id='content']//a[contains(@href, 'account/newsletter')]");


    private By secondSectionHeader = By.xpath(".//div[@id = 'content']/div[2]/h2");
    private By viewOrderHistoryElement = By.xpath(".//div[@id='content']//a[contains(@href, 'account/order')]");
    private By downloadsElement = By.xpath(".//div[@id='content']//a[contains(@href, 'account/download')]");
    private By rewardPointsElement = By.xpath(".//div[@id='content']//a[contains(@href, 'account/reward')]");
    private By viewReturnRequestsElement = By.xpath(".//div[@id='content']//a[contains(@href, 'account/return')]");
    private By transactionsElement = By.xpath(".//div[@id='content']//a[contains(@href, 'account/transaction')]");
    private By recurringPaymentsElement = By.xpath(".//div[@id='content']//a[contains(@href, 'account/recurring')]");


    private By thirdSectionHeader = By.xpath(".//div[@id = 'content']/div[3]/h2");
    private By registerForAnAffiliateAccountElement = By.xpath(".//div[@id='content']//a[contains(@href, 'account/affiliate/add')]");



    public String getFirstSectionHeaderText() {
        return driver.findElement(firstSectionHeader).getText();
    }

    public String getEditAccountElementText() {
        return driver.findElement(editAccountElement).getText();
    }

    public String getChangePasswordElementText() {
        return driver.findElement(changePasswordElement).getText();
    }

    public String getModifyAddressElementText() {
        return driver.findElement(modifyAddressElement).getText();
    }

    public String getMyWishlistElementText() {
        return driver.findElement(myWishlistElement).getText();
    }

    public String getNewsletterElementText() { return driver.findElement(newsletterElement).getText();}


    public String getSecondSectionHeaderText() { return driver.findElement(secondSectionHeader).getText();}
    public String getViewOrderHistoryText() { return driver.findElement(viewOrderHistoryElement).getText();}
    public String getDownloadsText() { return driver.findElement(downloadsElement).getText();}
    public String getRewardPointsText() { return driver.findElement(rewardPointsElement).getText();}
    public String getReturnRequestsText() { return driver.findElement(viewReturnRequestsElement).getText();}
    public String getTransactionsText() { return driver.findElement(transactionsElement).getText();}
    public String getRecurringPaymentsText() { return driver.findElement(recurringPaymentsElement).getText();}


    public String getThirdSectionHeaderText() { return driver.findElement(thirdSectionHeader).getText();}
    public String getRegisterForAnAffiliateAccountText() {return driver.findElement(registerForAnAffiliateAccountElement).getText();}





}



