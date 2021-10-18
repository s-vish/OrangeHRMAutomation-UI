package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AdminPage {

    private static final By ADD_BUTTON_LOCATOR = By.xpath ( "//input[@id='btnAdd']");
    private static final By USERROLE_LOCATOR = By.id ( "systemUser_userType" );
    private static final By EMPLOYEENAME_LOCATOR = By.id ( "systemUser_employeeName_empName" );
    private static final By EMPLOYEENAME_RESULT_LOCATOR = By.xpath ( "//div[@class='ac_results']" );
    private static final By USERNAME_LOCATOR = By.id ( "systemUser_userName" );
    private static final By STATUS_LOCATOR = By.id ("systemUser_status" );
    private static final By PASSWORD_LOCATOR = By.id ( "systemUser_password" );
    private static final By CONFIRMPASSWORD_LOCATOR = By.id ( "systemUser_confirmPassword" );
    private static final By SAVEBUTTON_LOCATOR = By.id ( "btnSave" );

    private static final By SEARCHUSER_LOCATOR = By.id ( "searchSystemUser_userName" );
    private static final By SEARCHBUTTON_LOCATOR = By.id ( "searchBtn" );
    private static final By SELECT_USERNAME_CHECKBOX_LOCATOR = By.xpath ( "//input[@name='chkSelectRow[]']" );
    private static final By DELETEBUTTON_LOCATOR = By.id ( "btnDelete" );
    private static final By CONFIRMATION_POPUP_LOCATOR = By.xpath ( "//div[@id='deleteConfModal']//div[@class='modal-body']" );
    private static final By CONFIRMATION_OK_LOCATOR = By.id ( "dialogDeleteBtn" );


    private WebDriver adminPageDriver;
    private WebDriverWait adminPageWait;

    public static String userName;

    public AdminPage ( WebDriver adminPageDriver , WebDriverWait adminPageWait ) {
        this.adminPageDriver = adminPageDriver;
        this.adminPageWait = adminPageWait;
    }

    public AdminPage clickAddButton(){
        adminPageWait.until ( ExpectedConditions.elementToBeClickable ( ADD_BUTTON_LOCATOR ) ).click ();
        return new AdminPage (adminPageDriver,adminPageWait );
    }

    public AdminPage addUserDetails(){
        selectUserRole ();
        adminPageWait.until ( ExpectedConditions.visibilityOfElementLocated ( EMPLOYEENAME_LOCATOR ) ).
                sendKeys ( "TEST" );
        adminPageWait.until ( ExpectedConditions.visibilityOfElementLocated ( EMPLOYEENAME_RESULT_LOCATOR ) ).click ();
        adminPageWait.until ( ExpectedConditions.visibilityOfElementLocated ( USERNAME_LOCATOR ) ).sendKeys ( "TESTUSERTEST" );
        selectStatus ();
        adminPageWait.until ( ExpectedConditions.visibilityOfElementLocated ( PASSWORD_LOCATOR ) ).sendKeys ( "!@#$%^&*()TEST1234" );
        adminPageWait.until ( ExpectedConditions.visibilityOfElementLocated ( CONFIRMPASSWORD_LOCATOR ) ).sendKeys ( "!@#$%^&*()TEST1234" );
        adminPageWait.until ( ExpectedConditions.elementToBeClickable ( SAVEBUTTON_LOCATOR ) ).click ();
        System.out.println ("User has been added successfully!!" );
        adminPageWait.until ( ExpectedConditions.visibilityOfElementLocated ( SEARCHUSER_LOCATOR ) ).sendKeys ( "TESTUSERTEST" );
        adminPageWait.until ( ExpectedConditions.elementToBeClickable ( SEARCHBUTTON_LOCATOR ) ).click ();
        adminPageWait.until ( ExpectedConditions.visibilityOfElementLocated (  SELECT_USERNAME_CHECKBOX_LOCATOR) ).click ();
        adminPageWait.until ( ExpectedConditions.elementToBeClickable ( DELETEBUTTON_LOCATOR ) ).click ();
        adminPageWait.until ( ExpectedConditions.visibilityOfElementLocated ( CONFIRMATION_POPUP_LOCATOR ) );
        adminPageWait.until ( ExpectedConditions.visibilityOfElementLocated ( CONFIRMATION_OK_LOCATOR ) ).click ();
        System.out.println ("User has been deleted successfully!!" );
        return new AdminPage ( adminPageDriver,adminPageWait );
    }

    private void selectUserRole(){
        WebElement selectUserRole =  adminPageWait.until ( ExpectedConditions.visibilityOfElementLocated ( USERROLE_LOCATOR ) );
        List < WebElement > selectRole = new Select ( selectUserRole ).getOptions ();
        for (int index =0 ;index <selectRole.size ();index++){
            selectRole.get ( index ).click ();
        }
    }

    private void selectStatus(){
        WebElement selectUserStatus =  adminPageWait.until ( ExpectedConditions.visibilityOfElementLocated ( STATUS_LOCATOR ) );
        List < WebElement > selectStatus = new Select ( selectUserStatus ).getOptions ();
        for (int index =0 ;index <selectStatus.size ();index++){
            selectStatus.get ( index ).click ();
        }
    }

//    public void enterUserNameAndSearch(){
//        adminPageWait.until ( ExpectedConditions.visibilityOfElementLocated ( SEARCHUSER_LOCATOR ) ).sendKeys ( "TESTUSER" );
//        adminPageWait.until ( ExpectedConditions.elementToBeClickable ( SEARCHBUTTON_LOCATOR ) ).click ();
//    }



}
