import org.junit.Assert;
import org.junit.Test;
import praktikum.*;
import java.util.List;

public class BurgerTest {


    @Test
    public void checkPriceOnlyBun() {
        Database database = new Database();
        List<Bun> buns = database.availableBuns();
        Burger burger = new Burger();
        burger.setBuns(buns.get(0));
        Assert.assertEquals(200, burger.getPrice(), 0.0f);
    }

    @Test
    public void checkPriceWithIngredient() {
        Database database = new Database();
        List<Bun> buns = database.availableBuns();
        List<Ingredient> ingredients = database.availableIngredients();
        Burger burger = new Burger();
        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(0));
        Assert.assertEquals(300, burger.getPrice(), 0.0f);
    }

    @Test
    public void checkPriceWithDeletedIngredients() {
        Database database = new Database();
        List<Bun> buns = database.availableBuns();
        List<Ingredient> ingredients = database.availableIngredients();
        Burger burger = new Burger();
        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.removeIngredient(0);
        Assert.assertEquals(400, burger.getPrice(), 0.0f);
    }
    @Test
    public void checkPriceWithMovedIngredients() {
        Database database = new Database();
        List<Bun> buns = database.availableBuns();
        List<Ingredient> ingredients = database.availableIngredients();
        Burger burger = new Burger();
        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.moveIngredient(1, 0);
        Assert.assertEquals(500, burger.getPrice(), 0.0f);
        Assert.assertEquals(6, ingredients.size());
        //Assert.assertEquals(new Ingredient(IngredientType.FILLING, "dinosaur", 200), ingredients.get(4));
    }
    @Test
    public void checkReceipt() {
        Database database = new Database();
        List<Bun> buns = database.availableBuns();
        List<Ingredient> ingredients = database.availableIngredients();
        Burger burger = new Burger();
        burger.setBuns(buns.get(1));
        burger.addIngredient(ingredients.get(3));
        burger.getReceipt();
        String actual = burger.getReceipt();
        System.out.println(actual);

        Assert.assertEquals(("(==== white bun ====)" + "\r\n" +
                "= filling cutlet =" + "\r\n" +
                "(==== white bun ====)" + "\r\n"  + "\r\n" +
                "Price: 500,000000" + "\r\n"), actual);
    }

}