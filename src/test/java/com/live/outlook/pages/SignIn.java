package com.live.outlook.pages;

import com.live.outlook.utils.WebDriverSettings;
import org.junit.*;
import org.openqa.selenium.support.PageFactory;

public class SignIn extends WebDriverSettings {
    //Enter login, password, locale
    //U can get existed login and password on email
    private String login = "";
    private String password = "";
    private String locale = "en";

    public SignIn() {
        super.setLocale(locale);
    }

    @Test
    public void errorLogin() {
    }

    @Test
    public void titleTest() {
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.open();
        String actualTitle = driver.getTitle();
        //Expected Title with locale "en".
        // If you are testing with locale "ru", hide 28th line and open 29th line!
        String expectedTitle = "Sign in to your Microsoft account";
//        String expectedTitle = "Вход в учетную запись Майкрософт";
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void signIn() {
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.open();
        signInPage.enterInput(login, signInPage.getLoginInput());
        signInPage.clickButton();
        signInPage.checkErrors(signInPage.getLoginError());
    }

    @Test
    public void enterPassword() {
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        this.signIn();
        signInPage.waitDisplayName();
        signInPage.enterInput(password, signInPage.getPasswordInput());
        signInPage.clickButton();
        signInPage.checkErrors(signInPage.getPasswordError());
    }
}
