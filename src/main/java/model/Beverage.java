package model;

import java.util.Map;

/**
 * Beverage Interface with name and ingredients as key attributes
 */
public interface Beverage {
    String getName();
    Map<String, Integer> getIngredients();
}
