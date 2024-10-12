package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class GearPage {

    WebDriver driver;

    public GearPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openItemPageByName(String itemName){
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
        driver.findElement(By.xpath("//*[@alt='"+itemName+"']")).click();
    }
}
