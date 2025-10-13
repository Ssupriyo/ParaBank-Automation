package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestLoanPage {
    WebDriver driver;

    @FindBy(linkText = "Request Loan")
    WebElement requestLoanLink;

    @FindBy(id = "amount")
    WebElement loanAmountField;

    @FindBy(id = "downPayment")
    WebElement downPaymentField;

    @FindBy(css = "input[value='Apply Now']")
    WebElement applyButton;

    @FindBy(xpath = "//h1[contains(text(),'Loan Request Processed')]")
    WebElement loanProcessedMessage;

    public RequestLoanPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void applyForLoan(String amount, String downPayment) throws InterruptedException {
        requestLoanLink.click();
        Thread.sleep(2000);
        loanAmountField.sendKeys(amount);
        downPaymentField.sendKeys(downPayment);
        Thread.sleep(1000);
        applyButton.click();
        Thread.sleep(2000);
    }

    public boolean isLoanApproved() {
        try {
            return loanProcessedMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
