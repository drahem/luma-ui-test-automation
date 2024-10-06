package org.example.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class testBase {
    public WebDriver driver;
    public WebDriver driverSetup(){
        return new ChromeDriver();
    }

    @BeforeClass
    public void initSeleniumDriver(){
        driver = driverSetup();
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

    @AfterSuite
    public void endTest(){
        driver.quit();
    }
}
