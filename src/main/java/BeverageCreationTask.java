import exceptions.IngredientNotfoundException;
import exceptions.IngredientQuantityLowException;
import model.Beverage;

public class BeverageCreationTask implements Runnable {
    Beverage beverage;

    public BeverageCreationTask(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public void run() {
        try {
            IngredientsManager.getInstance().checkAndUpdateIngredients(beverage);
//            Thread.sleep(10000);                   //Mimicking preparation time whichis same for all the beverages
            System.out.println("Beverage " + beverage.getName() + " is prepeared");
        } catch (IngredientNotfoundException e) {
            System.out.println(e.getMessage());
        } catch (IngredientQuantityLowException e) {
            System.out.println(e.getMessage());
        }  catch (Exception e){
            e.printStackTrace();
        }
    }
}
