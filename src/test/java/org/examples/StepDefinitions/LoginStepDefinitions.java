package org.examples.StepDefinitions;

import org.examples.Pages.HomePage;
import org.examples.Pages.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class LoginStepDefinitions {
    LoginPage loginPage = null;
    HomePage homePage = null;
    SoftAssert softAssert;

    @Before
    public void openBrowser() {
        loginPage = new LoginPage(Hooks.webDriver);
        homePage = new HomePage(Hooks.webDriver);
        softAssert = new SoftAssert();
    }

    @Given("user go to login page")
    public void userGoToLoginPage() throws InterruptedException {
        homePage.loginHyperLinkPom.click();
        Thread.sleep(1500);
    }

    @When("user login with {string} {string} and {string}")
    public void userLoginWithAnd(String username, String email, String password) {
        loginPage.emailInputPom.clear();
        loginPage.passwordInputPom.clear();


        loginPage.emailInputPom.sendKeys(email);
        loginPage.passwordInputPom.sendKeys(password);
    }

    @And("user press on login button")
    public void userPressOnLoginButton() {
        loginPage.loginButtonPom.click();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        String expectedUrl = "https://demo.nopcommerce.com/";

        softAssert.assertEquals(expectedUrl,
                Hooks.webDriver.getCurrentUrl(),
                "Routed to wrong url expected: ".concat(expectedUrl).concat("but routed to: ").concat(Hooks.webDriver.getCurrentUrl()));
        softAssert.assertTrue(Hooks.webDriver.findElement(By.linkText("My account")).isDisplayed(), "Element with \"My account\" did not displayed");

        softAssert.assertAll();
    }

    @And("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {
        String expectedColor = "#e4434b";

        softAssert.assertTrue(loginPage.errorMessagePom.getText().contains("Login was unsuccessful."), "error message did not show up");
        String actualColor = Color.fromString(loginPage.errorMessagePom.getCssValue("color")).asHex();
        softAssert.assertEquals(expectedColor, actualColor, "Expected message color is different");


        softAssert.assertAll();
    }
}
