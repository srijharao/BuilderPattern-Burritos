package betterburrito;

import burrito.PortionSize;
import burrito.Protein;
import burrito.Size;
import burrito.Topping;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a veggie burrito. A veggie burrito has black beans,
 * medium salsa, cheese, lettuce, and guacamole, all in the regular portions.
 */
public class VeggieBurrito implements ObservableBurrito {

  protected final Map<Protein, PortionSize> proteins;
  protected final Map<Topping, PortionSize> toppings;
  protected Size size;

  /**
   * Create a custom burrito of the specified size.
   */
  public VeggieBurrito() {
    this.proteins = new HashMap<>();
    this.toppings = new HashMap<>();
  }

  @Override
  public PortionSize hasTopping(Topping name) {
    return this.toppings.getOrDefault(name, null);
  }

  @Override
  public PortionSize hasProtein(Protein name) {
    return this.proteins.getOrDefault(name, null);
  }

  @Override
  public double cost() {
    double cost = 0.0;
    for (Map.Entry<Protein, PortionSize> item : this.proteins.entrySet()) {
      cost += item.getKey().getCost() * item.getValue().getCostMultipler();
    }

    for (Map.Entry<Topping, PortionSize> item : this.toppings.entrySet()) {
      cost += item.getKey().getCost() * item.getValue().getCostMultipler();
    }
    return cost + this.size.getBaseCost();
  }

  /**
   * BurritoBuilder class to create an object.
   */
  public static class VeggieBurritoBuilder extends BurritoBuilder<VeggieBurritoBuilder> {

    betterburrito.VeggieBurrito veggieBurrito;

    /**
     * Create a custom burrito.
     */
    public VeggieBurritoBuilder() {
      this.veggieBurrito = new VeggieBurrito();
      this.veggieBurrito.proteins.put(Protein.BlackBeans, PortionSize.Normal);
      this.veggieBurrito.toppings.put(Topping.MediumSalsa, PortionSize.Normal);
      this.veggieBurrito.toppings.put(Topping.Cheese, PortionSize.Normal);
      this.veggieBurrito.toppings.put(Topping.Lettuce, PortionSize.Normal);
      this.veggieBurrito.toppings.put(Topping.Guacamole, PortionSize.Normal);
    }

    public VeggieBurritoBuilder size(Size size) {
      this.veggieBurrito.size = size;
      return returnBuilder();
    }

    public VeggieBurritoBuilder addProtein(Protein protein, PortionSize size) {
      returnBuilder().veggieBurrito.proteins.put(protein, size);
      return returnBuilder();
    }

    public VeggieBurritoBuilder addTopping(Topping topping, PortionSize size) {
      returnBuilder().veggieBurrito.toppings.put(topping, size);
      return returnBuilder();
    }

    /**
     * Build a custom veggie burrito with no cheese.
     *
     * @return custom veggie burrito with no cheese
     */
    public VeggieBurritoBuilder noCheese() {
      returnBuilder().veggieBurrito.toppings.remove(Topping.Cheese);
      return returnBuilder();
    }

    /**
     * Build a custom veggie burrito with no black beans.
     *
     * @return custom veggie burrito with no black beans
     */
    public VeggieBurritoBuilder noBlackBeans() {
      returnBuilder().veggieBurrito.proteins.remove(Protein.BlackBeans);
      return returnBuilder();
    }

    /**
     * Build a custom veggie burrito with no medium salsa.
     *
     * @return custom veggie burrito with no medium salsa
     */
    public VeggieBurritoBuilder noMediumSalsa() {
      returnBuilder().veggieBurrito.toppings.remove(Topping.MediumSalsa);
      return returnBuilder();
    }

    /**
     * Build a custom veggie burrito with no lettuce.
     *
     * @return custom veggie burrito with no lettuce
     */
    public VeggieBurritoBuilder noLettuce() {
      returnBuilder().veggieBurrito.toppings.remove(Topping.Lettuce);
      return returnBuilder();
    }

    /**
     * Build a custom veggie burrito with no guacamole.
     *
     * @return custom veggie burrito with no guacamole
     */
    public VeggieBurritoBuilder noGuacamole() {
      returnBuilder().veggieBurrito.toppings.remove(Topping.Guacamole);
      return returnBuilder();
    }

    /**
     * Builder method returns CustomBurrito object.
     * @return Burrito object
     * @throws IllegalStateException when size is empty
     */
    public betterburrito.VeggieBurrito build() throws IllegalStateException {
      if (returnBuilder().veggieBurrito.size == null) {
        throw new IllegalStateException();
      }
      return returnBuilder().veggieBurrito;
    }

    protected VeggieBurritoBuilder returnBuilder() {
      return this;
    }
  }
}
