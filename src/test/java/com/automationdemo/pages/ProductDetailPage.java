package com.automationdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage {
    WebDriver driver;
    private By addToCartButton = By.id("add_to_cart");
    private By clickToContinue = By.className("continue");
    private By clickOnViewCart = By.className("shopping_cart");
    private By productTitle = By.xpath("//h1[@itemprop='name']");


    public ProductDetailPage(WebDriver driver) {
            this.driver = driver;
    }

    public String getProductPrice() {
        System.out.println("dispaly price :" + driver.findElement(By.id("our_price_display")).getText());
        return driver.findElement(By.id("our_price_display")).getText();
    }

    public void selectColor(String lightBlue){
        driver.findElement(By.id(lightBlue)).click();
    }
    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void clickToContinueShopping() {
        driver.findElement(clickToContinue).click();

    }

    public void clickOnViewCart() {
        driver.findElement(clickOnViewCart).click();
    }

    public String getProductName() {
        System.out.println(driver.findElement(productTitle).getText());
        return driver.findElement(productTitle).getText();
    }
}
