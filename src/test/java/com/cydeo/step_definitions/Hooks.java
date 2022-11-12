package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {

    @After
    public void teardownScenario(Scenario scenario){
        //we will implement taking screenshot in this method
        //System.out.println("It will be closing browser using cucumber @After each scenario")
        byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        if(scenario.isFailed()) {
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
     Driver.closeDriver();
    }

    // @Before ()
    public void setupScenario(){
        System.out.println("Setting up browser using cucumber @Before each scenario");
        Driver.getDriver().get("URL of your app");

    }
    //@AfterStep
    public void afterStep(){
        System.out.println("--------> applying tearDown using @AfterStep");
    }


  // @Before (value = "@login", order=2)
    public void setupForLogin(){
         //If you want any code to run before any specific feature/scenario,
        // you can use value= "@tagname" to determine this
        System.out.println("====this will only apply to scenarios with @login tag");
    }

  // @Before (value="@db" , order=3)
    public void setupDatabaseScenario(){
        System.out.println("====this will only apply to scenarios with @db tag");
    }

    //@BeforeStep
    public void setupScenarioStep(){
        System.out.println("--------> applying setup using @BeforeStep");
    }





}
