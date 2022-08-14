package org.examples.StepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.examples.Pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class FollowUsStepDefinitions {
    HomePage homePage = new HomePage(Hooks.webDriver);

    @Given("user opens facebook link")
    public void userOpensFacebookLink() {
        homePage.facebookFollowUsButtonPom.click();
        Hooks.navigateToAnotherTab(1, 2);
    }

    @Given("user opens twitter link")
    public void userOpensTwitterLink() {
        homePage.twitterFollowUsButtonPom.click();
        Hooks.navigateToAnotherTab(1, 2);
    }

    @Given("user opens rss link")
    public void userOpensRssLink() {
        homePage.rssFollowUsButtonPom.click();
        Hooks.navigateToAnotherTab(0, 1);
    }

    @Given("user opens youtube link")
    public void userOpensYoutubeLink() {
        homePage.youtubeFollowUsButtonPom.click();
        Hooks.navigateToAnotherTab(1, 2);
    }

    @Then("{string} is opened in new tab")
    public void isOpenedInNewTab(String link) {
        Assert.assertEquals(Hooks.webDriver.getCurrentUrl(), link);
    }
}
