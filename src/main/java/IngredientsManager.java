import exceptions.IngredientNotfoundException;
import exceptions.IngredientQuantityLowException;
import model.BaseIngredient;
import model.Beverage;
import model.Ingredient;

import java.util.HashMap;
import java.util.Map;

/**
 * IngredientsManager in a Singleton Class which manages all the ingredients in the coffee machine.
 * It defines the strategy checkAndUpdateIngredients to check if all the ingredients are present for a beverage and
 * updates the quantities of each ingredient if all are present with desired quantity
 * It is synchronized to implement thread safety
 */
public class IngredientsManager {
    private Map<String, Ingredient> availableIngredients = new HashMap<>();

    private IngredientsManager() {
    }

    public static IngredientsManager getInstance() {
        return IngredientsManagerSingleton.INGREDIENTS_MANAGER;
    }

    private static class IngredientsManagerSingleton {
        public static final IngredientsManager INGREDIENTS_MANAGER = new IngredientsManager();
    }

    public Map<String, Ingredient> getAvailableIngredients(){
        return this.availableIngredients;
    }

    public boolean addIngredient(String name, int intialQuantity, int minQuantity, int thresholdQuantity) {
        if (!availableIngredients.containsKey(name)) {
            BaseIngredient baseIngredient = new BaseIngredient(name, intialQuantity, minQuantity, thresholdQuantity);
            availableIngredients.put(name, baseIngredient);
            return true;
        }
        return false;
    }

    public void refillIngredient(String name, int quantity) {
        if (availableIngredients.containsKey(name)) {
            availableIngredients.get(name).refill(quantity);
        }
    }

    public synchronized void checkAndUpdateIngredients(Beverage beverage) throws IngredientNotfoundException, IngredientQuantityLowException {
        for (Map.Entry<String, Integer> ingredient : beverage.getIngredients().entrySet()) {
            if (!availableIngredients.containsKey(ingredient.getKey())) {
                throw new IngredientNotfoundException("model.Ingredient " + ingredient.getKey() + " does not exist.");
            }

            Ingredient i = availableIngredients.get(ingredient.getKey());
            if (i.getQuantity() < ingredient.getValue()) {
                throw new IngredientQuantityLowException(beverage.getName() + " cannot be prepared because " + ingredient.getKey() + " is not sufficient");
            }
        }

        for (Map.Entry<String, Integer> ingredient : beverage.getIngredients().entrySet()) {
            Ingredient i = availableIngredients.get(ingredient.getKey());
            i.consume(ingredient.getValue());
        }
    }

}
