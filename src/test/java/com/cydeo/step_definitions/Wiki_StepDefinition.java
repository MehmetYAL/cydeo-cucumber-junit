package com.cydeo.step_definitions;

import com.cydeo.pages.WikiSearchPage;
import com.cydeo.utulities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Wiki_StepDefinition {

    WikiSearchPage wikiSearchPage=new WikiSearchPage();
    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get("https://www.wikipedia.org");
    }
    @When("User types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String string) {
        wikiSearchPage.searchButton.sendKeys(string);

    }
    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikiSearchPage.clickButton.click();

    }
    @Then("User sees {string} is in the wiki title")
    public void user_sees_is_in_the_wiki_title(String string) {

        //verifing actual title contains string
        Assert.assertTrue(Driver.getDriver().getTitle().contains(string));


    }


    @Then("User sees {string} is in the main header")
    public void userSeesIsInTheMainHeader(String string) {

        Assert.assertTrue(wikiSearchPage.headerMain.isDisplayed());
        Assert.assertTrue(wikiSearchPage.headerMain.getText().equals(string));

    }
}
