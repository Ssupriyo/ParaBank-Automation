package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegisterPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(linkText = "Register") WebElement registerLink;
    @FindBy(id = "customer.firstName") WebElement firstNameField;
    @FindBy(id = "customer.lastName") WebElement lastNameField;
    @FindBy(id = "customer.address.street") WebElement addressField;
    @FindBy(id = "customer.city") WebElement cityField;
    @FindBy(id = "customer.state") WebElement stateField;
    @FindBy(id = "customer.zipCode") WebElement zipField;
    @FindBy(id = "customer.phoneNumber") WebElement phoneField;
    @FindBy(id = "customer.ssn") WebElement ssnField;
    @FindBy(id = "customer.username") WebElement usernameField;
    @FindBy(id = "customer.password") WebElement passwordField;
    @FindBy(id = "repeatedPassword") WebElement confirmPasswordField;
    @FindBy(css = "input[value='Register']") WebElement registerButton;
    @FindBy(xpath = "//h1[contains(text(),'Welcome')]") WebElement successMessage;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void openRegistrationForm() {
        wait.until(ExpectedConditions.elementToBeClickable(registerLink)).click();
    }

    public void fillFormAndRegister() {
        wait.until(ExpectedConditions.visibilityOf(firstNameField)).sendKeys("Supriyo");
        lastNameField.sendKeys("Automation");
        addressField.sendKeys("Bangalore");
        cityField.sendKeys("Bangalore");
        stateField.sendKeys("KA");
        zipField.sendKeys("560064");
        phoneField.sendKeys("123456789");
        ssnField.sendKeys("987456");
        usernameField.sendKeys("AutomationUser");
        passwordField.sendKeys("AutomationPass");
        confirmPasswordField.sendKeys("AutomationPass");
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
    }

    public boolean isRegistrationSuccessful() {
        try {
            wait.until(ExpectedConditions.visibilityOf(successMessage));
            return successMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
