package org.examples.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    WebDriver driver = null;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a.ico-register[href=\"/register?returnUrl=%2F\"]")
    public WebElement registerHyperLinkPom;

    @FindBy(css = "a.ico-login[href=\"/login?returnUrl=%2F\"]")
    public WebElement loginHyperLinkPom;

    @FindBy(css = "select[name=\"customerCurrency\"]")
    public WebElement currencyDropdownListPom;

    @FindBy(tagName = "option")
    public List<WebElement> currencyDropdownItemsPom;

    @FindBy(css = "span.price")
    public List<WebElement> productsPriceLabelsPom;

    @FindBy(css = "input.search-box-text[placeholder=\"Search store\"]")
    public WebElement searchInputPom;

    @FindBy(css = "button.search-box-button[type=\"submit\"]")
    public WebElement searchButtonPom;

    @FindBy(css = "h2.product-title")
    public List<WebElement> productsTitleLabelsPom;

    @FindBy(css = "div.item-box")
    public List<WebElement> productsPom;

    @FindBy(css = "div.sku")
    public WebElement productsSkuPom;
}