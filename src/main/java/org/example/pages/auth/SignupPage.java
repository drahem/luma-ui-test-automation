package org.example.pages.auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {
    WebDriver driver;

    public SignupPage(WebDriver driver){
        this.driver = driver;
    }

    private By firstName = By.id("firstname");
    private By lastName = By.id("lastname");
    private By emailField = By.id("email_address");
    private By password = By.id("password");
    private By confirmPassword = By.id("password-confirmation");
    private By createAccountBtn = By.xpath("//button[@class = \"action submit primary\"]");

    public void setFirstName(String name){
        driver.findElement(firstName).sendKeys(name);
    }

    public void setLastName(String name){
        driver.findElement(lastName).sendKeys(name);
    }

    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String pass){
        driver.findElement(password).sendKeys(pass);
        driver.findElement(confirmPassword).sendKeys(pass);
    }

    public void createAccount(){
        driver.findElement(createAccountBtn).click();
    }



}
