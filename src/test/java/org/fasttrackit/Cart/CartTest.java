package org.fasttrackit.Cart;

import org.fasttrackit.AppConfig;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class CartTest {

    @Test
    public void addProductToCart (){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nelu\\Desktop\\drivere\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        driver.get("https://fasttrackit.org/selenium-test/");
        //driver.findElement(By.id("search")).sendKeys("vase"+ Keys.ENTER);
       // driver.findElement(By.name("q")).sendKeys("vase"+ Keys.ENTER);
        //driver.findElement(By.className("input-text")).sendKeys("vase");
        driver.findElement(By.tagName("input")).sendKeys("vase" + Keys.ENTER);
        System.out.println("Pressed Enter in search field");
        driver.findElement(By.xpath("//div[@class='product-info' and ./descendant::*[text()='Herald Glass Vase']]//button[contains(@class, 'btn-cart')]")).click();
        WebElement successMessageContainer =driver.findElement(By.cssSelector(".success-msg"));
        assertThat("Product not added to cart.", successMessageContainer.getText(), containsString("Herald Glass Vase"));
        // todo: assert that product is present in cart
    }
    @Test
    public void addSpecificProductToCart(){
        System.setProperty ("webdriver.chrome.driver");
        AppConfig.getChromeDriverPath();
        WebDriver driver = new ChromeDriver();
        driver.get(AppConfig.getSiteUrl());

        WebElement element= driver.findElement(By.linkText("Women"));
        Actions action = new Actions(driver);
    }

}
