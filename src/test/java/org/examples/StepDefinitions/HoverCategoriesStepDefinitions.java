package org.examples.StepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.examples.Pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HoverCategoriesStepDefinitions {
    HomePage homePage = null;
    SoftAssert softAssert;

    @Before
    public void openBrowser() {
        homePage = new HomePage(Hooks.webDriver);
        softAssert = new SoftAssert();
    }

    @Then("the product sku should be equal to {string}")
    public void theProductSkuShouldBeEqualTo(String sku) {
        Assert.assertTrue(homePage.productsSkuPom.getText().toLowerCase().contains(sku.toLowerCase()), homePage.productsSkuPom.getText().concat(" does not contain ").concat(sku));
    }
}
