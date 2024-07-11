package praktikumTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;
    private final String expectedName;
    private final float expectedPrice;

    public BunTest(String name, float price, String expectedName, float expectedPrice) {
        this.name = name;
        this.price = price;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {"testBun1", 100f, "testBun1", 100f},
                {"testBun2", 200f, "testBun2", 200f},
                {"testBun3", 300f, "testBun3", 300f}
        };
    }

    @Test
    public void testBunGetName() {
        Bun bun = new Bun(name, price);
        assertEquals(expectedName, bun.getName());
    }

    @Test
    public void testBunGetPrice() {
        Bun bun = new Bun(name, price);
        assertEquals(expectedPrice, bun.getPrice(), 0.001);
    }
}
