package org.examples.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.examples.Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HoverCategoriesStepDefinitions {
    HomePage homePage = new HomePage(Hooks.webDriver);
    SoftAssert softAssert = new SoftAssert();
    Actions actions = new Actions(Hooks.webDriver);
    int selectedCategory;
    String selectedCategoryText;
    List<WebElement> subCategories;
    List<WebElement> mainCategories;
    String selectedSubCategoryTitle;

    @Given("user select a random main category")
    public void userSelectARandomMainCategory() throws InterruptedException {
        mainCategories = homePage.mainCategoriesBarPom;

        selectedCategory = (int) Math.floor(Math.random() * mainCategories.size());

        actions.moveToElement(mainCategories.get(selectedCategory)).perform();

        selectedCategoryText = mainCategories.get(selectedCategory).getText();
        Thread.sleep(2000);
    }

    @When("other sub categories are displayed if exist")
    public void otherSubCategoriesAreDisplayedIfExist() {
        String locator = "(//ul[@class='top-menu notmobile']//ul)[" + selectedCategory + 1 + "]/li";
        subCategories = Hooks.webDriver.findElements(By.xpath(locator));


        Hooks.webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @And("user select a random sub category if exist otherwise select the main category")
    public void userSelectARandomSubCategoryIfExistOtherwiseSelectTheMainCategory() {
        if (!subCategories.isEmpty()) {

            int selectedSubCategory = (int) Math.floor(Math.random() * subCategories.size());
            selectedSubCategoryTitle = subCategories.get(selectedSubCategory).getText();
            subCategories.get(selectedSubCategory).click();

        } else {
            selectedSubCategoryTitle = mainCategories.get(selectedCategory).getText();
            mainCategories.get(selectedCategory).click();
        }

        Hooks.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("the page title should have the selected category name")
    public void thePageTitleShouldHaveTheSelectedCategoryName() {
        String actualTitle = homePage.categoriesTitlePom.getText().toLowerCase().trim();
        softAssert.assertEquals(actualTitle, selectedSubCategoryTitle.toLowerCase().trim(), "expected: ".concat(selectedCategoryText).concat(" but found: ").concat(actualTitle));

        softAssert.assertAll();
    }
}
