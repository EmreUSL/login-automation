package com.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SafariDriverManager extends DriverManager {

    @Override
    protected WebDriver createDriver() {
        WebDriverManager.safaridriver().setup();
        return new SafariDriver();
    }
}
