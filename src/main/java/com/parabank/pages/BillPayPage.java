package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillPayPage {
    WebDriver driver;

    @FindBy(linkText = "Bill Pay")
    WebElement billPayLink;

    @FindBy(name = "payee.name")
    WebElement nameField;

    @FindBy(name = "payee.address.street")
    WebElement addressField;

    @FindBy(name = "payee.address.city")
    WebElement cityField;

    @FindBy(name = "payee.address.state")
    WebElement stateField;

    @FindBy(name = "payee.address.zipCode")
    WebElement zipField;

    @FindBy(name = "payee.phoneNumber")
    WebElement phoneField;

    @FindBy(name = "payee.accountNumber")
    WebElement accountNumberField;

    @FindBy(name = "verifyAccount")
    WebElement verifyAccountField;

    @FindBy(name = "amount")
    WebElement amountField;

    @FindBy(css = "input[value='Send Payment']")
    WebElement sendPaymentButton;

    @FindBy(xpath = "//h1[contains(text(),'Bill Payment Complete')]")
    WebElement paymentSuccessMessage;

    public BillPayPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void payBill(String name, String amount) throws InterruptedException {
        billPayLink.click();
        Thread.sleep(2000);
        nameField.sendKeys(name);
        addressField.sendKeys("123 Main Street");
        cityField.sendKeys("Kolkata");
        stateField.sendKeys("WB");
        zipField.sendKeys("700001");
        phoneField.sendKeys("9999999999");
        accountNumberField.sendKeys("123456");
        verifyAccountField.sendKeys("123456");
        amountField.sendKeys(amount);
        Thread.sleep(1000);
        sendPaymentButton.click();
        Thread.sleep(2000);
    }

    public boolean isPaymentSuccessful() {
        try {
            return paymentSuccessMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
