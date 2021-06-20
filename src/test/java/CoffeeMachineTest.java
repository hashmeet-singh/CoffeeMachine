import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class CoffeeMachineTest {
    @Test
    public void test() throws IOException {
        String json = readFile("src/test/resources/test1.json");
        CoffeeMachineHandler.process(json);
        CoffeeMachineHandler.stopMachine();
    }

    @Test
    public void assertIngredientsItems() throws IOException {
        String json = readFile("src/test/resources/test1.json");
        CoffeeMachineHandler.process(json);
        Assert.assertEquals(5, IngredientsManager.getInstance().getAvailableIngredients().size());
    }

    @Test
    public void assertOutlets() throws IOException {
        String json = readFile("src/test/resources/test1.json");
        CoffeeMachineHandler.process(json);

        Assert.assertEquals(4, CoffeeMachineHandler.getMachine().getOutlet().getCount());

    }


    private String readFile(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        StringBuilder stringBuilder = new StringBuilder();
        char[] buffer = new char[10];
        while (reader.read(buffer) != -1) {
            stringBuilder.append(new String(buffer));
            buffer = new char[10];
        }
        reader.close();

        return stringBuilder.toString();
    }
}
