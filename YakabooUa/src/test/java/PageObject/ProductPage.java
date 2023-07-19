package PageObject;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private final By addToCartButton = By.cssSelector("div[class='product-sidebar__ordering'] button[class='ui-btn-secondary add-to-cart'][data-testid='addToCart']");

    private final By basketButton = By.cssSelector("img[src='/dist/shopping-cart.svg?1f289199142602df7b89714b33a9ce9a']");
    private final By buttonToCloseTheWindow = By.cssSelector("button[class='ui-btn-close product-layout__close']");
    public void addToCart() {
        Assertions.assertTrue(driver.findElement(addToCartButton).isDisplayed());
        driver.findElement(addToCartButton).click();
    }

    public void enterToTheBasket() {
        Assertions.assertTrue(driver.findElement(basketButton).isDisplayed());
        driver.findElement(basketButton).click();
    }

    public void clickOnTheButtonToCloseTheWindow() {
        Assertions.assertTrue(driver.findElement(buttonToCloseTheWindow).isDisplayed());
        driver.findElement(buttonToCloseTheWindow).click();
    }
}