import org.junit.Test;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;


public class BunTest {

    @Test
    public void getNameShouldReturnName() {
        Bun bun = new Bun("Булка", 200);
        String expected = "Булка";
        String actual = bun.getName();
        assertEquals(expected, actual);
    }
    @Test
    public void getPriceShouldReturnPrice() {
        Bun bun = new Bun("Булка", 200);
        float expected = 200;
        float actual = bun.getPrice();
        assertEquals(expected, actual, 0.0f);
    }
    }
