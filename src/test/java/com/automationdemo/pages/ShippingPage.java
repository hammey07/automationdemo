package com.automationdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPage {
    WebDriver driver;
    By checkbox = By.id("cgv");
    By proccedButton = By.name("processCarrier");
    public ShippingPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickCheckboxTerms(){
        driver.findElement(checkbox).click();
    }
    public void clickToProceed(){
        driver.findElement(proccedButton).click();
    }
}
