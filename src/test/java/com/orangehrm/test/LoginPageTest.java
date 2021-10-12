package com.orangehrm.test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.utilities.FileReaderClass;
import org.testng.annotations.*;

public class LoginPageTest extends BaseTest {


    @Test(priority = 1, description = "Login and Logout test")
    public void LoginTest() {
       loginPage.doLogin(username,pass).getUserName ().logoutUser ();
    }

    @Test(priority = 3, description ="Reset password flow")
    public void requestForgotPassword()
    {
        loginPage.RestPassword().doResetPassword(username);
    }

    @Test(priority = 4, description = "cancel reset password flow")
    public void cancelForgotPassword()
    {
        loginPage.RestPassword().cancelResetPassword();
    }

}
