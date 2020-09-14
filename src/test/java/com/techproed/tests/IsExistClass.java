package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class IsExistClass extends TestBase {

    @Test
    public void isExist(){
        //Check is the FLOWER. IMG is existing on your desktop
        //  C:\Users\Pc\Desktop\FLOWER. IMG.jpg

        String pathOfTheFile="C:\\Users\\Pc\\Desktop\\FLOWER. IMG.jpg";

        //We will use JAVA to check if a file exist or not.

        boolean isExist=Files.exists(Paths.get(pathOfTheFile));

        //Assert if the path is exist
        Assert.assertTrue(isExist);
    }

}
