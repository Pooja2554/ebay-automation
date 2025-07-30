package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage {
    WebDriver driver;
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public DetailsPage clickFirstItem() {

        List<WebElement> bookLinks = driver.findElements(By.xpath("(//a[@class='image-treatment'])[1]"));

        if (!bookLinks.isEmpty()) {
            bookLinks.get(0).click();

            System.out.println("Clicked on the first book result.");
        } else {
            System.out.println("No book links found."+ bookLinks);
        }
        return new DetailsPage(driver);
    }



}
