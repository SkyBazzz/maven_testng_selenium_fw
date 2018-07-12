package com.balkashyn.base;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.balkashyn.pages.LogInPage;
import com.balkashyn.pages.base.BrowserFactory;

public class BaseTest {

    private WebDriver driver;
    protected LogInPage logInPage;
    protected Logger log;

    @BeforeClass(alwaysRun = true)
    protected void serUpClass(ITestContext testContext){
        String testName = testContext.getCurrentXmlTest().getName();
        log = Logger.getLogger(testName);

    }

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(String browser) {
        log.info("Method set up");
        try {
            driver = BrowserFactory.getDriver(browser, log);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        logInPage = new LogInPage(driver, log);
    }

    @AfterMethod(alwaysRun = true)
    public void tierDown() {
        log.info("Method tier down");
        driver.quit();
    }
}