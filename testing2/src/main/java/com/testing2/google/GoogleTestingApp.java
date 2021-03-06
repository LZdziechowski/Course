package com.testing2.google;

import com.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleTestingApp {

    public static final String SEARCHFIELD = "q";

    public static void main(String[] args) {

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://www.google.com");

        WebElement searchField = driver.findElement(By.name(SEARCHFIELD));
        searchField.sendKeys("pogoda Warszawa");
        searchField.submit();
    }
}
