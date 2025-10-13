package com.parabank.tests;

import com.parabank.pages.AccountOverviewPage;
import com.parabank.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AccountOverviewTests {
    WebDriver driver;
    LoginPage loginPage;
    AccountOverviewPage overviewPage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        loginPage = new LoginPage(driver);
        overviewPage = new AccountOverviewPage(driver);
        loginPage.login("Ssupriyoo", "Ssupriyo");
        Thread.sleep(1000);
    }

    @Test
    public void testAccountOverviewVisible() throws InterruptedException {
        overviewPage.openAccountOverview();
        Assert.assertTrue(overviewPage.isOverviewDisplayed(), "Account overview not displayed");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
