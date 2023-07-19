@CriticalPath
Feature: Yakaboo Website Tests
  As a user
  I want to be able to search for books and add them to my cart on the Yakaboo website

  Scenario: Verify Home Page Title
    Given I open the Yakaboo website
    Then the page title should be "YAKABOO – інтернет-магазин книг, подарунків та дитячих товарів. Купити книги в магазині за найкращими цінами в Україні"

  Scenario: Adding a book to the cart from search and buy it
    Given I open the Yakaboo website
    When I search for "Сара Джіо"
    And I click on the first search result
    And I add the book to the cart
    And I click on the basket
    And Ensure that hte book is in the basket

  Scenario: Select the book from the "Categories of books" tab and buy it
    Given I open the Yakaboo website
    When I click on the Категорії книг tab
    And I select Комплекти книжок
    And I select Елізабет Гілберт book from the list
    And I add the book to the cart
    And I click the button to close the window
    And I click on the basket
    And I proceed to checkout
    And I enter my personal information
    And I complete the purchase

  Scenario: Checking that it is possible to see the basket without purchasing
    Given I open the Yakaboo website
    When I click on Burger menu
    And I click on my basket
    And I want to close the basket
    And I want to verify if I am on Home Page

  Scenario Outline: Checking all the elements in menu
    Given I open the Yakaboo website
    Then "<Menu Item>" Should exist in the main page:
    Examples:
      | Menu Item        |
      | Друковані книги  |
      | Електронні книги |
      | Аудіокниги       |
