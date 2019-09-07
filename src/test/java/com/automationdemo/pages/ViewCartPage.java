package com.automationdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class ViewCartPage {
    WebDriver driver;
    private By womenPageNav = By.xpath("//a[@class='home']");
    private By clickToCheckoutButton = By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]");
    public ViewCartPage(WebDriver driver) {
        this.driver = driver;
    }
    public String firstItemCost(){
        return driver.findElement(By.id("total_product_price_5_20_0")).getText();
    }

    public void navigateToHomePage() {
        driver.findElement(womenPageNav).click();
    }

    public void clickToCheckout() {
        driver.findElement(clickToCheckoutButton).click();
    }
}
