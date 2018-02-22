package org.fasttrackit.Cart;

import org.fasttrackit.AppConfig;
import org.fasttrackit.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class CartTest extends TestBase {

    @Test
    public void addProductToCart (){

        driver.findElement(By.tagName("input")).sendKeys("vase" + Keys.ENTER);
        System.out.println("Pressed Enter in search field");
        driver.findElement(By.xpath("//div[@class='product-info' and ./descendant::*[text()='Herald Glass Vase']]//button[contains(@class, 'btn-cart')]")).click();
        WebElement successMessageContainer =driver.findElement(By.cssSelector(".success-msg"));
        assertThat("Product not added to cart.", successMessageContainer.getText(), containsString("Herald Glass Vase"));
        // todo: assert that product is present in cart


    }
    @Test
    public void selectProductWithSizeAndColor() throws InterruptedException {

        By womenCategoryLocator = By.xpath("//div[@id='header-nav']//a[text()='Women']");
        By NewArrivalSubCategoryLocator = By.xpath("//div[@id='header-nav']//a[text()='New Arrivals']");
        mouseOverAndClickLast(Arrays.asList(womenCategoryLocator, NewArrivalSubCategoryLocator));

        driver.findElement(By.xpath("//a[@title='View Details'  and ./ ancestor::* [a[@title='Elizabeth Knit Top']]]")).click();
        driver.findElement(By.xpath("//span[@class='swatch-label']//img[@alt='Pink']")).click();
        driver.findElement(By.cssSelector("#swatch80")).click();
        driver.findElement(By.xpath("//div[@class='add-to-cart-buttons']//button[@class='button btn-cart']")).click();
        WebElement successmsgcontainer = driver.findElement(By.cssSelector(".success-msg"));
        assertThat("Product not added to cart.", successmsgcontainer.getText(), containsString("Elizabeth Knit Top"));
        WebElement mesajDeSucces =driver.findElement(By.xpath("//table[@id='shopping-cart-table']//dt[text()='Size']//following-sibling::dd"));
        assertThat("Size S not available", mesajDeSucces.getText(), containsString("S"));
        driver.findElement(By.xpath("//span[text()='Proceed to Checkout']")).click();
        driver.findElement(By.cssSelector("input[id='login:guest']")).click();
        driver.findElement(By.xpath("//span[text()='Continue']")).click();
        driver.findElement(By.id("billing:firstname")).sendKeys("Ema" + Keys.ENTER);
        driver.findElement(By.id("billing:lastname") ).sendKeys("Haiduc"+ Keys.ENTER);
        driver.findElement(By.id("billing:email")).sendKeys("ema.hai@yahoo.com"+Keys.ENTER);
        driver.findElement(By.id("billing:street1")).sendKeys("Plopilor nr60" +Keys.ENTER);
        driver.findElement(By.id("billing:city")).sendKeys("Oradea"+ Keys.ENTER);
        driver.findElement(By.className("validate-select")).click();
        driver.findElement(By.xpath("//select[@id='billing:region_id']//option[text()='Florida']")).click();
        driver.findElement(By.id("billing:postcode")).sendKeys("6686" + Keys.ENTER);
        driver.findElement(By.id("billing:country_id"));
        driver.findElement (By.id("billing:telephone")).sendKeys("5680988"+ Keys.ENTER);
        driver.findElement(By.id("billing:use_for_shipping_yes")).click();
        driver.findElement(By.xpath("//div[@id='billing-buttons-container']//button[@title='Continue']")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("s_method_freeshipping_freeshipping")).click();

        driver.findElement(By.cssSelector("#shipping-method-buttons-container")).click();







    }

}
