package betterburrito;

import burrito.PortionSize;
import burrito.Protein;
import burrito.Size;
import burrito.Topping;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a custom burrito that can have an arbitrary number of proteins and
 * toppings, both of arbitrary portion sizes.
 */
public class CustomBurrito implements ObservableBurrito {

  protected final Map<Protein, PortionSize> proteins;
  protected final Map<Topping, PortionSize> toppings;
  protected Size size;

  /**
   * Create a custom burrito of the specified size.
   */
  public CustomBurrito() {
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
  public static class CustomBurritoBuilder extends BurritoBuilder<CustomBurritoBuilder> {

    betterburrito.CustomBurrito customBurrito;

    /**
     * Create a custom burrito.
     */
    public CustomBurritoBuilder() {
      returnBuilder().customBurrito = new CustomBurrito();
    }

    public CustomBurritoBuilder size(Size size) {
      returnBuilder().customBurrito.size = size;
      return returnBuilder();
    }

    public CustomBurritoBuilder addProtein(Protein protein, PortionSize size) {
      returnBuilder().customBurrito.proteins.put(protein, size);
      return returnBuilder();
    }

    public CustomBurritoBuilder addTopping(Topping topping, PortionSize size) {
      returnBuilder().customBurrito.toppings.put(topping, size);
      return returnBuilder();
    }

    /**
     * Builder method returns CustomBurrito object.
     * @return Burrito object
     * @throws IllegalStateException when size is empty
     */
    public betterburrito.CustomBurrito build() throws IllegalStateException {
      if (returnBuilder().customBurrito.size == null) {
        throw new IllegalStateException();
      }
      return returnBuilder().customBurrito;
    }

    protected CustomBurritoBuilder returnBuilder() {
      return this;
    }
  }
}
