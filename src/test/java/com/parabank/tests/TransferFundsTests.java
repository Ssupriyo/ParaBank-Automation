package com.parabank.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import com.parabank.pages.LoginPage;
import com.parabank.pages.TransferFundsPage;

public class TransferFundsTests {
    WebDriver driver;
    LoginPage loginPage;
    TransferFundsPage transferPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        loginPage = new LoginPage(driver);
        loginPage.login("john", "demo");
        transferPage = new TransferFundsPage(driver);
    }

    @Test
    public void testTransferFunds() {
        transferPage.transfer("100", "12345", "54321");
        Assert.assertTrue(transferPage.getConfirmation().contains("successful"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
