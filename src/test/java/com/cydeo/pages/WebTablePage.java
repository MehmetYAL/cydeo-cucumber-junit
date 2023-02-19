package com.cydeo.pages;

import com.cydeo.utulities.ConfigurationReader;
import com.cydeo.utulities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablePage {

    public WebTablePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "username")
    public WebElement inputusername;

@FindBy(name = "password")
    public WebElement inputPassword;

 @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButton;

    /**
     * No parameters.
     * When we call this method, it will directly login using
     *
     * Username: Test
     * Password: Tester
     */
 public void login(){
this.inputusername.sendKeys("Test");
this.inputPassword.sendKeys("Tester");
this.loginButton.click();
 }

    /**
     * This method will accept two arguments and login.
     * @param username
     * @param password
     */
 public void login(String username,String password){
inputusername.sendKeys(username);
inputPassword.sendKeys(password);
loginButton.click();
 }

    /**
     * This method will log in using credentials from
     * configuration.properties
     */
    public void loginWithConfig(){
        inputusername.sendKeys(ConfigurationReader.getProperty("webTableUsername"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("webTablePassword"));
        loginButton.click();
    }




}
