package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    public HomePage(WebDriver homePageDriver, WebDriverWait homePageWait) {
        this.homePageDriver = homePageDriver;
        this.homePageWait = homePageWait;
    }

    private WebDriver homePageDriver;
    private WebDriverWait homePageWait;

    public void welcomeHome()
    {
        System.out.println("Home page loaded");
    }
}
