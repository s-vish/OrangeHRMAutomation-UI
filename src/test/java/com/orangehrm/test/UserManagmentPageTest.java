package com.orangehrm.test;

import com.orangehrm.base.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.orangehrm.reports.ReportsListners.class)
public class UserManagmentPageTest  extends BaseTest {


    @Test(priority = 2, description = "Verify user flow")
    public void userManagementFlow(){
        loginPage.doLogin(username,pass).clickOnMainMenu ("Admin").
                clickOnSubMainMenu ( "User Management" )
                .clickOnSubMenu ( "Users" )
                .clickAddButton ()
                .addUserDetails ();

    }
}
