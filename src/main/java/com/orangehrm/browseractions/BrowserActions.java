package com.orangehrm.browseractions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserActions {

    private WebDriver driver;
    private WebDriverWait wait;

    public BrowserActions(WebDriver driver, WebDriverWait wait) {

        this.driver = driver;
        this.wait = wait;
    }

    public void clickOnElement(By elementLocator)
    {
        try
        {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
            element.click();
        }
        catch (NoSuchElementException e)
        {
            e.printStackTrace();
        }
    }

    public void clickOnElement(WebElement element){
        try
        {
            WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(element));
            ele.click();
        }
        catch (NoSuchElementException e)
        {
            e.printStackTrace();
        }
    }

    public void enterText(By elementLocator, String text)
    {
        try{
            WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
            ele.sendKeys(text);
        }
        catch (NoSuchElementException e)
        {
            e.printStackTrace();
        }
    }

    public String readText(By elementLocator)
    {
        String str= null;
        try{
           WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
            str = ele.getText();
        }
        catch (NoSuchElementException e)
        {
            e.printStackTrace();
        }
        return  str;
    }

}
