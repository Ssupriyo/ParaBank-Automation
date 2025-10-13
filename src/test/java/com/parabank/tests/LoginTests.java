package com.parabank.tests;

import com.parabank.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        loginPage = new LoginPage(driver);
        Thread.sleep(1000);
    }

    @Test
    public void testValidLogin() throws InterruptedException {
        loginPage.login("Ssupriyoo", "Ssupriyo");
        Assert.assertTrue(loginPage.isLoggedIn(), "Login failed");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
