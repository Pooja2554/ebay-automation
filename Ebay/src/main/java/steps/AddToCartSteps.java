package steps;

import io.cucumber.java.en.*;
import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import pages.*;
public class AddToCartSteps {
    WebDriver driver = BasePage.getDriver();
    HomePage home = new HomePage(driver);
    SearchPage results;
    DetailsPage details;
    CartPage cart;

    String url= "https://www.ebay.com/";

    @Given("I open the browser and navigate to ebay home page")
    public void openEbay() {
        driver.get(url);
    }

    @When("I search for {string}")
    public void searchForBook(String item) {
        results = home.searchForItem(item);
    }

    @When("I click on the first book in the search results")
    public void clickFirstBook() {
        details = results.clickFirstItem();
    }

    @When("I add the item to the cart")
    public void addItemToCart() {

        cart = details.addToCart();
    }

    @Then("check updated  cart and verify the cart has been updated with {string} item")
    public void verifyCartCount(String expectedCount) {
        cart = new CartPage(driver);
        String actualCount = cart.getCartCount();
        assertEquals(expectedCount, actualCount);
        BasePage.quitDriver();
    }
}

