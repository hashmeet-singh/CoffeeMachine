import com.fasterxml.jackson.databind.ObjectMapper;
import model.Machine;

import java.io.IOException;

public class CoffeeMachineHandler {
    private static CoffeeMachine coffeeMachine;
    private static CoffeeMachineHandler coffeeMachineHandler;
    private static Machine machine;

    public static void process(String json) throws IOException {
        machine = new ObjectMapper().readValue(json, Machine.class);
        System.out.println("Starting machine");
        coffeeMachine = new CoffeeMachine(machine.getOutlet().getCount());

        machine.getItems().entrySet().forEach(item -> {
            coffeeMachine.addIngredient(item.getKey(), item.getValue(), 0, 1000);
        });

        machine.getBeverages().entrySet().forEach(beverage -> {
            coffeeMachine.makeBeverage(beverage.getKey(), beverage.getValue());
        });
    }

    public static void stopMachine() {
        coffeeMachine.stop();
    }

    public Machine getMachine() {
        return machine;
    }

}
