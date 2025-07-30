package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage  {
    WebDriver driver;

    @FindBy(id = "gh-ac")
    private WebElement searchBox;

    @FindBy(xpath = "//button[@id='gh-search-btn']")
    private WebElement searchBtn;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SearchPage searchForItem(String keyword) {
        searchBox.sendKeys(keyword);
        searchBtn.click();
        return new SearchPage(driver);
    }
}
