package com.orangehrm.test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.utilities.FileReaderClass;
import org.testng.annotations.*;

@Listeners(com.orangehrm.reports.ReportsListners.class)
public class LoginPageTest extends BaseTest {


    @Test(priority = 1, description = "Verify Login and Logout test")
    public void LoginTest() {
       loginPage.doLogin(username,pass).getUserName ().logoutUser ();
    }

    @Test(priority = 2, description ="Verify Reset password flow")
    public void requestForgotPassword()
    {
        loginPage.RestPassword().doResetPassword(username);
    }

    @Test(priority = 3, description = " Verify cancel reset password flow")
    public void cancelForgotPassword()
    {
        loginPage.RestPassword().cancelResetPassword();
    }

}
