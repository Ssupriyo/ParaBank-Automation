package com.parabank.tests;

import com.parabank.pages.BillPayPage;
import com.parabank.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class BillPayTests {
    WebDriver driver;
    LoginPage loginPage;
    BillPayPage billPayPage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        loginPage = new LoginPage(driver);
        billPayPage = new BillPayPage(driver);
        loginPage.login("Ssupriyoo", "Ssupriyo");
        Thread.sleep(1000);
    }

    @Test
    public void testBillPayment() throws InterruptedException {
        billPayPage.payBill("Electric Company", "500");
        Assert.assertTrue(billPayPage.isPaymentSuccessful(), "Bill payment failed");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
