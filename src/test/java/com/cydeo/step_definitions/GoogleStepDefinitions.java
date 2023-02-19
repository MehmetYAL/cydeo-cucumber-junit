package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utulities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class GoogleStepDefinitions {
GoogleSearchPage googleSearchPage=new GoogleSearchPage();

    @When("user types {string} and clicks enter")
    public void userTypesAndClicksEnter(String searcKeyword) {
        googleSearchPage.searchBox.sendKeys(searcKeyword+Keys.ENTER);
    }

    @Then("user sees {string} in the google title")
    public void userSeesInTheGoogleTitle(String string) {
        String expectedTitle =string+" - Google Search";
        String actualTitle=Driver.getDriver().getTitle();

        //JUnit assertion accpets first expectedTitle than actualTitle
        Assert.assertEquals("Title is not as we axpected!",expectedTitle,actualTitle);


    }

    @When("user types apple and clicks enter")
    public void user_types_apple_and_clicks_enter() {
        googleSearchPage.searchBox.sendKeys("apple"+Keys.ENTER);

    }
    @Then("user sees apple in the google title")
    public void user_sees_apple_in_the_google_title() {
String expectedTitle ="apple - Google Search";
        String actualTitle=Driver.getDriver().getTitle();

        //JUnit assertion accpets first expectedTitle than actualTitle
        Assert.assertEquals("Title is not as we axpected!",expectedTitle,actualTitle);

    }

    @When("user on Google search page")
    public void user_on_google_search_page() {
        Driver.getDriver().get("https://www.google.com");
    }
    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {
        String expectedTitle="Google";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

        Driver.closeDriver();
    }


}
