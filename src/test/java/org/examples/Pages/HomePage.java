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

    @FindBy(xpath = "//ul[@class=\"top-menu notmobile\"]/li")
    public List<WebElement> mainCategoriesBarPom;

    @FindBy(xpath = "//div[@class='page-title']//h1")
    public WebElement categoriesTitlePom;

    @FindBy(css = "div.nivoSlider")
    public WebElement sliderPom;

    @FindBy(css = "a.nivo-control")
    public List<WebElement> sliderSelectorPom;

    @FindBy(css = "a[href=\"http://www.facebook.com/nopCommerce\"]")
    public WebElement facebookFollowUsButtonPom;

    @FindBy(css = "a[href=\"https://twitter.com/nopCommerce\"]")
    public WebElement twitterFollowUsButtonPom;

    @FindBy(css = "a[href=\"/news/rss/1\"]")
    public WebElement rssFollowUsButtonPom;

    @FindBy(css = "a[href=\"http://www.youtube.com/user/nopCommerce\"]")
    public WebElement youtubeFollowUsButtonPom;
}
