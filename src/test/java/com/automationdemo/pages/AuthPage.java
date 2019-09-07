package com.automationdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthPage {
    private WebDriver driver;
    private By createAnAccButtonAuthPage = By.id("SubmitCreate");
    private By emailTextBoxAuthPage = By.id("email_create");
    public void openHomePage() {
        driver.get("http://automationpractice.com/index.php");
    }

    public AuthPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterEmailAddressAuthPage(String email){
        driver.findElement(emailTextBoxAuthPage).sendKeys(email);
    }
    public void clickOnCreateAnAccountAuthPage(){
        driver.findElement(createAnAccButtonAuthPage).click();
    }

}