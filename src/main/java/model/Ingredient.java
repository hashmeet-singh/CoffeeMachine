package model;

import exceptions.IngredientQuantityLowException;

/**
 * Ingredient interface defining key methods to consume and refill the ingredient
 */
public interface Ingredient {
    String getName();
    int getQuantity();
    boolean isRunningLow();
    void refill(int quantity);
    void consume(int quantity) throws IngredientQuantityLowException;
}
