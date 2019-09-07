package com.automationdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    By searchButton = By.name("submit_search");
    By searchTextBox = By.id("search_query_top");

    public void openHomePage() {
        driver.get("http://automationpractice.com/index.php");
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchForProduct(String expectedSearchString) {
        driver.findElement(searchTextBox).sendKeys(expectedSearchString);
        driver.findElement(searchButton).click();
    }

    public String getTitleText() {
        return driver.getTitle();
    }
}
