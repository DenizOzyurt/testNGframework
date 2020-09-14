package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class uploadFileTest extends TestBase {
    //https://the-internet.herokuapp.com/upload

    @Test
    public void uploadFileMethod (){
        //Locate the element of chooseFile
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile=driver.findElement(By.id("file-upload"));
        //We need to send the path of the image
        //Each of your will be different
        //Find own your path
       // C:\Users\Pc\Desktop\FLOWER. IMG
        String pathOfTheFile="C:\\Users\\Pc\\Desktop\\FLOWER. IMG.jpg";

        //We will send this pathOfTheFile to the chooseFile button
        chooseFile.sendKeys(pathOfTheFile);

        //Click upload button
        driver.findElement(By.id("file-submit")).click();

        //verify "File Uploaded!"
        String actualUploadText=driver.findElement(By.xpath("//h3")).getText();
        String expextedUploadText="File Uploaded!";

        Assert.assertEquals(actualUploadText,expextedUploadText);


    }




}
