package com.parabank.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import com.parabank.pages.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class RegisterTests {
    WebDriver driver;
    RegisterPage registerPage;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("ParaBank")); // wait until page is loaded
        registerPage = new RegisterPage(driver);
        Thread.sleep(5000);
    }

    @Test
    public void testUserRegistration() {
        registerPage.openRegistrationForm();
        registerPage.fillFormAndRegister();
        Assert.assertTrue(registerPage.isRegistrationSuccessful(), "Registration failed!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
