package com.cydeo.step_definitions;

import com.cydeo.pages.WebTablePage;
import com.cydeo.utulities.BrowserUtils;
import com.cydeo.utulities.ConfigurationReader;
import com.cydeo.utulities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebTable_StepDefinition {

    WebTablePage webTablePage = new WebTablePage();

    @Given("user is on the login page of web table app")
    public void user_is_on_the_login_page_of_web_table_app() {
        String url = ConfigurationReader.getProperty("webTableUrl");
        Driver.getDriver().get(url);

    }

    @When("user enters username {string}")
    public void user_enters_username(String string) {
        webTablePage.inputusername.sendKeys(string);

    }

    @When("user enters password {string}")
    public void user_enters_password(String string) {
        webTablePage.inputPassword.sendKeys(string);

    }

    @When("user clicks to login button")
    public void user_clicks_to_login_button() {
        webTablePage.loginButton.click();

    }

    @Then("user should see url contains orders")
    public void user_should_see_url_contains_orders() {
        BrowserUtils.verifyURLContains("orders");

    }

    @When("user enters username {string} password {string} and logins")
    public void userEntersUsernamePasswordAndLogins(String username, String password) {

        webTablePage.login(username, password);
    }
}