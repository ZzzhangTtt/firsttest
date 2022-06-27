package com.zt.webapplicationtest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumTest {
    private WebDriver chromeDriver;
    @BeforeClass
    public void init(){
        chromeDriver =new ChromeDriver();
    }
    @Test
    public void testCase1(){
        chromeDriver.get("http://localhost:8080/login");
        chromeDriver.findElement(By.name("username")).sendKeys("zhangsan");
        chromeDriver.findElement(By.name("password")).sendKeys("zhangsan123456");
        chromeDriver.findElement(By.xpath("//form/p[4]/button")).click();
        String expected ="zhangsan";
        String actual= chromeDriver.findElement(By.xpath("//nav/label/span")).getText();
        Assert.assertEquals(expected,actual);
    }
    @AfterClass
    public void clear(){
        chromeDriver.quit();
    }
}
