package com.utils;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    protected abstract WebDriver createDriver();

    public WebDriver getDriver() {
        if (driver.get() == null) {
            driver.set(createDriver());
        }
        return driver.get();
    }

    public void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
