package com.test;


import com.utils.DriverFactory;
import com.utils.DriverManager;
import com.utils.DriverType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    private DriverManager driverManager;

    @BeforeMethod
    public void setUp() {
        driverManager = DriverFactory.getManager(DriverType.CHROME);
        driverManager.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driverManager.getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
       driverManager.quitDriver();
    }
}
