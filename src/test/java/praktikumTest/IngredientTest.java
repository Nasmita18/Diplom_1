package praktikumTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;
    private final IngredientType expectedType;
    private final String expectedName;
    private final float expectedPrice;

    public IngredientTest(IngredientType type, String name, float price, IngredientType expectedType, String expectedName, float expectedPrice) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {IngredientType.SAUCE, "testSauce1", 50f, IngredientType.SAUCE, "testSauce1", 50f},
                {IngredientType.FILLING, "testFilling1", 75f, IngredientType.FILLING, "testFilling1", 75f},
                {IngredientType.SAUCE, "testSauce2", 100f, IngredientType.SAUCE, "testSauce2", 100f},
        };
    }

    @Test
    public void testIngredientGetType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(expectedType, ingredient.getType());
    }

    @Test
    public void testIngredientGetName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(expectedName, ingredient.getName());
    }

    @Test
    public void testIngredientGetPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(expectedPrice, ingredient.getPrice(), 0.001);
    }
}
