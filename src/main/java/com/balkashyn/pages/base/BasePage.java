package com.balkashyn.pages.base;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage<T> {
    protected WebDriver driver;
    private WebDriverWait waiter;
    protected Logger log;

    protected BasePage(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
        waiter = new WebDriverWait(driver, 30);
    }

    protected T getPage(String url) {
        driver.get(url);
        return (T) this;
    }

    protected void type(String text, By element) {
        find(element).sendKeys(text);
    }

    private WebElement find(By element) {
        return driver.findElement(element);
    }

    protected void click(By signInButton) {
        find(signInButton).click();
    }

    protected void waitForVisibilityOf(By locator, Integer... timeoutInSeconds) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.presenceOfElementLocated(locator), (timeoutInSeconds.length > 0) ? timeoutInSeconds[0] : null);
                break;
            } catch (StaleElementReferenceException ignored) {
                log.error(ignored.getMessage());
            }
            attempts++;
        }
    }

    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeoutInSeconds) {
        timeoutInSeconds = !Objects.isNull(timeoutInSeconds) ? timeoutInSeconds : 30;
        waiter = new WebDriverWait(driver, timeoutInSeconds);
        waiter.until(condition);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    protected String getText(By element) {
        return find(element).getText();
    }
}