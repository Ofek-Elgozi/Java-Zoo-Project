package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;
import utilities.MessageUtility;

public class Omnivore extends Carnivore implements IDiet
{
    @Override
    public boolean canEat(EFoodType food)
    {
        boolean isSuccess;
        if(food == EFoodType.MEAT || food == EFoodType.VEGETABLE)
            isSuccess = true;
        else
            isSuccess=false;
        MessageUtility.logBooleanFunction("Omnivore","canEat",food,isSuccess);
        return isSuccess;
    }

    @Override
    public double eat(Animal animal, IEdible food)
    {
        EFoodType Temp_Food = food.getFoodtype();
        if(canEat(Temp_Food) == true && Temp_Food == EFoodType.MEAT && !(animal == food))
        {
            return super.eat(animal, food);
        }
        else if(canEat(Temp_Food) == true && Temp_Food == EFoodType.VEGETABLE && !(animal == food))
        {
            return (animal.getWeight()*0.07);
        }
        return 0;
    }

    public String toString() {return "[Omnivore]";}
}
