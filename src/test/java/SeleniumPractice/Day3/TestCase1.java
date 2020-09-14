package SeleniumPractice.Day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase1 {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://facebook.com");
    }

    @Test
    public void test01(){
        /*
        Go to “https://facebook.com”
2. Click create new account button
*/
        driver.findElement(By.linkText("Create New Account")).click();
  // 3. Enter a name firstName input box

// 4. Enter a surname surName input box
        driver.findElement(By.id("u_2_b")).sendKeys("Ali");
        driver.findElement(By.id("u_2_d")).sendKeys("can");
// 5. Enter an email into email input box
        driver.findElement(By.id("u_2_g")).sendKeys("alicqn@gmail.com");
//6. Re-enter the same email into email input box
//        driver.findElement(By.cssSelector("#u_c_g")).sendKeys("alicqn@gmail.com");
//7. Enter a new password
        driver.findElement(By.id("password_step_input")).sendKeys("alicqn@gmail.com");
//8. Select a month
        WebElement month=driver.findElement(By.id("month"));
        Select options=new Select(month);
        options.selectByIndex(3);
//9. Select a moth
        WebElement day=driver.findElement(By.cssSelector("#day"));
        Select options2=new Select(day);
        options2.selectByIndex(3);
//10. Select a year
        WebElement year=driver.findElement(By.cssSelector("#year"));
        Select options3=new Select(day);
        options3.selectByIndex(3);

//        11. Select a gender
        driver.findElement(By.id("u_2_5")).click();

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
