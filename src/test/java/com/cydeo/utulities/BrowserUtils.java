package com.cydeo.utulities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {

    public static void sleep(int seconds){

        seconds *= 1000;
        try{
            Thread.sleep(seconds);
        }catch (InterruptedException e){
        }
    }
    /*
    This method accepts 3 arguments.
    Arg1: webdriver
    Arg2: expectedInUrl : for verify if the url contains given String.
        - If condition matches, will break loop.
    Arg3: expectedInTitle to be compared against actualTitle
     */
    public static void switchWindowAndverify( String expectefInUrl, String expectedTitle){
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowHandles) {
            Driver.getDriver().switchTo().window(each);

            System.out.println("current URl "+Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectefInUrl)){
                break;
            }
        }

        //5. Assert: Title contains “expectedTitle”

        String actuallTitle=Driver.getDriver().getTitle();
        Assert.assertTrue(actuallTitle.contains(expectedTitle));
        //This method accepts a String "expectedTitle" and Assert if it true


    }

    public static void verifyTitle(String expectedTitle){

        Assert.assertEquals(Driver.getDriver().getTitle(),expectedTitle);
    }

    /*
    Creating a utulity method for explictWait so we dont have to repeat the lines
     */
    public static void waitForInvisibilityOfF(WebElement webElement){
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));

    }

}
