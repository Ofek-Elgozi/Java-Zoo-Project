package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;
import utilities.MessageUtility;

public class Herbivore implements IDiet
{
    @Override
    public boolean canEat(EFoodType food)
    {
        boolean isSuccess;
        if(food == EFoodType.VEGETABLE)
            isSuccess = true;
        else
            isSuccess=false;
        MessageUtility.logBooleanFunction("Herbivore","canEat",food,isSuccess);
        return isSuccess;
    }

    @Override
    public double eat(Animal animal, IEdible food)
    {
        if(canEat(food.getFoodtype()) && !(animal == food))
        {
            return (animal.getWeight()*0.07);
        }
        return 0;
    }

    public String toString() {return "[Herbivore]";}
}
