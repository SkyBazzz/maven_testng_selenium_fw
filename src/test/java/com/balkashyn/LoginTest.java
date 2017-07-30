package com.balkashyn;

import com.balkashyn.base.BaseTest;
//import com.balkashyn.base.CsvDataProvider;
import com.balkashyn.base.CsvDataProvider;
import com.balkashyn.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginTest extends BaseTest {

    public static final String PROFILE_NAME = "Test Test";

    @Test(priority = 1, groups = {"positive"})
    public void validLogin() {
        String expectedTitle = "Seeker Dashboard - Profile";
        logInPage.openLogInPage();
        logInPage.fillUpEmailAndPassword("skyaleksandr@gmail.com", "1234qwer");
        ProfilePage profilePage = logInPage.pushSignInButton();
        profilePage.waitForProfilePageToLoad();

        log.info("Verifications");

        String actualTitle = profilePage.getTitle();

        Assert.assertTrue(expectedTitle.equals(actualTitle),
                "Page title is not expected.\nExpected: " + expectedTitle + "\nActual: " + actualTitle + ".");

        Assert.assertTrue(profilePage.isCorrectProfileIsLoaded(PROFILE_NAME), "Profile name is not expected.");
    }

    @Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class, priority = 2, groups = {"negative"})
    public void invalidLogin(Map<String, String> testData) {
        String expectedErrorMessage = "Email and/or password incorrect.";
        String number = testData.get("number");
        String email = testData.get("email");
        String password = testData.get("password");
        String description = testData.get("description");

        System.out.println("Run " + description + " test #" + number + "With email: " + email + " and password:" + password);

        logInPage.openLogInPage();
        logInPage.fillUpEmailAndPassword(email, password);
        logInPage.pushSignInButton();

        String actualErrorMessage = logInPage.getLogInErrorMessage();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "Error message is not expected.\nExpected: " + expectedErrorMessage + "\nActual: " + actualErrorMessage + ".");
    }

}
