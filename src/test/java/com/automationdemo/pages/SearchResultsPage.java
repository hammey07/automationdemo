package com.automationdemo.pages;

import com.automationdemo.support.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage {
    WebDriver driver;
    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }
    private By searchResultContainers = By.className("product-container");
    private By productName = By.className("product-name");
    private By productCost = By.xpath("//span[@itemprop='price']");

    public List<String> getAllSearchResults() {
        List<WebElement> searchResultItems = new ArrayList<WebElement>();
        searchResultItems = driver.findElements(searchResultContainers);

        WebElement productNameElement;
        List<String> productNames = new ArrayList<String>();
        for (WebElement item : searchResultItems) {
            productNameElement = item.findElement(productName);
            productNames.add(productNameElement.getText());
        }

        return productNames;
    }

    public String getFirstElementPrice() {
        List<WebElement> searchResultItems = new ArrayList<WebElement>();
        searchResultItems = driver.findElements(productCost);
        return searchResultItems.get(1).getText();
    }

    public void openFirstProductDetail() {
        List<WebElement> searchResultItems = new ArrayList<WebElement>();
        searchResultItems = driver.findElements(productName);
        WebElement firstItem = searchResultItems.get(4); // first item is coming up as 4th item when searched by product names
        firstItem.click();
    }

    public void openSecondProductDetail() {
        List<WebElement> searchResultItems = new ArrayList<WebElement>();
        searchResultItems = driver.findElements(productName);
        for(WebElement item:searchResultItems){
            System.out.println(item.getText());
        WebElement firstItem = searchResultItems.get(2); // first item is coming up as 4th item when searched by product names
        firstItem.click();
        }
    }
}
