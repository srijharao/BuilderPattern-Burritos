import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import betterburrito.ObservableBurrito;
import betterburrito.CustomBurrito;
import betterburrito.VeggieBurrito;
import burrito.PortionSize;
import burrito.Protein;
import burrito.Size;
import burrito.Topping;
import org.junit.Test;

/**
 * This is the test class for burritos.
 */
public class ObservableBurritoTest {

  @Test
  public void testCostCustomBurrito() {
    ObservableBurrito customBurrito = new CustomBurrito.CustomBurritoBuilder()
        .size(Size.Normal)
        .addProtein(Protein.Tofu, PortionSize.Normal)
        .addTopping(Topping.Cheese, PortionSize.Normal)
        .addTopping(Topping.MediumSalsa, PortionSize.Less)
        .addTopping(Topping.SourCream, PortionSize.Extra)
        .build();
    assertEquals(5.9, customBurrito.cost(), 0.01);
  }

  @Test
  public void testCostVeggieBurrito() {
    ObservableBurrito veggieBurrito = new VeggieBurrito.VeggieBurritoBuilder()
        .size(Size.Jumbo)
        .build();
    assertEquals(7.2, veggieBurrito.cost(), 0.01);
  }

  @Test
  public void testCostVeggieBurritoWithNoGuacamole() {
    ObservableBurrito veggieBurrito = new VeggieBurrito.VeggieBurritoBuilder()
        .size(Size.Jumbo)
        .noGuacamole()
        .build();
    assertEquals(5.2, veggieBurrito.cost(), 0.01);
    assertNull(veggieBurrito.hasTopping(Topping.Guacamole));
  }

  @Test
  public void testCostVeggieBurritoWithNoCheese() {
    ObservableBurrito veggieBurrito = new VeggieBurrito.VeggieBurritoBuilder()
        .size(Size.Jumbo)
        .noCheese()
        .build();
    assertEquals(6.2, veggieBurrito.cost(), 0.01);
    assertNull(veggieBurrito.hasTopping(Topping.Cheese));
  }

  @Test
  public void testCostVeggieBurritoWithNoBlackBeans() {
    ObservableBurrito veggieBurrito = new VeggieBurrito.VeggieBurritoBuilder()
        .size(Size.Jumbo)
        .noBlackBeans()
        .build();
    assertEquals(5.7, veggieBurrito.cost(), 0.01);
    assertNull(veggieBurrito.hasProtein(Protein.BlackBeans));
  }

  @Test
  public void testCostVeggieBurritoWithNoMediumSalsa() {
    ObservableBurrito veggieBurrito = new VeggieBurrito.VeggieBurritoBuilder()
        .size(Size.Jumbo)
        .noMediumSalsa()
        .build();
    assertEquals(6.2, veggieBurrito.cost(), 0.01);
    assertNull(veggieBurrito.hasTopping(Topping.MediumSalsa));
  }

  @Test
  public void testCostVeggieBurritoWithBuilder() {
    ObservableBurrito veggieBurrito = new VeggieBurrito.VeggieBurritoBuilder()
        .size(Size.Jumbo)
        .addProtein(Protein.Tofu, PortionSize.Normal)
        .addTopping(Topping.Cilantro, PortionSize.Normal)
        .addTopping(Topping.Corn, PortionSize.Normal)
        .addTopping(Topping.Onion, PortionSize.Normal)
        .addTopping(Topping.Jalapeno, PortionSize.Normal)
        .addTopping(Topping.Queso, PortionSize.Normal)
        .addTopping(Topping.HotSalsa, PortionSize.Normal)
        .addTopping(Topping.MildSalsa, PortionSize.Normal)
        .build();
    assertEquals(15.2, veggieBurrito.cost(), 0.01);
  }

  @Test
  public void testCostCustomBurritoWithBuilder() {
    ObservableBurrito customBurrito = new CustomBurrito.CustomBurritoBuilder()
        .size(Size.Jumbo)
        .addProtein(Protein.Fish, PortionSize.Normal)
        .addProtein(Protein.Chicken, PortionSize.Normal)
        .addProtein(Protein.Carnitas, PortionSize.Normal)
        .addTopping(Topping.Cilantro, PortionSize.Normal)
        .addTopping(Topping.Corn, PortionSize.Normal)
        .addTopping(Topping.Onion, PortionSize.Normal)
        .addTopping(Topping.Jalapeno, PortionSize.Normal)
        .addTopping(Topping.Queso, PortionSize.Normal)
        .addTopping(Topping.HotSalsa, PortionSize.Normal)
        .addTopping(Topping.Lettuce, PortionSize.Normal)
        .addTopping(Topping.MildSalsa, PortionSize.Normal)
        .addTopping(Topping.MediumSalsa, PortionSize.Normal)
        .build();
    assertEquals(15.45, customBurrito.cost(), 0.01);
  }
}