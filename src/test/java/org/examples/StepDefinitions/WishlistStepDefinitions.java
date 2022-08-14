package org.examples.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.examples.Pages.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class WishlistStepDefinitions {
    HomePage homePage = new HomePage(Hooks.webDriver);
    SoftAssert softAssert = new SoftAssert();


    @Given("chose HTC and click on wishlist button")
    public void choseHtcAndClickOnWishlistButton() {
        homePage.ProductsWishlistButtonPom.get(2).click();
    }

    @Then("a success message should be displayed with green background")
    public void aSuccessMessageShouldBeDisplayedWithGreenBackground() {
        String expectedMessage = "The product has been added to your wishlist";
        String expectedColor = "#4bb07a";

        softAssert.assertTrue(homePage.notificationPom.getText().contains(expectedMessage), "error message did not show up");
        String actualColor = Color.fromString(homePage.notificationPom.getCssValue("background-color")).asHex();
        softAssert.assertEquals(expectedColor, actualColor, "Expected message color is different");

        softAssert.assertAll();
    }

    @And("user go to wishlist page and check the product quantity")
    public void userGoToWishlistPage() throws InterruptedException {
        Thread.sleep(5000);
        homePage.wishlistHyperLinkPom.click();
    }

    @Then("the product quantity should be grater than zero")
    public void theProductQuantityShouldBeGraterThan() {
        int actualQuantity = Integer.parseInt(homePage.wishlistProductQuantityPom.get(0).getAttribute("value"));

        softAssert.assertTrue(actualQuantity > 0, "quantity is: " + actualQuantity + "and should be grater than 0");

        softAssert.assertAll();
    }
}
