import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient testFilling1, testFilling2, testSauce1, testSauce2;

    @Before
    public void testDataWithMock() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();
        // создаем тестовый список ингредиентов
        burger.bun = bun;
        burger.ingredients.add(testFilling1);
        burger.ingredients.add(testFilling2);
        burger.ingredients.add(testSauce1);
        burger.ingredients.add(testSauce2);
        // стабы методов для объекта класса Bun
        Mockito.when(bun.getName()).thenReturn("testBun");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        // стабы методов для объектов класса Ingredient
        Mockito.when(testFilling1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(testFilling2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(testSauce1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(testSauce2.getType()).thenReturn(IngredientType.SAUCE);

        Mockito.when(testFilling1.getName()).thenReturn("Filling 1");
        Mockito.when(testFilling2.getName()).thenReturn("Filling 2");
        Mockito.when(testSauce1.getName()).thenReturn("Sauce 1");
        Mockito.when(testSauce2.getName()).thenReturn("Sauce 2");

        Mockito.when(testFilling1.getPrice()).thenReturn(200F);
        Mockito.when(testFilling2.getPrice()).thenReturn(300F);
        Mockito.when(testSauce1.getPrice()).thenReturn(50F);
        Mockito.when(testSauce2.getPrice()).thenReturn(70F);
    }

    @Test
    public void setBunsVerify() {
        burger.bun.name = "testBun";
        burger.bun.price = 100F;
        burger.setBuns(bun);
        Assert.assertEquals("testBun", burger.bun.name);
        Assert.assertEquals(100F, burger.bun.price, 0.0F);
    }

    @Test
    public void addIngredientToIngredients1() {
        int countIngr = burger.ingredients.size();
        burger.addIngredient(testFilling1);
        Assert.assertEquals(countIngr+1, burger.ingredients.size());
    }

    @Test
    public void addIngredientToIngredients2() {
        int countIngr = burger.ingredients.size();
        burger.addIngredient(testFilling1);
        Assert.assertEquals(testFilling1, burger.ingredients.get(countIngr));
    }

    @Test
    public void removeIngredientFromIngredients1() {
        int countIngr = burger.ingredients.size();
        burger.removeIngredient(0);
        Assert.assertEquals(countIngr-1, burger.ingredients.size());
    }
    @Test
    public void checkMovingIngredient() {
        /* начальный порядок ингредиентов
            [0] testFilling1,
            [1] testFilling2,
            [2] testSauce1,
            [3] testSauce2*/

        burger.moveIngredient(2, 0);
        burger.moveIngredient(3, 2);
        /* измененный порядок ингредиентов
            [0] testSauce1,
            [1] testFilling1,
            [2] testSauce2,
            [3] testFilling2,*/

        Assert.assertEquals(testSauce1, burger.ingredients.get(0));
        Assert.assertEquals(testFilling1, burger.ingredients.get(1));
        Assert.assertEquals(testSauce2, burger.ingredients.get(2));
        Assert.assertEquals(testFilling2, burger.ingredients.get(3));
    }

    @Test
    public void getPriceEqualSumPriceOfIngredients() {
        // формула: priceOfBun * 2 + сумма ингредиентов
        Assert.assertEquals(820F, burger.getPrice(), 0.0F);
    }

    @Test
    public void getReceiptReturnsAllIngredientsString() {
        String expectedReceipt = String.format("(==== %s ====)%n", "testBun") + String.format("= %s %s =%n", "filling", "Filling 1") +
                String.format("= %s %s =%n", "filling", "Filling 2") +
                String.format("= %s %s =%n", "sauce", "Sauce 1") +
                String.format("= %s %s =%n", "sauce", "Sauce 2") +
                String.format("(==== %s ====)%n", "testBun") +
                String.format("%nPrice: %f%n", 820.0F);
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
    @After
    public void testDataClean() {
        burger.bun = null;
        burger.ingredients.clear();
    }
}
