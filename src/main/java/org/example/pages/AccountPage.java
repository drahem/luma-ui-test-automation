package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {

    WebDriver driver;

    private By gearTab = By.id("ui-id-6");

    public AccountPage(WebDriver driver){
        this.driver = driver;
    }

    public void openGearTab(){
        driver.findElement(gearTab).click();
    }

}
