package com.automationdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {
    WebDriver driver;
    By dressTitle = By.xpath("//p[@class='product-name']");
    By payBankWireButton = By.xpath("//a[@class='bankwire']");
    By totalPriceText = By.id("total_price");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getDressName(){
        return driver.findElement(dressTitle).getText();
    }
    public String getTotalPrice(){
        return driver.findElement(totalPriceText).getText();
    }
    public void clickBankWireButton() {
        driver.findElement(payBankWireButton).click();
    }
}
