package com.orangehrm.pages;

import com.orangehrm.browseractions.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordPage extends BrowserActions {

    public ForgotPasswordPage(WebDriver forgotPasswordPageDriver, WebDriverWait forgotPasswordWait) {
        super(forgotPasswordPageDriver, forgotPasswordWait);
        this.forgotPasswordPageDriver = forgotPasswordPageDriver;
        this.forgotPasswordWait = forgotPasswordWait;
    }

    WebDriver forgotPasswordPageDriver;
    WebDriverWait forgotPasswordWait;

    private static final By USERNAME_TEXTBOX_LOCATOR = By.id("securityAuthentication_userName");
    private static final By RESET_PASSWORD_BUTTON_LOCATOR = By.id("btnSearchValues");
    private static final By CANCEL_BUTTON_LOCATOR = By.id("btnCancel");

    public void doResetPassword(String userName) {

        enterText(USERNAME_TEXTBOX_LOCATOR, userName);
        clickOnElement(RESET_PASSWORD_BUTTON_LOCATOR);

    }

    public LoginPage cancelResetPassword() {
        clickOnElement(CANCEL_BUTTON_LOCATOR);
        return new LoginPage(forgotPasswordPageDriver, forgotPasswordWait);
    }


}
