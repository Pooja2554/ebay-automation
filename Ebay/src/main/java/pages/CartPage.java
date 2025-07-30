package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage  {
    WebDriver driver;
    By cartCount = By.xpath("//span[@role='img'][normalize-space()='1']");
    By addToCartText= By.xpath("//span[normalize-space()='Added to cart']");
    By closeButton=By.xpath("//button[@aria-label='Close overlay']");

    public CartPage(WebDriver driver) {

        this.driver=driver;
    }

    public String getCartCount()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartText));
        driver.findElement(closeButton).click();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(cartCount));
        return element.getText();
    }
}
