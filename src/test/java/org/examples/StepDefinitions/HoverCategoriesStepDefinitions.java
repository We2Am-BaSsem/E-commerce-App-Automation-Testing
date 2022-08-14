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
    HomePage homePage = new HomePage(Hooks.webDriver);
    SoftAssert softAssert;
}
