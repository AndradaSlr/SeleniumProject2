package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterAccountPage extends BasePage {

    public RegisterAccountPage (WebDriver driver) {
        this.driver = driver;
    }

    private By firstNameInput = By.id("input-firstname");
    private By lastNameInput = By.id("input-lastname");
    private By emailInput = By.id("input-email");
    private By telephoneInput = By.id("input-telephone");
    private By passwordInput = By.id("input-password");
    private By confirmPasswordInput = By.id("input-confirm");
    private By privacyPolicyCheckboxInput = By.xpath("//label[@for='input-agree']");
    private By continueButtonInput = By.xpath("//input[@value='Continue']");
    private By firstNameErrorElement = By.xpath(".//input[@name = 'firstname']/following-sibling::div");
    private By lastNameErrorElement = By.xpath(".//input[@name = 'lastname']/following-sibling::div");
    private By emailErrorElement = By.xpath(".//input[@name = 'email']/following-sibling::div");
    private By telephoneErrorElement = By.xpath(".//input[@name = 'telephone']/following-sibling::div");
    private By passwordErrorElement = By.xpath(".//input[@name = 'password']/following-sibling::div");


    public void insertFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void insertLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void insertEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void insertPhoneNumber(String phoneNumber) {
        driver.findElement(telephoneInput).sendKeys(phoneNumber); }

    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordInput).sendKeys(confirmPassword);
    }
    public void checkPrivacyPolicy () {
        driver.findElement(privacyPolicyCheckboxInput).click();
    }
    public void clickContinueButton () {
        driver.findElement(continueButtonInput).click();
    }

    public String getFirstNameErrorMessage () {
        return driver.findElement(firstNameErrorElement).getText();
    }
    public String getLastNameErrorMessage () {
        return driver.findElement(lastNameErrorElement).getText();
    }
    public String getEmailErrorMessage () {
        return driver.findElement(emailErrorElement).getText();
    }
    public String getTelephoneErrorMessage (){
        return driver.findElement(telephoneErrorElement).getText();
    }
    public String getPasswordErrorMessage () {
        return driver.findElement(passwordErrorElement).getText();
    }
}