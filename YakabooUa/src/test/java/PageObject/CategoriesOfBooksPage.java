package PageObject;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoriesOfBooksPage extends BasePage {
    public CategoriesOfBooksPage(WebDriver driver) {
        super(driver);
    }

    private final By categoriesOfBooks = By.cssSelector("span[class='ui-btn-book-categories__title']");
    private final By complectsOfBooks = By.xpath("//span[contains(text(), 'Комплекти книжок')]");
    private final By bookCafe = By.cssSelector("img[src='https://static.yakaboo.ua/media/cloudflare/product/webp/352x340/_/-/_-1_15_34.jpg']");


    public void clickOnCategoriesOfBooks() {
        driver.findElement(categoriesOfBooks).click();
    }

    public void clickOnComplectsOfBooks() {
       // Assertions.assertTrue(driver.findElement(complectsOfBooks).isDisplayed());
        driver.findElement(complectsOfBooks).click();
    }

    public void clickOnBookCafe() {
        Assertions.assertTrue(driver.findElement(bookCafe).isDisplayed());
        driver.findElement(bookCafe).click();
    }
}

