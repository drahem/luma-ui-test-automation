package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemPage {

    WebDriver driver;

    public ItemPage(WebDriver driver){
        this.driver = driver;
    }

    private By addToCart = By.id("product-addtocart-button");

    public void addItemToCart(){
        driver.findElement(addToCart).click();
    }
}
