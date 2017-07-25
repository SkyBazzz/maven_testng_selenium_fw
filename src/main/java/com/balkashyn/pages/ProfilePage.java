package com.balkashyn.pages;

import com.balkashyn.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage  extends BasePage<ProfilePage> {

    private By logo = By.xpath("(//a[@class = 'logo'])[1]");
    private By advanceSearchButton = By.xpath("//input[@type= 'button']");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void waitForProfilePageToLoad(){
        waitForVisibilityOf(logo);
        waitForVisibilityOf(advanceSearchButton, 10);
    }
}
