package org.examples.StepDefinitions;

import org.examples.Pages.HomePage;
import org.examples.Pages.RegisterPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

public class RegisterStepDefinitions {
    RegisterPage registerPage = null;
    HomePage homePage = null;
    SoftAssert softAssert;

    @Before
    public void openBrowser() {
        registerPage = new RegisterPage(Hooks.webDriver);
        homePage = new HomePage(Hooks.webDriver);
        softAssert = new SoftAssert();
    }


    @Given("user go to register page")
    public void userGoToRegisterPage() throws InterruptedException {
        homePage.registerHyperLinkPom.click();
        Thread.sleep(1500);
    }

    @When("user select gender type")
    public void userSelectGenderType() {
        registerPage.maleCheckBoxPom.click();
    }

    @And("user enter first name {string} and last name {string}")
    public void userEnterFirstNameAndLastName(String firstName, String lastName) {
        registerPage.firstNameInputPom.clear();
        registerPage.lastNameInputPom.clear();

        registerPage.firstNameInputPom.sendKeys(firstName);
        registerPage.lastNameInputPom.sendKeys(lastName);
    }

    @And("user enter date of birth")
    public void userEnterDateOfBirth() {
    }

    @And("user enter email {string} field")
    public void userEnterEmailField(String email) {
        registerPage.emailInputPom.clear();

        registerPage.emailInputPom.sendKeys(email);
    }

    @And("user fills Password fields {string} {string}")
    public void userFillsPasswordFields(String password, String confirmationPassword) {
        registerPage.passwordInputPom.clear();
        registerPage.confirmPasswordInputPom.clear();

        registerPage.passwordInputPom.sendKeys(password);
        registerPage.confirmPasswordInputPom.sendKeys(confirmationPassword);
    }

    @And("user clicks on register button")
    public void userClicksOnRegisterButton() {
        registerPage.registerButtonPom.click();
    }

    @Then("success message is displayed")
    public void successMessageIsDisplayed() {
        String expectedMessage = "Your registration completed";
        String expectedColor = "rgba(76, 177, 124, 1)";


        softAssert.assertEquals(expectedMessage, registerPage.registrationMessagePom.getText(), "Expected message is different");
        softAssert.assertEquals(expectedColor, registerPage.registrationMessagePom.getCssValue("color"), "Expected message color is different");


        softAssert.assertAll();
    }
}
