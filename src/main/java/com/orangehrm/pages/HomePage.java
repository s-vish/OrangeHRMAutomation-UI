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
   // private static final By MAINMENU_LOCATOR = By.xpath ( "//b[text()='Admin']" );

    private String mainMenu="//b[text()='%value%']";
    private String subMainMenu ="//a[text()='%value%']";
    private String subMenu = "//a[text()='%value%']";

    public HomePage clickOnMainMenu(String value){
        homePageWait.until ( ExpectedConditions.elementToBeClickable ( By.xpath ( mainMenu.replace ( "%value%",value) ) ) ).click ();
        return this;
    }

    public HomePage clickOnSubMainMenu(String value){
        homePageWait.until ( ExpectedConditions.elementToBeClickable ( By.xpath ( subMainMenu.replace ( "%value%",value) ) ) ).click ();
        return this;
    }
    public AdminPage clickOnSubMenu(String value){
        homePageWait.until ( ExpectedConditions.elementToBeClickable ( By.xpath ( subMenu.replace ( "%value%",value) ) ) ).click ();
        return new AdminPage(homePageDriver,homePageWait);
    }

    public HomePage getUserName(){
        WebElement userName = homePageWait.until ( ExpectedConditions.elementToBeClickable ( NAME_LOCATOR ) );
        userName.click ();
        return new HomePage ( homePageDriver,homePageWait );
    }

    public LoginPage logoutUser(){
        homePageWait.until ( ExpectedConditions.elementToBeClickable ( LOGOUT_LOCATOR ) ).click ();
        return new LoginPage ( homePageDriver,homePageWait );
    }

//    public HomePage clickOnMainMenu(){
//        homePageWait.until ( ExpectedConditions.presenceOfElementLocated ( MAINMENU_LOCATOR ) ).click ();
//        return new HomePage ( homePageDriver,homePageWait );
//    }


}
