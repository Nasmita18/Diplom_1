package praktikumTest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BurgerTest {

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient;

    private Burger burger;

    @Before
    public void setUp() {
        mockBun = mock(Bun.class);
        mockIngredient = mock(Ingredient.class);
        burger = new Burger();
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(mockBun);
        assertEquals(mockBun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(mockIngredient);
        burger.addIngredient(mockIngredient);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(mockIngredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        when(mockIngredient.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient.getName()).thenReturn("Cheese");
        when(mockIngredient.getPrice()).thenReturn(50f);

        burger.addIngredient(mockIngredient);
        burger.addIngredient(mockIngredient);

        burger.moveIngredient(1, 0);

        assertEquals(mockIngredient, burger.ingredients.get(0));
        assertEquals(mockIngredient, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        when(mockBun.getPrice()).thenReturn(100f);
        when(mockIngredient.getPrice()).thenReturn(50f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);
        burger.addIngredient(mockIngredient);

        assertEquals(300, burger.getPrice(), 0.001);
    }

    @Test
    public void testGetReceipt() {
        when(mockBun.getName()).thenReturn("White Bun");
        when(mockBun.getPrice()).thenReturn(100f);

        when(mockIngredient.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient.getName()).thenReturn("Cheese");
        when(mockIngredient.getPrice()).thenReturn(50f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);
        burger.addIngredient(mockIngredient);

        String expectedReceipt = "(==== White Bun ====)\n" +
                "= filling Cheese =\n" +
                "= filling Cheese =\n" +
                "(==== White Bun ====)\n" +
                "\n" +
                "Price: 300,000000\n";
        System.out.println(expectedReceipt);
        System.out.println(burger.getReceipt());

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
