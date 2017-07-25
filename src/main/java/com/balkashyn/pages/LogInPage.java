package com.balkashyn.pages;

import com.balkashyn.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends BasePage<LogInPage> {

    private static final String url = "https://www.dice.com/dashboard/login";

    private By emailField = By.xpath("//input[@id = 'email']");
    private By passwordField = By.xpath("//input[@id = 'password']");
    private By signInButton = By.xpath("//button[@type = 'submit']");

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void openLogInPage() {
        getPage(url);
    }

    public void fillUpEmailAndPassword(String email, String password) {
        type(email, emailField);
        type(password, passwordField);
    }

    public ProfilePage pushSignInButton(){
        click(signInButton);
        return new ProfilePage(driver);
    }
}
