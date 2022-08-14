package org.examples.StepDefinitions;

import org.examples.Pages.HomePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CurrenciesStepDefinitions {
    HomePage homePage = null;

    @Before
    public void openBrowser() {
        homePage = new HomePage(Hooks.webDriver);
    }

    @Given("user open browser and visit the home page")
    public void userOpenBrowserAndVisitTheHomePage() {
    }

    @When("user click on the top left dropdown list")
    public void userClickOnTheTopLeftDropdownList() {
        homePage.currencyDropdownListPom.click();
    }

    @And("user chose euro as website currency")
    public void userChoseEuroAsWebsiteCurrency() {
        homePage.currencyDropdownItemsPom.get(1).click();
    }

    @Then("all products' prices should be in euro")
    public void allProductsPricesShouldBeInEuro() {
        String euroSymbol = "€";

        List<WebElement> productsPrices = homePage.productsPriceLabelsPom;

        for (WebElement price : productsPrices) {
            Assert.assertTrue(price.getText().contains(euroSymbol));
        }
    }
}
