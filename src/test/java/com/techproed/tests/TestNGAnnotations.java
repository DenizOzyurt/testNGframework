package com.techproed.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGAnnotations {
    // 1. create a method: setUp using @BeforeMethod
//    annotation and print "This is BeforeMethod"
    @BeforeMethod//@Before method will run before each @Test
    public void setUp(){
        System.out.println("This is Before method");
    }
    // 2. Create a method: tearDown using @AfterMethod
//    annotation and print "This is @AfterMethod"
    @AfterMethod//This will run After each @Test
    public void tearDown(){
        System.out.println("This is @AfterMethod");
    }
    // 3. Create 4 TEST METHODS: test1,test2,test3,test4 and print "Test1", "Test2", "Test3","Test4" respectively
    @Test(priority = 3)
    public void test1(){
        System.out.println("Test1");
    }
    @Ignore//This is used to ignore this test case
    @Test
    public void test2(){
        System.out.println("Test2");
    }
    @Test(priority = 1)
    public void test3(){
        System.out.println("Test3");
    }
    @Test(priority = 2)
    public void test4(){
        System.out.println("Test4");
    }
//4. Skip test2
//DONE
//5. print the test in this order: Test3, Test4, Test1
//DONE

}
