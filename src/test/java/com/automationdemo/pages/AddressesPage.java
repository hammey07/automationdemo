package com.automationdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressesPage {
    WebDriver driver;
    By proceedButton = By.name("processAddress");
    By firstlastName = By.className("address_firstname");
    By address = By.className("address_address1");
    By phoneNumber = By.className("address_phone_mobile");
    public AddressesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickProceedCheckout(){
        driver.findElement(proceedButton).click();
    }
    public String getFullName(){
        return driver.findElement(firstlastName).getText().toLowerCase();
    }
    public String getAddress(){
        return driver.findElement(address).getText().toLowerCase();
    }
    public String getPhoneNumber(){
        return driver.findElement(phoneNumber).getText();
    }

}
