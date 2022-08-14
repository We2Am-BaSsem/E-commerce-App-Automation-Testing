package org.examples.StepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.examples.Pages.HomePage;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class HomeSlidersStepDefinitions {
    HomePage homePage = new HomePage(Hooks.webDriver);
    SoftAssert softAssert = new SoftAssert();;

    @Given("user clicks on Nokia Lumia slider")
    public void userClicksOnNokiaLumiaSlider() throws InterruptedException {
        homePage.sliderSelectorPom.get(0).click();
        homePage.sliderPom.click();
        Thread.sleep(3000);
    }

    @Then("user should be directed to Nokia Lumia page")
    public void userShouldBeDirectedToNokiaLumiaPage() {
        String expectedUrl = "https://demo.nopcommerce.com/nokia-lumia-1020";

        softAssert.assertEquals(expectedUrl,
                Hooks.webDriver.getCurrentUrl(),
                "Routed to wrong url expected: ".concat(expectedUrl).concat(" but routed to: ").concat(Hooks.webDriver.getCurrentUrl()));
        softAssert.assertTrue(Hooks.webDriver.findElement(By.linkText("My account")).isDisplayed(), "Element with \"My account\" did not displayed");
        softAssert.assertAll();
    }

    @Given("user clicks on iphone slider")
    public void userClicksOnIphoneSlider() throws InterruptedException {
        homePage.sliderSelectorPom.get(1).click();
        Thread.sleep(1500);
        homePage.sliderPom.click();
        Thread.sleep(3000);
    }

    @Then("user should be directed to iphone page")
    public void userShouldBeDirectedToIphonePage() {
        String expectedUrl = "https://demo.nopcommerce.com/iphone-6";

        softAssert.assertEquals(expectedUrl,
                Hooks.webDriver.getCurrentUrl(),
                "Routed to wrong url expected: ".concat(expectedUrl).concat(" but routed to: ").concat(Hooks.webDriver.getCurrentUrl()));
        softAssert.assertTrue(Hooks.webDriver.findElement(By.linkText("My account")).isDisplayed(), "Element with \"My account\" did not displayed");
        softAssert.assertAll();
    }
}
