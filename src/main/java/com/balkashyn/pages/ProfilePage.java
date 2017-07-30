package com.balkashyn.pages;

import com.balkashyn.pages.base.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage<ProfilePage> {

    private By logo = By.xpath("(//a[@class='logo'])[1]");
    private By advanceSearchButton = By.xpath("//input[@type='button']");
    private By profileContactNameText = By.xpath("//h1[@class='profile-contact-name']");

    public ProfilePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void waitForProfilePageToLoad() {
        log.info("Wait for page is loaded");
        waitForVisibilityOf(logo);
        waitForVisibilityOf(advanceSearchButton, 10);
    }

    public boolean isCorrectProfileIsLoaded(String correctProfileName) {
        log.info("Correct profile page is loaded");
        if (getText(profileContactNameText).equals(correctProfileName)){
            return true;
        }
        return false;
    }
}
