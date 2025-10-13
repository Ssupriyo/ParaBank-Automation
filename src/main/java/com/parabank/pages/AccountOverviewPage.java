package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountOverviewPage {
    WebDriver driver;

    @FindBy(linkText = "Accounts Overview")
    WebElement accountOverviewLink;

    @FindBy(xpath = "//h1[contains(text(),'Accounts Overview')]")
    WebElement overviewHeader;

    public AccountOverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openAccountOverview() throws InterruptedException {
        accountOverviewLink.click();
        Thread.sleep(2000);
    }

    public boolean isOverviewDisplayed() {
        try {
            return overviewHeader.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
