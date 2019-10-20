package com.live.outlook.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class SignInPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @Getter
    private By loginInput = By.id("i0116");
    @Getter
    private String loginError = "usernameError";
    @Getter
    private String displayName = "displayName";
    @Getter
    private By passwordInput = By.id("i0118");
    @Getter
    private String passwordError = "passwordError";

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void open() {
        driver.get("https://login.live.com/");
    }

    public void clickButton() {
        String attribute = driver
                .findElement(By.id("idSIButton9"))
                .getAttribute("value");
        driver
                .findElement(By.cssSelector
                        ("[value=\"" + attribute + "\"]"))
                .click();
    }

    public boolean containsPageSource(String param) {
        if (driver.getPageSource().contains(param)) {
            wait
                    .until(ExpectedConditions
                            .visibilityOfElementLocated(By.id(param)));
            return true;
        } else return false;
    }

    public void waitDisplayName() {
        if (this.containsPageSource(displayName)) {
            System.out.println("Username: " + driver
                    .findElement(By.id(displayName))
                    .getText());
        } else {
            System.out.println("Wrong page. Id=" + displayName + " doesn't exist");
        }
    }

    public void checkErrors(String errorLocator) {
        if (this.containsPageSource(errorLocator)) {
            System.out.println("Error: " + driver.findElement(By.id(errorLocator)).getText());
        } else {
            System.out.println("No error with id=" + errorLocator);
        }
    }

    public void enterInput(String input, By locator) {

        driver
                .findElement(locator)
                .sendKeys(input);
    }
}
