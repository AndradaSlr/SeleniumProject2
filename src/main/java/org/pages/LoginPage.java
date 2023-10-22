package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }
    private By emailAddressInput = By.id("input-email");
    private By passwordInput = By.id("input-password");
    private By loginButtonInput = By.xpath("//input[@value='Login']");
//    private By errorMessage = By.xpath(".//div[@class = 'alert alert-danger alert dismissible']");

    public void insertEmailAddress(String email) {
        driver.findElement(emailAddressInput).sendKeys(email);
    }

    public void insertPasswordInput(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton () {
        driver.findElement(loginButtonInput).click();
    }


}