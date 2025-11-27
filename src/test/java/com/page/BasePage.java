package com.page;

import com.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
         this.driver = driver;
    }

    public WebElement findElement(By locator) {
         return driver.findElement(locator);
    }

    public void waitElementVisibility(By locator) {
        WaitUtil.waitForElementVisible(driver, locator);
    }

    public void click(By locator) {
        WaitUtil.waitForElementVisible(driver, locator);
        driver.findElement(locator).click();
    }

    public void sendKeys(By locator, String text) {
        WaitUtil.waitForElementVisible(driver, locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }



}
