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

public class TestCase2homework {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
//    . Go to http://zero.webappsecurity.com/2.
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/");
    }
    @AfterMethod
    public  void tearDown(){
        driver.quit();
    }

    @Test
    public void start() throws InterruptedException {
//    Click Sign in button3.
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
//    Enter login ( “username”)4. Enter wrong password (“password.”)5. Click Sign in button

        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
           Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("password");
        Thread.sleep(2000);
            driver.findElement(By.name("submit")).click();
        Thread.sleep(2000);
//            6. Go to Pay Bills page
            driver.findElement(By.linkText("Pay Bills")).click();

//7. Click Purchase Foreign Currency
        Thread.sleep(1000);
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();
        Thread.sleep(1000);
        //8. Select Eurozone from currency drop dawn menu
        WebElement currency=driver.findElement(By.id("pc_currency"));
        Select options=new Select(currency);
        options.selectByVisibleText("Eurozone (euro)");
        Thread.sleep(1000);
//9. Enter an amount input box
        driver.findElement(By.id("pc_amount")).sendKeys("100");
//10. Verify the US is not selected
        Thread.sleep(1000);
        WebElement dollar=driver.findElement(By.id("pc_inDollars_true"));
        Thread.sleep(1000);
        Assert.assertFalse(dollar.isSelected());
//11. Select currency button
        Thread.sleep(1000);
        driver.findElement(By.id("pc_inDollars_false")).click();

//12. Click Calculate Costs button then click purchase button
        Thread.sleep(1000);
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();
//13. Verify the message “Foreign currency cash was successfully purchased.” is displayed.
        String verifiyText=driver.findElement(By.id("alert_content")).getText();
        Thread.sleep(1000);
        Assert.assertEquals(verifiyText,"Foreign currency cash was successfully purchased.");
//            . Go to http://zero.webappsecurity.com/2. Click Sign in button3. Enter login ( “username”)4. Enter wrong password (“password.”)5. Click Sign in button
//            6. Go to Pay Bills page
//7. Click Purchase Foreign Currency
//8. Select Eurozone from currency drop dawn menu
//9. Enter an amount input box
//10. Verify the US is not selected
//11. Select currency button
//12. Click Calculate Costs button then click purchase button
//13. Verify the message “Foreign currency cash was successfully purchased.” is displayed.
    }
}
