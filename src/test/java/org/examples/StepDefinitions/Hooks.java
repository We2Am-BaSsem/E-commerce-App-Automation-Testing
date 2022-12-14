package org.examples.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.examples.Pages.HomePage;
import org.examples.Pages.LoginPage;
import org.examples.Pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver webDriver = null;
    String url = "https://demo.nopcommerce.com/";

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.navigate().to(url);
    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.quit();
    }

    public static void navigateToAnotherTab(int tabIndex, int expectedOpenedTabs) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(expectedOpenedTabs));

        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        System.out.println(tabs.size());

        webDriver.switchTo().window(tabs.get(tabIndex));
    }
}
