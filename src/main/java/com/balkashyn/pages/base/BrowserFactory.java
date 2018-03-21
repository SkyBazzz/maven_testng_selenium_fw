package com.balkashyn.pages.base;

import java.net.MalformedURLException;
import java.net.URI;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
    //    public static WebDriver getDriver(String browser, Logger log) throws MalformedURLException {
//        WebDriver driver;
//        log.info("Starting: " + browser + " driver");
//
//        switch (browser) {
//            case "firefox":
////                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
////              DesiredCapabilities firefox = DesiredCapabilities.firefox();
//                WebDriverManager.firefoxdriver().setup();
////              driver = new RemoteWebDriver(new URL("http://localhost:5556/wd/hub"), firefox);
//                driver = new FirefoxDriver();
//                break;
//            case "chrome":
////                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
////                DesiredCapabilities chrome = DesiredCapabilities.chrome();
//                WebDriverManager.chromedriver().setup();
////                driver = new RemoteWebDriver(new URL("http://localhost:5555/wd/hub"), chrome);
//                driver = new ChromeDriver();
//                break;
//            default:
//                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//                driver = new ChromeDriver();
//                break;
//        }
//        return driver;
//    }
    public static WebDriver getDriver(String browser, Logger log) throws MalformedURLException {
        WebDriver driver;
        log.info("Starting: " + browser + " driver");

        switch (browser) {
            case "firefox":
//                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                DesiredCapabilities fireFox = new DesiredCapabilities().firefox();
                fireFox.setBrowserName("firefox");
                fireFox.setVersion("59.0");
                fireFox.setCapability("enableVNC", true);

                driver = new RemoteWebDriver(
                        URI.create("http://localhost:4444/wd/hub").toURL(),
                        fireFox
                );
                break;
            case "chrome":
                DesiredCapabilities chrome = new DesiredCapabilities();
                chrome.setBrowserName("chrome");
                chrome.setVersion("64.0");
                chrome.setCapability("enableVNC", true);

                driver = new RemoteWebDriver(
                        URI.create("http://localhost:4444/wd/hub").toURL(),
                        chrome
                );
                break;
            default:
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }
        return driver;
    }
}