package com.cydeo.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class Hooks {
    /*
    in the class we will be able to pass pre&post cponditions to each scenario and each step
     */
    @Before //import from io.cuucumber.java not from junit
    public void setupScenario(){
        System.out.println("=== setting up browser using cucumber @Before");
    }
    @Before (value = "@login",order = 1)
    public void setupSceanarioForLogins(){
        System.out.println("=== this will onlt apply to scenarios wth @login tag");
    }

    @Before (value = "@db",order = -1)
    public void setupForDataaseScenarios(){
        System.out.println("=== this will onlt apply to scenarios wth @login tag");
    }

    @After
    public void teardownScenario(){
        System.out.println("===closing browser using @After");
        System.out.println("======Scenario ended/Take screenshot if failed");
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