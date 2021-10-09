package com.orangehrm.test;

import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class Runner {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 15);
        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginPage = new LoginPage(driver, wait);
    }

    @AfterMethod
    public void flush()
    {
        driver.close();
    }

    @Test(priority = 1)
    public void runTest()
    {
        loginPage.doLogin("Admin","admin123").getUserName ().logoutUser ();
    }

    @Test(priority = 2)
    public void requestForgotPassword()
    {
        loginPage.RestPassword().doResetPassword();
    }

    @Test(priority = 3)
    public void cancelForgotPassword()
    {
        loginPage.RestPassword().cancelResetPassword();
    }
}
