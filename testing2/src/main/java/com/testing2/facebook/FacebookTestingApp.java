package com.testing2.facebook;

import com.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {

    public static final String XPATH_COOKIE = "//div[@class=\"_9o-r\"]/button[contains(@class, \"_42ft _4jy0 _9o-t\")]";
    public static final String XPATH_NEW_ACCOUNT = "//div[@class=\"_6ltg\"]/a[@role=\"button\"]";
    public static final String XPATH_DAY = "//span[@class=\"_5k_4\"]//select[contains(@name, \"birthday_day\")]";
    public static final String XPATH_MONTH = "//span[@class=\"_5k_4\"]//select[contains(@name, \"birthday_month\")]";
    public static final String XPATH_YEAR = "//span[@class=\"_5k_4\"]//select[contains(@name, \"birthday_year\")]";

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://www.facebook.com/");

        while (!driver.findElement(By.xpath(XPATH_COOKIE)).isDisplayed()) ;

        WebElement acceptCookie = driver.findElement(By.xpath(XPATH_COOKIE));
        acceptCookie.click();

        WebElement newAccount = driver.findElement(By.xpath(XPATH_NEW_ACCOUNT));
        newAccount.click();

        Thread.sleep(4000);

        WebElement selectDay = driver.findElement(By.xpath(XPATH_DAY));
        Select selectDayOfBirth = new Select(selectDay);
        selectDayOfBirth.selectByValue("5");

        WebElement selectMonth = driver.findElement(By.xpath(XPATH_MONTH));
        Select selectMonthOfBirth = new Select(selectMonth);
        selectMonthOfBirth.selectByValue("5");

        WebElement selectYear = driver.findElement(By.xpath(XPATH_YEAR));
        Select selectYearOfBirth = new Select(selectYear);
        selectYearOfBirth.selectByValue("1950");
    }
}