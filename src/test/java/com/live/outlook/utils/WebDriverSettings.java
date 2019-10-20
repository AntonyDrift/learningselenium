package com.live.outlook.utils;

import lombok.Getter;
import lombok.Setter;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverSettings {

    public WebDriver driver;
    public WebDriverWait wait;
    @Setter
    private String locale;

    @Before
    public void init() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/com/live/outlook/mozila/geckodriver");
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("intl.accept_languages", locale);
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        driver = new FirefoxDriver(options);
    }

    @After
    public void quit() {

//        driver.quit();
    }
}
