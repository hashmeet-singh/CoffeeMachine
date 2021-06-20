package model;

import exceptions.IngredientQuantityLowException;

public interface Ingredient {
    String getName();
    int getQuantity();
    boolean isRunningLow();
    void refill(int quantity);
    void consume(int quantity) throws IngredientQuantityLowException;
}
