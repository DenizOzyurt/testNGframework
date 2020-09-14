package SeleniumPractice.Day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class TestCase4 {
//    1. Go to “http://webdriveruniversity.com/Popup-Alerts/index.html”


    WebDriver driver;
    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void alert1(){
        //            2. Click CLICK ME of JavaScript Alert
       WebElement clickMe = driver.findElement(By.id("button1"));
        clickMe.click();

        Alert alert = driver.switchTo().alert();
// 3. Get the pop up text
        String popText = alert.getText();
        String expectedText = "I am an alert box!";
// 4. Verify the Message is “I am an alert box!“
        Assert.assertEquals(popText,expectedText);
//            5. Accept the pop up
        alert.accept();


    }

    @Test(dependsOnMethods = "alert1")
    public void test2(){
//        1. Go to “http://webdriveruniversity.com/Popup-Alerts/index.html”
        //        2. Click CLICK ME of JavaScript Confirm Box
    WebElement button2=driver.findElement(By.id("button4"));
    button2.click();
    Alert alert=driver.switchTo().alert();
        SoftAssert softassert=new SoftAssert();

    //        3. Get the pop up text
        String confirmText=alert.getText();
//        4. Verify the Message is “Press a button“ (the message is worng but I
//        want to complete my test case)
        String expectedC="Press a button";
        softassert.assertEquals(confirmText,expectedC);
//        5. Dismiss the pop up
        alert.dismiss();
//        6. Verify the “You pressed Cancel!” is displayed
        String verifyT=driver.findElement(By.id("confirm-alert-text")).getText();
       String expectedV="You pressed Cancel!";
       softassert.assertEquals(verifyT,expectedV);
//        7. Use the dependsOnMethods accorting to testCase4

        softassert.assertAll();
    }
}
