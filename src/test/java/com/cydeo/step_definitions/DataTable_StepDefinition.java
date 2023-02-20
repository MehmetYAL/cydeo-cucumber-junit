package com.cydeo.step_definitions;

import com.cydeo.pages.DropdownPage;
import com.cydeo.utulities.BrowserUtils;
import com.cydeo.utulities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DataTable_StepDefinition {
    @Then("user should see fruits i like")
    public void user_should_see_fruits_i_like(List<String> fruits) {

        System.out.println(fruits);
        System.out.println(fruits.get(1));

    }

    @Given("User is on the dropdowns page of practice tool")
    public void userIsOnTheDropdownsPageOfPracticeTool() {

        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
    }

    
    DropdownPage dropdownPage=new DropdownPage();
    @Then("User should see below info in month dropdown")
    public void userShouldSeeBelowInfoInMonthDropdown(List<String> expectedMonths) {
        //this method will return us the list of string of given dropdown
        List<String> actualMonths = BrowserUtils.dropdownOptionsAsString(dropdownPage.monthDropdown);
        Assert.assertEquals(expectedMonths,actualMonths);
        //Assert will check the size first if it is matching it wil check content 1by1

    }
}
