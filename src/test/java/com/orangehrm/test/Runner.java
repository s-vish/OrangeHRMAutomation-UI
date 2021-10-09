package com.orangehrm.test;

import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Runner {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    WebDriverWait wait;

    @Test
    public void runTest()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 15);
        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginPage = new LoginPage(driver, wait);
        loginPage.doLogin("Admin","admin123").clickOnMainMenu ("Admin").
                clickOnSubMainMenu ( "User Management" )
                .clickOnSubMenu ( "Users" )
                .getUserName ().logoutUser ();

        driver.close ();

    }
}
