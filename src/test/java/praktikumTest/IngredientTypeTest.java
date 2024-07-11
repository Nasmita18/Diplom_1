package praktikumTest;

import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void testIngredientTypeSauce() {
        assertEquals("SAUCE", IngredientType.SAUCE.toString());
    }

    @Test
    public void testIngredientTypeFilling() {
        assertEquals("FILLING", IngredientType.FILLING.toString());
    }
}
