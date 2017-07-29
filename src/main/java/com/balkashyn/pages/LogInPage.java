package com.balkashyn.pages;

import com.balkashyn.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends BasePage<LogInPage> {

    private static final String url = "https://www.dice.com/dashboard/login";

    private By emailField = By.xpath("//input[@id = 'email']");
    private By passwordField = By.xpath("//input[@id = 'password']");
    private By signInButton = By.xpath("//button[@type = 'submit']");
    private By errorMessage = By.xpath("//span[@data-automation-id = 'login-failure-help-message']");

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void openLogInPage() {
        getPage(url);
    }

    public void fillUpEmailAndPassword(String email, String password) {
        System.out.println("Entering profile data");
        type(email, emailField);
        type(password, passwordField);
    }

    public ProfilePage pushSignInButton(){
        System.out.println("Submit profile data");
        click(signInButton);
        return new ProfilePage(driver);
    }

    public String getLogInErrorMessage() {
        waitForVisibilityOf(errorMessage, 10);
        return getText(errorMessage);
    }
}
