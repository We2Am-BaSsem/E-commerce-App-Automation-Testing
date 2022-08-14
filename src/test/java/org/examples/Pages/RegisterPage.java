package org.examples.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver driver = null;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "input[id=\"gender-male\"]")
    public WebElement maleCheckBoxPom;

    @FindBy(css = "input[id=\"gender-female\"]")
    public WebElement femaleCheckBoxPom;

    @FindBy(css = "input[name=\"FirstName\"]")
    public WebElement firstNameInputPom;

    @FindBy(css = "input[name=\"LastName\"]")
    public WebElement lastNameInputPom;

    @FindBy(css = "input[name=\"Email\"]")
    public WebElement emailInputPom;

    @FindBy(css = "input[name=\"Password\"]")
    public WebElement passwordInputPom;

    @FindBy(css = "input[name=\"ConfirmPassword\"]")
    public WebElement confirmPasswordInputPom;

    @FindBy(css = "button[name=\"register-button\"]")
    public WebElement registerButtonPom;

    @FindBy(css = "div.result")
    public WebElement registrationMessagePom;






}
