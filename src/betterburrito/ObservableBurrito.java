package betterburrito;

import burrito.PortionSize;
import burrito.Protein;
import burrito.Topping;

/**
 * This interface represents all the operations offered by a burrito.
 */
public interface ObservableBurrito {

  /**
   * Calculate and return the cost of this burrito using its ingredients.
   *
   * @return the cost of this burrito in USD, MM.XX format
   */
  double cost();

  /**
   * Determines if the specified topping is on this burrito and if so, return its portion.
   *
   * @param name name of topping
   * @return the portion of this topping on this burrito, or null if topping is not on burrito
   */
  PortionSize hasTopping(Topping name);

  /**
   * Determines if the specified protein is on this burrito and if so, return its portion.
   *
   * @param name name of the protein
   * @return portion of the protein on this burrito, or null if portion not in burrito
   */
  PortionSize hasProtein(Protein name);

}
