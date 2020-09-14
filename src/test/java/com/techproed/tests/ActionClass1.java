package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionClass1 extends TestBase {
//    Create a class: ActionsClass1
//    Create a test method : contextClickMethod() and test the following scenario:
//    Given user is on the https://the-internet.herokuapp.com/context_menu
//    When use Right clicks on the box
//    Then verify the alert message is “You selected a context menu”
//    Then accept the alert

    @Test
    public void contextClickMethod(){
        //contextClick= right click
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //    When use Right clicks on the box
        Actions actions=new Actions(driver);
        //locate the element
        WebElement box=driver.findElement(By.id("hot-spot"));
        actions.contextClick(box).perform();

        String actualAlertMessage= driver.switchTo().alert().getText();
        String expectedAlertMessage="You selected a context menu";
        Assert.assertEquals(actualAlertMessage,expectedAlertMessage);
        driver.switchTo().alert().accept();

    }


}
