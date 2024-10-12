package org.example.e2e;

import org.example.pages.AccountPage;
import org.example.pages.GearPage;
import org.example.pages.HomePage;
import org.example.pages.ItemPage;
import org.example.pages.auth.SignupPage;
import org.example.util.testBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;

public class fullScenarioTest extends testBase {
    String signupURL ="https://magento.softwaretestingboard.com/customer/account/create/";
    String url = "https://magento.softwaretestingboard.com/";
    String accountURL = "https://magento.softwaretestingboard.com/customer/account/";

    @DataProvider
    public Object [][] provider(){
        // read csv file
        return new Object [][] {{"Fusion Backpack"},{"Push It Messenger Bag"},{"Affirm Water Bottle "}};
    }

    @BeforeClass
    public void CreateUser(){
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

    }

    @Test(dataProvider = "provider")
    public void addItemToCartTest(String item) throws InterruptedException {
        String itemName = item;
        AccountPage accountPage = new AccountPage(driver);
        accountPage.openGearTab();

        GearPage gearPage = new GearPage(driver);

        gearPage.openItemPageByName(itemName);
        // assert page is correct
        String urlName = itemName.replace(" ", "-");
        Assert.assertEquals(driver.getCurrentUrl(),"https://magento.softwaretestingboard.com/"+urlName.toLowerCase()+".html");

        ItemPage itemPage = new ItemPage(driver);
        itemPage.addItemToCart();

        //Thread.sleep(2000);
        //driver.findElement(By.linkText("shopping cart")).click();
        //Assert.assertEquals(driver.getCurrentUrl(), "https://magento.softwaretestingboard.com/checkout/cart/");

    }

    @AfterClass
    public void checkoutTest(){
        System.out.println("do the checkout steps....");
    }
}
