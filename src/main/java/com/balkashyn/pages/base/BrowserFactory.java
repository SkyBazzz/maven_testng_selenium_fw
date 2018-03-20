package com.balkashyn.pages.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserFactory {
    public static WebDriver getDriver(String browser, Logger log) throws MalformedURLException {
        WebDriver driver;
        log.info("Starting: " + browser + " driver");

        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                DesiredCapabilities firefox = DesiredCapabilities.firefox();
                driver = new RemoteWebDriver(new URL("http://localhost:5556/wd/hub"), firefox);
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                DesiredCapabilities chrome = DesiredCapabilities.chrome();
                driver = new RemoteWebDriver(new URL("http://localhost:5555/wd/hub"), chrome);
                break;
            default:
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }
        return driver;
    }
}