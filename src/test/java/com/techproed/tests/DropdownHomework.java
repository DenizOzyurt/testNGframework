package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DropdownHomework {
//    • Use Different Test Method for each Test Case
//• Go to https://www.amazon.com/
//            • Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
//            • Print the first selected option and assert if it equals “All Departments”
//            • Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.
//            (after you select you need to use get first selected option method)
//            • Print all of the dropdown options
//• Print the the total number of options in the dropdown
//• Check if Appliances is a drop down option. Print true if “Appliances” is an option. Print false otherwise.
//• BONUS: Check if the dropdown is in Alphabetical Order
WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
    }
    @Test
    public void firstElement(){
//     • Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
//     • Print the first selected option and assert if it equals “All Departments”
        WebElement dropBox=driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect']"));
        Select options=new Select(dropBox);
        String firstSelectedOption=options.getFirstSelectedOption().getText();
        System.out.println(firstSelectedOption);
        Assert.assertEquals(firstSelectedOption,"All Departments");
    }

    @Test
    public void print4Element(){
        // • Select the 4th option by index (index of 3) and
        // assert if the name is “Baby”.
        // (after you select you need to use get first selected option method)

        WebElement fourthElement=driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect']"));
        Select options=new Select(fourthElement);
        options.selectByIndex(3);
        String  fourthElText=options.getFirstSelectedOption().getText();
        Assert.assertEquals(fourthElText,"Baby");
    }

    @Test
    public void printAllElements(){
        //            • Print all of the dropdown options
        WebElement allElements=driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect']"));
        Select options=new Select(allElements);

        List<WebElement> allOptions=options.getOptions();
        for(WebElement a:allOptions){
            System.out.println(a.getText());
        }
    }

    @Test
    public void numberOfElements(){
        //• Print the the total number of options in the dropdown
        WebElement allElements=driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect']"));
        Select options=new Select(allElements);
        int numberOfElements=options.getOptions().size();
        System.out.println(numberOfElements);
    }

    @Test
    public void checkAppliances(){
        //• Check if Appliances is a drop down option.
        // Print true if “Appliances” is an option. Print false otherwise.
        WebElement allElements=driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect']"));
        Select options=new Select(allElements);
        options.selectByVisibleText("Baby");
        //Did not find Because there is no "Appliances" option
        Assert.assertTrue(options.getFirstSelectedOption().isSelected());

        }

    //• BONUS: Check if the dropdown is in Alphabetical Order
        @Test
    public void alphabeticalOrder(){
      WebElement allElements=driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect']"));
        Select options=new Select(allElements);

        //Get the all elemants of the dropdown
        List<WebElement> allListEl=options.getOptions();

        // Create a new list to put the elements of the allListEl as String
        List<String> allList2=new ArrayList<String>();
        for(int i=0 ; i<allListEl.size(); i++){
        allList2.add(allListEl.get(i).getText());
        }
        System.out.println("This is the original list:  " +allList2);

        //We ordered (the natural order) to  the new list
        Collections.sort(allList2);

        //We compared the lists if the elements are not match , it means previous one is not ordered
        int count=0;
        for(int i=0 ; i<allListEl.size();i++){
            if(allList2.get(i).equals(allListEl.get(i).getText())){
                count++;
            }
        }

        System.out.println( "This is the ordered list:  " +allList2);

        //Count is less than size() so Assert will be fail,false
        System.out.println(count);
        Assert.assertFalse(allListEl.size()==count);


        }

        @AfterMethod
        public void tearDown(){
        driver.quit();
        }

}
