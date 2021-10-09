package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public LoginPage(WebDriver loginPageDriver, WebDriverWait loginPageWait) {
        this.loginPageDriver = loginPageDriver;
        this.loginPageWait = loginPageWait;
    }

    private static final By USERNAME_LOCATOR = By.id("txtUsername");
    private static final  By USER_PASSWORD_LOCATOR = By.id("txtPassword");
    private static final By LOGIN_BUTTON_LOCATOR = By.id("btnLogin");
    private static final By FORGOT_PASSWORD_LOCATOR = By.linkText("Forgot your password?");

    private WebDriver loginPageDriver;
    private WebDriverWait loginPageWait;



    public HomePage doLogin(String uname, String pass)
    {
       WebElement userField =  loginPageWait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_LOCATOR));
       userField.sendKeys(uname);

        WebElement passField =  loginPageWait.until(ExpectedConditions.visibilityOfElementLocated(USER_PASSWORD_LOCATOR));
        passField.sendKeys(pass);

        WebElement loginButton =  loginPageWait.until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON_LOCATOR));
        loginButton.click();

        return new HomePage(loginPageDriver, loginPageWait);
    }

    public ForgotPasswordPage RestPassword()
    {
        WebElement forgotPasswordTextField = loginPageWait.until(ExpectedConditions.elementToBeClickable(FORGOT_PASSWORD_LOCATOR));
        forgotPasswordTextField.click();
        return new ForgotPasswordPage(loginPageDriver,loginPageWait);
    }
}
