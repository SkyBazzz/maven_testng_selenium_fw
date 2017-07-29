package com.balkashyn.Base;

import com.balkashyn.pages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    public LogInPage logInPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        logInPage = new LogInPage(driver);
    }

    @AfterMethod
    public void tierDown() {
        driver.quit();
    }
}