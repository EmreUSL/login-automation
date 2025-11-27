package com.test.login;

import com.page.login.LoginPage;
import com.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"Admin", "admin123", true},
                {"Admin", "admin", false},
                {"Admninn", "admin123", false},
                {" ", " ", false},
                {"Admin", " ", false},
                {" ", "admin123", false},
        };
    }


    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password, boolean isValid) {

        LoginPage loginPage = new LoginPage(driverManager.getDriver());

        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();

        if (isValid) {
            Assert.assertTrue(loginPage.isHomePageDisplayed());
        } else {

            if (username.equals(" ") || password.equals(" ")) {
                Assert.assertTrue(loginPage.isEmptyLogin());
            } else {
                Assert.assertTrue(loginPage.isLoginInvalidCheck());
            }
        }
    }
}
