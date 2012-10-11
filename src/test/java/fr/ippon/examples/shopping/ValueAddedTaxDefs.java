package fr.ippon.examples.shopping;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;

public class ValueAddedTaxDefs {

    private ItemFactory itemFactory = ItemFactory.getInstance();

    private Item item;
    private ShoppingCart shoppingCart = new ShoppingCart();
    private BigDecimal vat;

    @Given("^140 Euros running shoes$")
    public void a_140_euros_running_shoes() throws Throwable {
        item = itemFactory.createItem("Running shoes", 140);
    }

    @Given("^a 1 Euro candy bar$")
    public void a_1_euro_candy_bar() throws Throwable {
        item = itemFactory.createItem("Candy bar", 1, "food");
    }

    @Given("^a 60 Euros black belt$")
    public void a_60_euros_black_belt() throws Throwable {
        item = itemFactory.createItem("Black belt", 60, "judo");
    }

    @When("^I calculate the item's VAT$")
    public void I_calculate_the_item_VAT() throws Throwable {
        this.vat = item.calculateVAT();
    }

    @Given("^a shopping cart with 1 pair of running shoes, 1 black belt, 1 tatami and 2 candy bars$")
    public void a_shopping_cart_with_lots_of_items() throws Throwable {
        shoppingCart.addItem(itemFactory.createItem("Running shoes", 140));
        shoppingCart.addItem(itemFactory.createItem("Black belt", 60, "judo"));
        shoppingCart.addItem(itemFactory.createItem("Tatami", 80, "judo"));
        shoppingCart.addItem(itemFactory.createItem("Candy bar", 1, "food"));
        shoppingCart.addItem(itemFactory.createItem("Candy bar", 1, "food"));
    }

    @When("^I calculate the cart's VAT$")
    public void I_calculate_the_cart_VAT() throws Throwable {
        this.vat = shoppingCart.calculateVAT();
    }

    @Then("^The VAT must be \"([^\"]*)\" Euros$")
    public void the_VAT_must_be(BigDecimal expectedVat) throws Throwable {
        assertThat(expectedVat, comparesEqualTo(this.vat));
    }
}
