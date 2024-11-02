package org.example;

import org.example.pages.HomePage;
import org.example.pages.auth.SignupPage;
import org.example.util.testBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.time.Duration;


public class testSignup extends testBase {

    String signupURL ="https://magento.softwaretestingboard.com/customer/account/create/";
    String url = "https://magento.softwaretestingboard.com/";

    String accountURL = "https://magento.softwaretestingboard.com/customer/account/";


    @Test
    public void testSignupWithCorrectData() throws InterruptedException {
        driver.get(url);
        HomePage homePage = new HomePage(driver);
        homePage.openCreateAccountPage();

        // validate the url of signup page
        Assert.assertEquals(driver.getCurrentUrl(), signupURL, "URLs does not match");

        SignupPage signupPage = new SignupPage(driver);
        signupPage.setFirstName("test");
        signupPage.setLastName("user");
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        System.out.println("user"+timeStamp+"@test.com");
        signupPage.setEmail("user"+timeStamp+"@test.com");
        signupPage.setPassword("P@$$W0rd");
        signupPage.createAccount();

        // validate signup done correctly
        Assert.assertEquals(driver.getCurrentUrl(), accountURL);

        // total wait time -> 10 seconds
        // polling time -> 500 milliseconds
        // condition
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Thank you for registering with Main Website Store.']")));


        //Thread.sleep(4000);
        String successMsg = driver.findElement(By.xpath("//*[text()='Thank you for registering with Main Website Store.']")).getText();
        Assert.assertEquals(successMsg, "Thank you for registering with Main Website Store.");

    }


}
