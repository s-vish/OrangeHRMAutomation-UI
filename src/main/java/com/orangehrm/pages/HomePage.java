package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    public HomePage(WebDriver homePageDriver, WebDriverWait homePageWait) {
        this.homePageDriver = homePageDriver;
        this.homePageWait = homePageWait;
    }

    private WebDriver homePageDriver;
    private WebDriverWait homePageWait;

    private static final By NAME_LOCATOR = By.id ( "welcome" );
    private static final By LOGOUT_LOCATOR = By.xpath ( "//a[normalize-space()='Logout']" );

    public HomePage getUserName(){
        WebElement userName = homePageWait.until ( ExpectedConditions.elementToBeClickable ( NAME_LOCATOR ) );
        userName.click ();
        return new HomePage ( homePageDriver,homePageWait );
    }

    public LoginPage logoutUser(){
        homePageWait.until ( ExpectedConditions.elementToBeClickable ( LOGOUT_LOCATOR ) ).click ();
        return new LoginPage ( homePageDriver,homePageWait );
    }
}
