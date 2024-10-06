package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private By createAccount = By.linkText("Create an Account");

    public void openCreateAccountPage(){
        driver.findElement(createAccount).click();
    }
}
