package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.OrderPage;
import com.cydeo.pages.WebTablePage;
import com.cydeo.utulities.ConfigurationReader;
import com.cydeo.utulities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Order_StepDefinition {

    WebTablePage webTablePage=new WebTablePage();
    BasePage basePage=new BasePage();

    OrderPage orderPage=new OrderPage();
    @Given("user is already logged in and on order page")
    public void user_is_already_logged_in_and_on_order_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("webTableUrl"));
webTablePage.login();
basePage.order.click();
    }

    @When("user selects product type {string}")
    public void userSelectsProductType(String string) {
        Select select=new Select(orderPage.productDropDown);
        select.selectByVisibleText(string);
    }

    @And("user enters quantity {int}")
    public void userEntersQuantity(int arg) {

        orderPage.quantity.sendKeys("2");

    }

    @And("user enters customer name {string}")
    public void userEntersCustomerName(String string) {
        orderPage.customerName.sendKeys(string);
    }

    @And("user enters street {string}")
    public void userEntersStreet(String string) {
        orderPage.street.sendKeys(string);

    }

    @And("user enters city {string}")
    public void userEntersCity(String string) {
        orderPage.city.sendKeys(string);
    }

    @And("user enters state {string}")
    public void userEntersState(String string) {
        orderPage.state.sendKeys(string);
    }

    @And("user enters zipcode {string}")
    public void userEntersZipcode(String string) {
        orderPage.zipcode.sendKeys(string);
    }

    @And("user selects credit card type {string}")
    public void userSelectsCreditCardType(String expectedcreditCardType) {

        List<WebElement> creditCardTypes = orderPage.creditCardType;

        for (WebElement each : creditCardTypes) {
           if (each.getAttribute("value").equalsIgnoreCase(expectedcreditCardType)){
               each.click();
           }
        }
    }

    @And("user enters credit card number {string}")
    public void userEntersCreditCardNumber(String string) {
        orderPage.cardNo.sendKeys(string);
    }

    @And("user enters expiry date {string}")
    public void userEntersExpiryDate(String string) {
        orderPage.expiryDate.sendKeys(string);
    }

    @And("user enters process order button")
    public void userEntersProcessOrderButton() {
        orderPage.processOrderButton.click();
    }

    @Then("user should see {string} in first row of the web table")
    public void userShouldSeeInFirstRowOfTheWebTable(String string) {
        String actualFirstRow=orderPage.firstRow.getText();
        String expectedFirstRow=string;
        Assert.assertEquals(actualFirstRow,expectedFirstRow);
    }
}
