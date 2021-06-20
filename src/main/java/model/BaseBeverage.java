package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BaseBeverage implements Beverage {
    private String name;
    Map<String, Integer> ingredients;

    public BaseBeverage(String name, Map<String, Integer> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public BaseBeverage(String name) {
        this.name = name;
        this.ingredients = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map<String, Integer> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(String name, int quantity){
        ingredients.put(name, quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseBeverage baseBeverage = (BaseBeverage) o;
        return getName().equals(baseBeverage.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
