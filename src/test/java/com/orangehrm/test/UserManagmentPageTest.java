package com.orangehrm.test;

import com.orangehrm.base.BaseTest;
import org.testng.annotations.Test;

public class UserManagmentPageTest  extends BaseTest {


    @Test(priority = 2, description = "User flow")
    public void userManagementFlow(){
        loginPage.doLogin(username,pass).clickOnMainMenu ("Admin").
                clickOnSubMainMenu ( "User Management" )
                .clickOnSubMenu ( "Users" )
                .clickAddButton ()
                .addUserDetails ();

    }
}
