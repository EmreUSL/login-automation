package com.page.login;

import com.page.BasePage;
import com.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    protected By usernameArea = By.name("username");
    protected By passwordArea = By.name("password");
    protected By loginButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");
    protected By homePageItem = By.xpath("//h6[contains(text(),Dashboard)]");
    protected By invalidLogin = By.xpath("//div[@class='oxd-alert oxd-alert--error']");
    protected By emptyValue = By.xpath("//span[contains(text(),Required)]");

    public void setUsername(String username) {
         sendKeys(usernameArea, username);
    }

    public void setPassword(String password) {
         sendKeys(passwordArea, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public boolean isHomePageDisplayed() {
        waitElementVisibility(homePageItem);
        return findElement(homePageItem).isDisplayed();
    }

    public boolean isLoginInvalidCheck() {
        waitElementVisibility(invalidLogin);
        return findElement(invalidLogin).isDisplayed();
    }

    public boolean isEmptyLogin() {
        waitElementVisibility(emptyValue);
        return findElement(emptyValue).isDisplayed();
    }

}
