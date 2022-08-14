package org.examples.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver = null;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input.email[name=\"Email\"]")
    public WebElement emailInputPom;

    @FindBy(css = "input.password[name=\"Password\"]")
    public WebElement passwordInputPom;

    @FindBy(css = "button.login-button[type=\"submit\"]")
    public WebElement loginButtonPom;

    @FindBy(css = "div.message-error")
    public WebElement errorMessagePom;


}
