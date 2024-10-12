package org.example.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class testBase {
    public WebDriver driver;
    public WebDriver driverSetup(){
        ChromeOptions option = new ChromeOptions();
        option.addArguments("start-maximized");
        return new ChromeDriver(option);
    }

    @BeforeClass
    public void initSeleniumDriver(){
        driver = driverSetup();
    }

    @AfterClass
    public void tearDown(){
        //driver.close();
    }

    @AfterSuite
    public void endTest(){
        //driver.quit();
    }
}
