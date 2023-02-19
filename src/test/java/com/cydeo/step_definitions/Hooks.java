package com.cydeo.step_definitions;

import com.cydeo.utulities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    /*
    in the class we will be able to pass pre&post conditions to each scenario and each step
     */
    @Before //import from io.cuucumb
    // er.java not from junit
    public void setupScenario(){
        System.out.println("=== setting up browser using cucumber @Before");
    }
    @Before (value = "@login",order = 1)
    public void setupSceanarioForLogins(){
        System.out.println("=== this will onlt apply to scenarios wth @login tag");
    }

    @Before (value = "@db",order = -1)
    public void setupForDatabaseScenarios(){
        System.out.println("=== this will onlt apply to scenarios wth @login tag");
    }

    @After
    public void teardownScenario(Scenario scenario){

        //when scenario failed
        if (scenario.isFailed()){
    byte[] screenshot=((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
    scenario.attach(screenshot,"image/png", scenario.getName());

}



        //System.out.println("===closing browser using @After");
        //System.out.println("======Scenario ended/Take screenshot if failed");
        Driver.closeDriver();
    }

    @BeforeStep
    public void setupStep(){
        System.out.println("-----------applying setup using @BeforeStep");
    }

    @AfterStep
    public void afterStep(){
        System.out.println("-------------applying teardown using @Afterstep");
    }

}
