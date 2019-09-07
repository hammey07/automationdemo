package com.automationdemo.support;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    public static WebDriver setup(WebDriver driver)
    {
        if(driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\hamma\\IdeaProjects\\hammadsaleem\\src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            return driver;
        }else
            return driver;

        //System.out.println("in method "+ driver.getTitle() );

    }

    public static void closeSession(WebDriver driver){
        driver.quit();
    }
}
