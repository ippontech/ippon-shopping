package fr.ippon.examples.shopping;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ShoppingCartDefs {

    private ShoppingCart shoppingCart = new ShoppingCart();
    private String printedCart;
    private ShoppingCartException shoppingCartException;

    @Given("^a shopping cart:$")
    public void a_shopping_cart(List<Item> items) throws Throwable {
        for (Item item : items) {
            shoppingCart.addItem(item);
        }
    }

    @When("^I print that cart$")
    public void I_print_that_cart() throws Throwable {
        printedCart = shoppingCart.printCart();
    }

    @Then("^it should look like:$")
    public void it_should_look_like(String expected) throws Throwable {
        assertEquals(expected, printedCart);
    }

    @When("^I add some new running shoes$")
    public void I_add_another_running_shoe() throws Throwable {
        Item runningShoe = new Item("Running shoes", 140);
        try {
            shoppingCart.addItem(runningShoe);
        } catch (ShoppingCartException sce) {
            shoppingCartException = sce;
        }
    }

    @Then("^I should get an error$")
    public void I_should_get_an_error() throws Throwable {
        assertNotNull(shoppingCartException);
    }

    @Then("^I should have a gross price of \"([^\"]*)\"$")
    public void I_should_have_a_gross_price_of(BigDecimal expectedPrice) throws Throwable {
        assertThat(expectedPrice, comparesEqualTo(shoppingCart.getGrossPrice()));
    }
}
