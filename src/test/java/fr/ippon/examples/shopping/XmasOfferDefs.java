package fr.ippon.examples.shopping;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;

public class XmasOfferDefs {

    private ItemFactory itemFactory = ItemFactory.getInstance();
    private DateSingleton dateSingleton = DateSingleton.getInstance();

    private ShoppingCart shoppingCart = new ShoppingCart();
    private ShoppingCartException shoppingCartException;

    @Given("^a christmas shopping cart:$")
    public void a_christmas_shopping_cart(List<Item> items) throws Throwable {
        for (Item item : items) {
            shoppingCart.addItem(item);
        }
    }

    @Given("^I add a candy bar to the cart$")
    public void I_add_a_candy_bar() throws Throwable {
        Item candyBar = itemFactory.createItem("Candy bar", 1, "food");
        shoppingCart.addItem(candyBar);
    }

    @Given("^I add a black belt to the cart$")
    public void I_add_a_black_belt() throws Throwable {
        Item blackBelt = itemFactory.createItem("Black belt", 60, "judo");
        try {
            shoppingCart.addItem(blackBelt);
        } catch (ShoppingCartException sce) {
            shoppingCartException = sce;
        }
    }

    @When("^It is December$")
    public void it_is_December() throws Throwable {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2012, Calendar.DECEMBER, 01);
        dateSingleton.setCurrentDate(calendar);
    }

    @When("^It is not December$")
    public void it_is_not_December() throws Throwable {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2013, Calendar.JANUARY, 01);
        dateSingleton.setCurrentDate(calendar);
    }

    @Then("^I should have a net price of \"([^\"]*)\"$")
    public void I_should_have_a_net_price_of(BigDecimal expectedPrice) throws Throwable {
        assertThat(expectedPrice, comparesEqualTo(shoppingCart.getNetPrice()));
    }
}
