package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

public class TrialWindowHandleActionsUploadFile extends TestBase {

    @Test
    public void windowsHandle(){
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.linkText("Click Here")).click();
        String firstText=driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(firstText.equals("Opening a new window"));
        String page1=driver.getWindowHandle();

        Set<String> allPage=driver.getWindowHandles();
        for(String eachPage:allPage){
            if(!eachPage.equals(page1)){
                driver.switchTo().window(eachPage);
            }
        }

        String secondText=driver.findElement(By.xpath("//div[@class='example']//h3")).getText();
        Assert.assertEquals(secondText,"New Window","Result does not match with the actual one");

        driver.switchTo().window(page1);

        Assert.assertEquals(firstText,"Openning a new window","Result does not match with the actual one");
    }

    @Test()
        public  void rightClick(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement rigthClic=driver.findElement(By.id("hot-spot"));
        Actions actions=new Actions(driver);

        actions.contextClick(rigthClic).perform();

        Assert.assertEquals(driver.switchTo().alert().getText(),"You selected a context menu");
        driver.switchTo().alert().accept();


    }

    @Test
    public void hoverOver(){
        driver.get("https://www.amazon.com/");
        WebElement hoverOver=driver.findElement(By.id("nav-link-accountList"));

        Actions actions=new Actions(driver);
        actions.moveToElement(hoverOver).perform();
        String account=driver.findElement(By.linkText("Your Account")).getText();
        Assert.assertEquals(account,"Your Account");

    }
    @Test
    public void keysUpDown(){
        driver.get("https://www.amazon.com/");
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        Actions actions=new Actions(driver);

        actions.keyDown(searchBox, Keys.SHIFT).sendKeys("dell inspiron 13 7000 serices prize").
                keyUp(searchBox,Keys.SHIFT).sendKeys("asus s412").perform();

    }

    @Test
    public void pageUpDown(){
        driver.get("https://www.amazon.com/");

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.UP).perform();

        actions.sendKeys(Keys.ARROW_UP).perform();

    }
    @Test
    public void uploadFile(){
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement fileUpload=driver.findElement(By.id("file-upload"));
        String pathOfTheFile="C:\\Users\\Pc\\Desktop\\FLOWER. IMG.jpg";

        fileUpload.sendKeys(pathOfTheFile);
        driver.findElement(By.id("file-submit")).click();

        String filesText=driver.findElement(By.xpath("//h3")).getText();

        Assert.assertEquals(filesText,"File Uploaded!");

    }
    @Test
    public void isExist(){
        boolean isExist= Files.exists(Paths.get("C:\\Users\\Pc\\Desktop\\FLOWER. IMG.jpg"));
        System.out.println(isExist);
        Assert.assertTrue(isExist);
    }


}
