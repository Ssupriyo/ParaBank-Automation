package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(name = "username")
    WebElement usernameField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(css = "input[value='Log In']")
    WebElement loginButton;

    @FindBy(linkText = "Log Out")
    WebElement logoutLink;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String user, String pass) throws InterruptedException {
        usernameField.clear();
        usernameField.sendKeys(user);
        Thread.sleep(1000);
        passwordField.clear();
        passwordField.sendKeys(pass);
        Thread.sleep(1000);
        loginButton.click();
        Thread.sleep(2000);
    }

    public boolean isLoggedIn() {
        try {
            return logoutLink.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
