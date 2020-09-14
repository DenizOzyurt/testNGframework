package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleExample extends TestBase {
//    Create a new Class Tests package: WindowHandleExample
//    Given user is on the https://the-internet.herokuapp.com/windows
//    Then user verifies the text : “Opening a new window”
//    Then user verifies the title of the page is “The Internet”
//    When user clicks on the “Click Here” button
//    Then user verifies the new window title is “New Window”
//    Then user verifies the text:  “New Window”
//    When user goes back to the previous window and then verifies the title : “The Internet”

    @Test
    public void newWindowTest(){
        driver.get("https://the-internet.herokuapp.com/windows");

//        Then user verifies the text : “Opening a new window”
       String newWindowTexT=driver.findElement(By.xpath("//h3")).getText();
       String expextedText="Opening a new window";

        Assert.assertEquals(newWindowTexT,expextedText);

//    Then user verifies the title of the page is “The Internet”
        String titlePage=driver.getTitle();
        System.out.println(titlePage);
        String expectegTitle="The Internet";

        //Check if the expectedTitle equals the actual Title .
        // If they are not equal then print "Title is not correct"
        Assert.assertEquals(titlePage,expectegTitle,"Title is not correct");

        //    When user clicks on the “Click Here” button

        String window1=driver.getWindowHandle(); //This gives current page
        System.out.println("Default Window handle: "+ window1);


        WebElement clickHere=driver.findElement(By.linkText("Click Here"));
        clickHere.click();

        //    Then user verifies the new window title is “New Window”
        //    THE WINDOW OPENS IN A NEW TAB. THIS MEANS WE HAVE TO SWITCH TO NEW WINDOW
        // WE WILL GET ALL OPEN WINDOW HANDLES AND PUT THEM IN A SET.

        Set<String> allWindows=driver.getWindowHandles();
        System.out.println(allWindows);

        //Using for each loop, we can switch to the new window.
        for (String eachWindow:allWindows){
            if(!eachWindow.equals(window1)){
                driver.switchTo().window(eachWindow);
            }
        }

        //    Then user verifies the new window title is “New Window”
        String actualNewPageTitle=driver.getTitle();
        String expectedNewPageTitle="New Window";
        Assert.assertEquals(actualNewPageTitle,expectedNewPageTitle);

        //    Then user verifies the text:  “New Window”
        String actualWindws2text=driver.findElement(By.xpath("//h3")).getText();
        String expectedWindos2text="New Window" ;


//    When user goes back to the previous window and then verifies the title : “The Internet”

        driver.switchTo().window(window1);


    }

}
