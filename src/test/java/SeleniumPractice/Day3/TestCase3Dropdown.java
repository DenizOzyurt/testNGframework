package SeleniumPractice.Day3;

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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase3Dropdown {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }
    @Test
    public void test1(){
        //    1. Go to http://zero.webappsecurity.com/
        driver.get("http://zero.webappsecurity.com/");
//            2. Click Sign in button
    driver.findElement(By.id("signin_button")).click();
// 3. Enter login ( “username”)
        driver.findElement(By.id("user_login")).sendKeys("username");

// 4. Enter wrong password (“password.”)
        driver.findElement(By.id("user_password")).sendKeys("password");
// 5. Click Sign in button
        driver.findElement(By.name("submit")).click();
//6. Go to Account Activity page
        driver.findElement(By.linkText("Account Activity")).click();
//7.Select Brokerage from account drop down menu
        WebElement select1=driver.findElement(By.id("aa_accountId"));
        Select options = new Select(select1);
        options.selectByVisibleText("Brokerage");

//8.Verify in the account dropdown menu Brokerage is selected
        Assert.assertEquals(options.getFirstSelectedOption().getText(),"Brokerage");
//9.Verify the drop down menu is following { Savings, Checking, Savings, Loan, Credit Card, Brokerage}

        List<String>  expectedList= Arrays.asList("Savings", "Checking", "Savings", "Loan", "Credit Card", "Brokerage");
        System.out.println(expectedList);

        List<WebElement> webElementList=options.getOptions();
        List<String> actualList=new ArrayList<String>();

        for(int i=0; i<webElementList.size();i++ ){
           actualList.add(webElementList.get(i).getText());
           Assert.assertEquals(actualList.get(i),expectedList.get(i));
        }

    }

}
