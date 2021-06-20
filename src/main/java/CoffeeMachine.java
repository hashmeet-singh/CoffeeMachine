import model.BaseBeverage;
import model.Beverage;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CoffeeMachine {
    private static CoffeeMachine coffeeMachine;
    private ExecutorService executorService;
    private IngredientsManager ingredientsManager;
    private int outlets;

    public CoffeeMachine(int outlets) {
        this.outlets = outlets;
        ingredientsManager = IngredientsManager.getInstance();
        this.executorService = Executors.newFixedThreadPool(outlets);
    }

    public boolean addIngredient(String name, int initialQuantity, int minQuantity, int thresholdQuantity) {
        return ingredientsManager.addIngredient(name, initialQuantity, minQuantity, thresholdQuantity);
    }

    public void makeBeverage(String name, Map<String, Integer> ingredients) {
        Beverage baseBeverage = new BaseBeverage(name, ingredients);
        executorService.execute(new BeverageCreationTask(baseBeverage));
    }

    public void refillIngredient(String name, int quantity) {
        ingredientsManager.refillIngredient(name, quantity);
    }

    public void ingredientsIndicator() {

    }

    public int getOutlets() {
        return this.outlets;
    }

    public void stop() {
        executorService.shutdown();
    }
}
