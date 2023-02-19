package com.cydeo.pages;

import com.cydeo.utulities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiSearchPage {
    public WikiSearchPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="searchInput")
    public WebElement searchButton;

    @FindBy(xpath = "//button[@class='pure-button pure-button-primary-progressive']")
    public WebElement clickButton;

    @FindBy(id="firstHeading")
    public WebElement headerMain;

}
