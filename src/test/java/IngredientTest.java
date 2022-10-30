import org.junit.Test;
import praktikum.*;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;


public class IngredientTest {
    @Test
    public void getNameShouldReturnName() {
        Ingredient ingredient = new Ingredient(SAUCE, "hot sauce", 200);
        String expected = "hot sauce";
        String actual = ingredient.getName();
        assertEquals(expected, actual);
    }
    @Test
    public void getPriceShouldReturnPrice() {
        Ingredient ingredient = new Ingredient(SAUCE, "hot sauce", 200);
        float expected = 200;
        float actual = ingredient.getPrice();
        assertEquals(expected, actual, 0.0f);
    }

    @Test
    public void getTypeShouldReturnType() {
        Ingredient ingredient = new Ingredient(SAUCE, "hot sauce", 200);
        IngredientType actual = ingredient.getType();
        assertEquals(SAUCE, actual);
    }
}