package com.utils;

import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    public static DriverManager getManager(DriverType driverType) {

        return switch (driverType) {
            case CHROME -> new ChromeDriverManager();
            case SAFARI -> new SafariDriverManager();
            default -> throw new IllegalArgumentException("Driver type not supported");
        };
    }
}
