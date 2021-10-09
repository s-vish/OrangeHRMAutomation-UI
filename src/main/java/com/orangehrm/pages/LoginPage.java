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

    private static final By USERNAMELOCATOR = By.id("txtUsername");
    private static final  By USERPASSWORDLOCATOR = By.id("txtPassword");
    private static final By LOGINBUTTONLOCATOR = By.id("btnLogin");

    private WebDriver loginPageDriver;
    private WebDriverWait loginPageWait;



    public HomePage doLogin(String uname, String pass)
    {
       WebElement userField =  loginPageWait.until(ExpectedConditions.visibilityOfElementLocated(USERNAMELOCATOR));
       userField.sendKeys(uname);

        WebElement passField =  loginPageWait.until(ExpectedConditions.visibilityOfElementLocated(USERPASSWORDLOCATOR));
        passField.sendKeys(pass);

        WebElement loginButton =  loginPageWait.until(ExpectedConditions.elementToBeClickable(LOGINBUTTONLOCATOR));
        loginButton.click();

        return new HomePage(loginPageDriver, loginPageWait);

    }
}
