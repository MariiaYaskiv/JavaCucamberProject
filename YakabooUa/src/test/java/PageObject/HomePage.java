package PageObject;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By searchInput = By.cssSelector("input[id='search']");

    private final By burgerMenu = By.cssSelector("button[class='ui-btn-double-line ']");
    private final By mainTitle = By.xpath("//h1[contains(text(), 'Нація, що читає – непереможна!')]");

    public void searchForBook(String bookTitle) {
        Assertions.assertTrue(driver.findElement(searchInput).isDisplayed());
        driver.findElement(searchInput).sendKeys(bookTitle);
    }

    public void clickOnBurgerMenu() {
        Assertions.assertTrue(driver.findElement(burgerMenu).isDisplayed());
        driver.findElement(burgerMenu).click();
    }
    public void verifyMainTitle() {
        Assertions.assertTrue(driver.findElement(mainTitle).isDisplayed());
        driver.findElement(mainTitle).click();
    }
}