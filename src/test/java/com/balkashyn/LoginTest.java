package com.balkashyn;

import com.balkashyn.Base.BaseTest;
import com.balkashyn.pages.LogInPage;
import com.balkashyn.pages.ProfilePage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin(){
        LogInPage logInPage = new LogInPage(driver);
        logInPage.openLogInPage();
        logInPage.fillUpEmailAndPassword("skyaleksandr@gmail.com", "1234qwer");
        ProfilePage profilePage = logInPage.pushSignInButton();
        profilePage.waitForProfilePageToLoad();


    }
}
