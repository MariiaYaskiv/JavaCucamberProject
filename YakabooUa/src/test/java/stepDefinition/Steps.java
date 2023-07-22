package stepDefinition;

import PageObject.*;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Steps {
    String url = "https://www.yakaboo.ua/";
    protected WebDriver driver;

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("I open the Yakaboo website")
    public void openYakabooWebsite() {
        System.setProperty("webDriver.chrome.driver", "D:\\ITEA java courses automation\\JavaCucamberProject\\YakabooUa\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Then("the page title should be {string}")
    public void verifyPageTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @When("I search for {string}")
    public void iSearchFor(String bookTitle) {
        HomePage homePage = new HomePage(driver);
        homePage.searchForBook("Сара Джіо");
    }

    @And("I click on the first search result")
    public void iClickOnTheFirstSearchResult() {
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.clickFirstSearchResult();
    }

    @And("I add the book to the cart")
    public void iAddTheBookToTheCart() {
        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();
    }

    @And("I click on the basket")
    public void iClickOnTheBasket() {
        ProductPage productPage = new ProductPage(driver);
        productPage.enterToTheBasket();
    }

    @And("I proceed to checkout")
    public void iProceedToCheckout() {
        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();
    }

    @And("I enter my personal information")
    public void iEnterMyPersonalInformation() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterPersonalInformation("Oliver", "Simson", "0938141165", "mari4ka@gmail.com", "Львів");
    }

    @And("I complete the purchase")
    public void iCompleteThePurchase() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickOnCity();
        checkoutPage.clickOnPost();
        checkoutPage.selectPaymentMethod();
        checkoutPage.clickOnSubmitButton();
    }

    @When("I click on the Категорії книг tab")
    public void iClickOnTheTab() {
        CategoriesOfBooksPage categoriesOfBooksPage = new CategoriesOfBooksPage(driver);
        categoriesOfBooksPage.clickOnCategoriesOfBooks();
    }

    @And("I select Комплекти книжок")
    public void iSelect() {
        CategoriesOfBooksPage categoriesOfBooksPage = new CategoriesOfBooksPage(driver);
        categoriesOfBooksPage.clickOnComplectsOfBooks();
    }

    @And("I select Елізабет Гілберт book from the list")
    public void iSelectBookFromTheList() {
        CategoriesOfBooksPage categoriesOfBooksPage = new CategoriesOfBooksPage(driver);
        categoriesOfBooksPage.clickOnBookCafe();
    }

    @And("I click the button to close the window")
    public void iClickTheButtonToCloseTheWindow() {
        ProductPage productPage = new ProductPage(driver);
        productPage.clickOnTheButtonToCloseTheWindow();
    }

    @When("I click on Burger menu")
    public void iClickOnBurgerMenu() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnBurgerMenu();
    }

    @And("I click on my basket")
    public void iClickOnMyBasket() {
        CartPage cartPage = new CartPage(driver);
        cartPage.clickOnBasketButton();
    }

    @And("I want to close the basket")
    public void iWantToCloseTheBasket() {
        CartPage cartPage = new CartPage(driver);
        cartPage.clickOnCloseBasketButton();
    }

    @And("I want to verify if I am on Home Page")
    public void iWantToVerifyIfIAmOnHomePage() {
        HomePage homePage = new HomePage(driver);
        homePage.verifyMainTitle();
    }

    @Then("{string} Should exist in the main page:")
    public void shouldBeVisibleInTheMainPage(String menuItem) {
        HomePage homePage = new HomePage(driver);
        Assertions.assertNotNull(homePage.isMenuItemVisible(menuItem), menuItem + " not found.");
    }

    @And("Ensure that hte book is in the basket")
    public void ensureThatHteBookIsThere() {
        CartPage cartPage = new CartPage(driver);
        cartPage.verifyTheBookInTheBasket();
    }
}
