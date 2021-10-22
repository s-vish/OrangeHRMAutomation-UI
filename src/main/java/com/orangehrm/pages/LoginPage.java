package com.orangehrm.pages;

import com.orangehrm.browseractions.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BrowserActions {

    private static final By USERNAME_LOCATOR = By.id("txtUsername");
    private static final By USER_PASSWORD_LOCATOR = By.id("txtPassword");
    private static final By LOGIN_BUTTON_LOCATOR = By.id("btnLogin");
    private static final By FORGOT_PASSWORD_LOCATOR = By.linkText("Forgot your password?");


    private WebDriver loginPageDriver;
    private WebDriverWait loginPageWait;

    public LoginPage(WebDriver loginPageDriver, WebDriverWait loginPageWait) {
        super(loginPageDriver, loginPageWait);
        this.loginPageDriver = loginPageDriver;
        this.loginPageWait = loginPageWait;
    }

    public HomePage doLogin(String uname, String pass)
    {

        enterText(USERNAME_LOCATOR, uname);
        enterText(USER_PASSWORD_LOCATOR, pass);
        clickOnElement(LOGIN_BUTTON_LOCATOR);
        return new HomePage(loginPageDriver, loginPageWait);
    }

    public ForgotPasswordPage RestPassword()
    {
        clickOnElement(FORGOT_PASSWORD_LOCATOR);
        return new ForgotPasswordPage(loginPageDriver,loginPageWait);
    }
}
