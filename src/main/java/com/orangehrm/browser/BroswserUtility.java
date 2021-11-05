package com.orangehrm.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BroswserUtility {

    private WebDriver driver;
    private WebDriverWait wait;


    public BroswserUtility ( WebDriver driver , WebDriverWait wait ) {
        super();
        this.driver = driver;
        this.wait = wait;
    }

    public void clickOnElement( By locator){
        try {
            WebElement element = wait.until( ExpectedConditions.elementToBeClickable ( locator ) );
            element.click ();
        }catch (RuntimeException e){
            e.printStackTrace ();
            throw new RuntimeException ( "Unable to locate the element with the given Locator" );
        }

    }
    public boolean isElementPresent(By locator){
        WebElement element = null;
        try {
            element = wait.until ( ExpectedConditions.visibilityOfElementLocated ( locator ) );
        }catch (NoSuchElementException e){
            throw new RuntimeException ( "Element is not present" );
        }
        return element != null;
    }

    public void enterText(By locator, String textToEnter) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.clear();
            element.sendKeys(textToEnter);
        } catch (NoSuchElementException e) {
            System.out.println("Unable to locate the element with the given elementLocator");
        }
    }

    public String readAtttibute(By locator, String attribute) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

            return element.getAttribute(attribute);

        } catch (NoSuchElementException e) {
            System.out.println("Unable to locate the element with the given elementLocator");
        }
        return attribute;

    }

    public String readVisibleText(By locator) {
        String text = null;
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

            text = element.getText();

        } catch (NoSuchElementException e) {
            System.out.println("Unable to locate the element with the given elementLocator");
        }
        return text;
    }


}
