package model;

import exceptions.IngredientQuantityLowException;

import java.util.Objects;

public class BaseIngredient implements Ingredient {
    private String name;
    private int quantity;
    private int minQuantity;
    private int threshold;

    public BaseIngredient(String name, int quantity, int minQuantity, int threshold) {
        this.name = name;
        this.quantity = quantity;
        this.minQuantity = minQuantity;
        this.threshold = threshold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(int minQuantity) {
        this.minQuantity = minQuantity;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public void refill(int qty) {
        if (this.quantity + qty > threshold) {
            this.quantity = threshold;
        } else {
            this.quantity += qty;
        }
    }

    @Override
    public void consume(int qty) throws IngredientQuantityLowException {
        if (qty > this.quantity) {
            throw new IngredientQuantityLowException(this.name + " is not sufficient. Please refill");
        }
        this.quantity -= qty;
    }

    @Override
    public boolean isRunningLow() {
        return this.quantity < minQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseIngredient that = (BaseIngredient) o;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
