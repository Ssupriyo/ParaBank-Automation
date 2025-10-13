package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferFundsPage {
    WebDriver driver;

    @FindBy(linkText = "Transfer Funds")
    WebElement transferFundsLink;

    @FindBy(id = "amount")
    WebElement amountField;

    @FindBy(css = "input[value='Transfer']")
    WebElement transferButton;

    @FindBy(xpath = "//h1[contains(text(),'Transfer Complete')]")
    WebElement confirmationMessage;

    public TransferFundsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void transfer(String amount) throws InterruptedException {
        transferFundsLink.click();
        Thread.sleep(2000);
        amountField.clear();
        amountField.sendKeys(amount);
        Thread.sleep(1000);
        transferButton.click();
        Thread.sleep(2000);
    }

    public boolean isTransferSuccessful() {
        try {
            return confirmationMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
