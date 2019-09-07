package com.automationdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankWirePayPage {
    WebDriver driver;
    By amount = By.id("amount");
    By confirmButton = By.xpath("//span[contains(text(),'I confirm my order')]");
    public BankWirePayPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getFinalAmount(){
        return driver.findElement(amount).getText();
    }
    public void clickConfirmOrder(){
        driver.findElement(confirmButton).click();
    }
}
