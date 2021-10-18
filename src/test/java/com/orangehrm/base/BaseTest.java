package com.orangehrm.base;

import com.orangehrm.pages.LoginPage;
import com.orangehrm.utilities.FileReaderClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public LoginPage loginPage;

    public static String username = FileReaderClass.propertiesReader("userName");
    public static String pass = FileReaderClass.propertiesReader("password");

    @BeforeMethod
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Long.parseLong(FileReaderClass.propertiesReader("wait")));
        driver.get(FileReaderClass.propertiesReader("URL"));
        loginPage = new LoginPage(driver, wait);
    }

    @AfterMethod
    public void flush()
    {
        driver.close();
    }
}
