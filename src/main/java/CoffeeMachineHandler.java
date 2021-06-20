import com.fasterxml.jackson.databind.ObjectMapper;
import model.Machine;

import java.io.IOException;

/**
 * Parses the json request and passess the beverage request to coffee machine.
 */
public class CoffeeMachineHandler {
    private static CoffeeMachine coffeeMachine;
    private static CoffeeMachineHandler coffeeMachineHandler;
    private static Machine machine;

    public static void process(String json) throws IOException {
        machine = new ObjectMapper().readValue(json, Machine.class);
        System.out.println("Starting machine");
        coffeeMachine = new CoffeeMachine(machine.getOutlet().getCount());

        machine.getItems().forEach((key, value) -> coffeeMachine.addIngredient(key, value, 0, 1000));

        machine.getBeverages().forEach((key, value) -> coffeeMachine.makeBeverage(key, value));
    }

    public static void stopMachine() {
        coffeeMachine.stop();
    }

    public static Machine getMachine() {
        return machine;
    }

}
