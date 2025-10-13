package com.parabank.tests;

import com.parabank.pages.LoginPage;
import com.parabank.pages.TransferFundsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TransferFundsTests {
    WebDriver driver;
    LoginPage loginPage;
    TransferFundsPage transferPage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        loginPage = new LoginPage(driver);
        transferPage = new TransferFundsPage(driver);
        loginPage.login("Ssupriyoo", "Ssupriyo");
        Thread.sleep(1000);
    }

    @Test
    public void testFundTransfer() throws InterruptedException {
        transferPage.transfer("100");
        Assert.assertTrue(transferPage.isTransferSuccessful(), "Fund transfer failed");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
