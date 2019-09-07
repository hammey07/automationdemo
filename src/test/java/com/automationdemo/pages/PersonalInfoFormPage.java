package com.automationdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class PersonalInfoFormPage {
    WebDriver driver;
    By titleRadioButton = By.xpath("//div[@class='clearfix']//div[1]//label[1]");
    By firstName = By.id("customer_firstname");
    By lastName = By.id("customer_lastname");
    By password = By.id("passwd");
    By address = By.id("address1");
    By city= By.id("city");
    By state = By.id("id_state");
    By postcode= By.id("postcode");
    By phone_mobile= By.id("phone_mobile");
    By registerButton = By.xpath("//span[contains(text(),'Register')]");
    public PersonalInfoFormPage(WebDriver driver) {
        this.driver = driver;
    }
    public void selectTitle(){
        driver.findElement(titleRadioButton).click();
    }
    public void setFirstName(String firstname){
        driver.findElement(firstName).sendKeys(firstname);
    }
    public void setLastName(String lastname){
        driver.findElement(lastName).sendKeys(lastname);
    }
    public void setPassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }
    public void setAddress(String address1){
        driver.findElement(address).sendKeys(address1);
    }
    public void setCity(String city1){
        driver.findElement(city).sendKeys(city1);
    }
    public void selectState (String stateName){
        Select dropDown = new Select(driver.findElement(state));
        dropDown.selectByVisibleText(stateName);
    }
    public void setPostcode (String postcode1){
        driver.findElement(postcode).sendKeys(postcode1);
    }
    public void setPhone(String number){
        driver.findElement(phone_mobile).sendKeys(number);
    }
    public void clickRegisterButton(){
        driver.findElement(registerButton).click();
    }
}
