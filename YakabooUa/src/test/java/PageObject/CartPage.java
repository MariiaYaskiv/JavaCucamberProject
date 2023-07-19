package PageObject;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By checkoutButton = By.cssSelector("button[class='ui-btn-primary microcart-summary-button']");
    private final By basketButton = By.xpath("//div[contains(text(), 'Кошик')]");
    private final By closeBasketButton = By.xpath("//button[@class='ui-btn-close']");
    private final By enableBook = By.cssSelector("a[class='product-name router-link-exact-active router-link-active']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void verifyTheBookInTheBasket() {
        Assertions.assertTrue(driver.findElement(enableBook).isDisplayed());
    }

    public void proceedToCheckout() {
        Assertions.assertTrue(driver.findElement(checkoutButton).isDisplayed());
        driver.findElement(checkoutButton).click();
    }

    public void clickOnBasketButton() {
        driver.findElement(basketButton).click();
    }

    public void clickOnCloseBasketButton() {
        driver.findElement(closeBasketButton).click();
    }
}
