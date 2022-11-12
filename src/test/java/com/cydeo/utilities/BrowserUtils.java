package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {
    //Methods are static. Because we do not want to create an object to call those methods.
    // We just want to call those methods with class name. That is why they are static type


    /**
     * This method is used to pause the code for given seconds
     * It is static method we can call with class name
     * BrowserUtils.sleep(3);
     * @param seconds
     */
    public static void sleep(int seconds){
        // 1 second = 1000 millis
        // millis = seconds*1000
        try {
            Thread.sleep(seconds*1000);
        }catch(InterruptedException e){
            e.printStackTrace();
            System.out.println("Exception happened in sleep method!");
        }
    }

    //Method info:
    //• Name: switchWindowAndVerify
    //• Return type: void
    //• Arg1: expectedUrl
    //• Arg2: expectedTitle
    // BrowserUtils.verifyTitle(driver,"Google")
    public static void switchWindowAndVerify (String expectedUrl,String expectedTitle){
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
        for (String eachWindow : allWindowHandles) {
            //Driver.getDriver().switchTo().window(eachWindow); synthax will switch each window and driver will be able to
            Driver.getDriver().switchTo().window(eachWindow);
            if(Driver.getDriver().getCurrentUrl().contains(expectedUrl)){
                break;
            }
        }
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue("Title Verification failed",actualTitle.contains(expectedTitle));
    }

    public static void waitForInvisibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    //Method info:
    //• Name: verifyTitle()
    //• Return type: void
    //• Arg1: WebDriver
    //• Arg2: String expectedTitle
    // BrowserUtils.verifyTitle(driver,"Google")
    public static void verifyTitle(String expectedTitle){

        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

    }

    /**
     * This method will accept dropdown as a webelement and return all the options' text in a List of String
     * @param dropdownElement
     * @return List<String>
     */
    public static List<String> dropdownOptionsAsString (WebElement dropdownElement){

        Select select =new Select(dropdownElement);

        //List of all ACTUAL month <options> as a WebElement
        List<WebElement> actualOptionsAsWebElement =select.getOptions();

        //List of all ACTUAL month options as a String
        List<String> actualOptionsAsString = new ArrayList<>();

        //f with using for loop we will convert each WebElement of options to String with using getText() method
        //with using add() method we will add each String option in List<String> actual options as String

        for (WebElement eachWebElement : actualOptionsAsWebElement) {
            actualOptionsAsString.add(eachWebElement.getText());

        }
        return actualOptionsAsString;
    }

    /**
     * This method will accept a group of radio buttons as a List<WebElement>
     * it will loop through the List, and click to the radio button with provided attribute value
     * @param radioButtons
     * @param attributeValue
     */
    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue){

        for (WebElement each : radioButtons ) {
            if(each.getAttribute("value").equalsIgnoreCase(attributeValue)){
                each.click();
            }
        }


}
}