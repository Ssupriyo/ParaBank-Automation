package com.parabank.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import com.parabank.pages.RegisterPage;

public class RegisterTests {
    WebDriver driver;
    RegisterPage registerPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
        registerPage = new RegisterPage(driver);
    }

    @Test
    public void testUserRegistration() {
        registerPage.register("John", "Doe", "john123", "password123");
        Assert.assertTrue(driver.getPageSource().contains("Your account was created successfully."));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
