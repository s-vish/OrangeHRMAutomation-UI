package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordPage {

    public ForgotPasswordPage(WebDriver forgotPasswordPageDriver, WebDriverWait forgotPasswordWait) {
        this.forgotPasswordPageDriver = forgotPasswordPageDriver;
        this.forgotPasswordWait = forgotPasswordWait;
    }

    WebDriver forgotPasswordPageDriver;
    WebDriverWait forgotPasswordWait;

    private static final By USERNAME_TEXTBOX_LOCATOR = By.id("securityAuthentication_userName");
    private static final By RESET_PASSWORD_BUTTON_LOCATOR = By.id("btnSearchValues");
    private static final By CANCEL_BUTTON_LOCATOR = By.id("btnCancel");

    public void doResetPassword(String userName) {
        forgotPasswordWait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_TEXTBOX_LOCATOR)).sendKeys(userName);
        forgotPasswordWait.until(ExpectedConditions.elementToBeClickable(RESET_PASSWORD_BUTTON_LOCATOR)).click();

    }

    public LoginPage cancelResetPassword() {
       forgotPasswordWait.until(ExpectedConditions.elementToBeClickable(CANCEL_BUTTON_LOCATOR)).click ();
        forgotPasswordWait.until(ExpectedConditions.elementToBeClickable(CANCEL_BUTTON_LOCATOR)).click();
        return new LoginPage(forgotPasswordPageDriver, forgotPasswordWait);
    }


}
