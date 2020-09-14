package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionClass2 extends TestBase {

//    Create a class: ActionClass2
//    Create test method : hoverOver() and test the following scenario:
//    Given user is on the https://www.amazon.com/
//    When use click on “Your Account” link
//    Then verify the page title contains “Your Account”
//    Create another method: imageTest()
//    Hover over the Try Prime
//    And Verify the image displays.

   @Test
   public void hoverTest(){

       driver.get("https://www.amazon.com/");
//    When use click on “Your Account” link
//    Then verify the page title contains “Your Account”

       WebElement hoverOverElement=driver.findElement(By.id("nav-link-accountList"));
       Actions actions = new Actions(driver);
       actions.moveToElement(hoverOverElement).perform();

       //    Then verify the page title contains “Your Account”

       WebElement account=driver.findElement(By.linkText("Your Account"));
       String actualPageTitle=account.getText();
       String expectedPageTitle="Your Account";

       //Verifying your account page title
       Assert.assertEquals(actualPageTitle,expectedPageTitle);

   }

}
