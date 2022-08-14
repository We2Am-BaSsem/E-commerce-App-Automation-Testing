package org.examples.StepDefinitions;

import org.examples.Pages.HomePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SearchStepDefinitions {
    HomePage homePage = new HomePage(Hooks.webDriver);
    SoftAssert softAssert = new SoftAssert();;

    @Before
    public void openBrowser() {
        homePage = new HomePage(Hooks.webDriver);
        softAssert = new SoftAssert();
    }

    @When("user types {string} in search field")
    public void userTypesInSearchField(String productName) {
        homePage.searchInputPom.clear();
        homePage.searchInputPom.sendKeys(productName);
    }

    @And("user click search")
    public void userClickSearch() {
        homePage.searchButtonPom.click();
    }

    @Then("user route to search result page")
    public void userRouteToSearchResultPage() {
        String expectedUrl = "https://demo.nopcommerce.com/";

        softAssert.assertTrue(
                Hooks.webDriver.getCurrentUrl().contains(expectedUrl),
                "Routed to wrong url expected: ".concat(expectedUrl).concat(" but routed to: ").concat(Hooks.webDriver.getCurrentUrl()));
    }

    @And("there are {string} products should be displayed")
    public void thereAreProductsShouldBeDisplayed(String productsNumber) {
        int resultCount = homePage.productsTitleLabelsPom.size();
        softAssert.assertEquals(resultCount, Integer.parseInt(productsNumber), "Expected: ".concat(productsNumber).concat("but found: ").concat(String.valueOf(resultCount)));
    }

    @And("all products should contains {string} in its name")
    public void allProductsShouldContainsInItsName(String productName) {
        List<WebElement> productsTitles = homePage.productsTitleLabelsPom;

        for (WebElement title : productsTitles) {
            softAssert.assertTrue(title.getText().toLowerCase().contains(productName.toLowerCase()), title.getText().concat(" does not contain").concat(productName));
        }
        softAssert.assertAll();
    }

    @And("user click on the product")
    public void userClickOnTheProduct() {
        homePage.productsPom.get(0).click();
    }

    @Then("the product sku should be equal to {string}")
    public void theProductSkuShouldBeEqualTo(String sku) {
        Assert.assertTrue(homePage.productsSkuPom.getText().toLowerCase().contains(sku.toLowerCase()), homePage.productsSkuPom.getText().concat(" does not contain ").concat(sku));
    }
}
