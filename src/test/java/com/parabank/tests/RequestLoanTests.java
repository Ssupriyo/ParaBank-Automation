package com.parabank.tests;

import com.parabank.pages.LoginPage;
import com.parabank.pages.RequestLoanPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class RequestLoanTests {
    WebDriver driver;
    LoginPage loginPage;
    RequestLoanPage loanPage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        loginPage = new LoginPage(driver);
        loanPage = new RequestLoanPage(driver);
        loginPage.login("Ssupriyoo", "Ssupriyo");
        Thread.sleep(1000);
    }

    @Test
    public void testLoanRequest() throws InterruptedException {
        loanPage.applyForLoan("2000", "500");
        Assert.assertTrue(loanPage.isLoanApproved(), "Loan not approved or processed");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
