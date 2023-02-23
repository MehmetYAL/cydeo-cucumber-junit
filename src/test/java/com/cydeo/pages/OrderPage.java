package com.cydeo.pages;

import com.cydeo.utulities.BrowserUtils;
import com.cydeo.utulities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends BasePage{
    public OrderPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }
   @FindBy(css = "select[name='product']")
    public WebElement productDropDown;

    @FindBy(name = "quantity")
    public WebElement quantity;

    @FindBy(xpath = "//input[@placeholder='Full name of the customer']")
    public WebElement customerName;

    @FindBy(xpath = "//input[@placeholder='Street address of the customer']")
    public WebElement street;

    @FindBy(xpath = "//input[@placeholder='City where the customer lives']")
    public WebElement city;

    @FindBy(xpath = "//input[@placeholder='State where the customer lives']")
    public WebElement state;

    @FindBy(name = "zip")
    public WebElement zipcode;
 //*[@id="root"]/section/div/form/div/div[1]/div[3]/div[1]/div/label[3]/input
    @FindBy(name = "card")
    public List<WebElement> creditCardType;


    @FindBy(xpath = "//input[@placeholder='The number on the card']")
    public WebElement cardNo;

    @FindBy(xpath = "//input[@placeholder='e.g. 04/24']")
    public WebElement expiryDate;

    @FindBy(css = "button[type='submit']")
    public WebElement processOrderButton;




}
