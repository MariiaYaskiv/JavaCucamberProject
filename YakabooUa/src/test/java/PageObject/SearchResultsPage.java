package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage extends BasePage {
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    private final By firstSearchResult = By.cssSelector("a[href='/ua/sara-dzhio-komplekt-iz-3-knig.html']");

    public void clickFirstSearchResult() {
        WebElement result = driver.findElement(firstSearchResult);
        result.click();
    }
}