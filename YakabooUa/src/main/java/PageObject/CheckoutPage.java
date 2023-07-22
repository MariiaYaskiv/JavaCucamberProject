package PageObject;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private final By nameInput = By.cssSelector("input[name='first name']");
    private final By surnameInput = By.cssSelector("input[name='last name']");
    private final By numberInput = By.cssSelector("input[type='tel'][class='ui-base-input']");
    private final By emailInput = By.cssSelector("input[name='email']");
    private final By cityInput = By.cssSelector("input[placeholder='Введіть назву міста...']");
    private final By chooseCity = By.xpath("//li[contains(text(),'Львів')][position()=1]");
    private final By choosePost = By.cssSelector("input[placeholder='Адреса відділення']");
    private final By chooseAndClickPost = By.xpath("//div[contains(text(),'Відділення №1: вул. Городоцька, 359')]");
    private final By choosePayment = By.xpath("//div[contains(text(),'Готівкою або карткою: При отриманні')]");
    private final By submitButton = By.cssSelector("div[class='pay-info'] div[class='order-submit-inner'] div[class='order-submit__submit']");


    public void enterPersonalInformation(String name, String surname, String number, String email, String city) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(surnameInput).sendKeys(surname);
        driver.findElement(numberInput).sendKeys(number);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(cityInput).sendKeys(city);
    }

    public void clickOnCity() {
        Assertions.assertTrue(driver.findElement(chooseCity).isDisplayed());
        driver.findElement(chooseCity).click();
    }

    public void clickOnPost() {
        Assertions.assertTrue(driver.findElement(choosePost).isDisplayed());
        driver.findElement(choosePost).click();
        Assertions.assertTrue(driver.findElement(chooseAndClickPost).isDisplayed());
        driver.findElement(chooseAndClickPost).click();
    }

    public void selectPaymentMethod() {
        Assertions.assertTrue(driver.findElement(choosePayment).isDisplayed());
        driver.findElement(choosePayment).click();
    }

    public void clickOnSubmitButton() {
        Assertions.assertTrue(driver.findElement(submitButton).isDisplayed());
        driver.findElement(submitButton).click();
    }
}