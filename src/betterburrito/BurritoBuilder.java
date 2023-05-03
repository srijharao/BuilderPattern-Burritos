package betterburrito;

import burrito.PortionSize;
import burrito.Protein;
import burrito.Size;
import burrito.Topping;

/**
 * This abstract class represents a burrito builder can have an arbitrary number of proteins and
 * toppings, both of arbitrary portion sizes.
 */
public abstract class BurritoBuilder<T> {

  public abstract BurritoBuilder size(Size size);

  public abstract ObservableBurrito build();

  public abstract T addProtein(Protein protein, PortionSize size);

  public abstract T addTopping(Topping topping, PortionSize size);

  protected abstract T returnBuilder();
}
