package com.balkashyn.pages.base;

import java.net.MalformedURLException;
import java.net.URI;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserFactory {

    private BrowserFactory() {
    }

    public static WebDriver getDriver(String browser, Logger log) throws MalformedURLException {
        WebDriver driver;
        log.info("Starting: " + browser + " driver");

        switch (browser) {
            case "firefox":
                DesiredCapabilities fireFox = new DesiredCapabilities();
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
                DesiredCapabilities defaultCap = new DesiredCapabilities();
                defaultCap.setBrowserName("chrome");
                defaultCap.setVersion("64.0");
                defaultCap.setCapability("enableVNC", true);

                driver = new RemoteWebDriver(
                        URI.create("http://localhost:4444/wd/hub")
                           .toURL(),
                        defaultCap
                );
                break;
        }
        return driver;
    }
}