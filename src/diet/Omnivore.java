package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;
//Ofek Elgozi 318432085
//Elyasaf Sinvani 318551728
//Campus Ashdod

/**
 * A class that defines animals that eat anything. Implementing the IDiot interface.
 * @version 1.10 28 March 2022
 * @author Ofek Elgozi
 * @
 */
public class Omnivore extends Carnivore implements IDiet
{
    /**
     * A method that accepts a type of food, returns true if it is of the "vegetarian" type or "meat" otherwise returns "false"
     * @param food that describes the type of food (EFoodType)
     * @return returns true if it is of the "vegetarian" type or "meat" otherwise returns "false"
     */
    @Override
    public boolean canEat(EFoodType food)
    {
        boolean isSuccess;
        if(food == EFoodType.MEAT || food == EFoodType.VEGETABLE)
            isSuccess = true;
        else
            isSuccess=false;
        return isSuccess;
    }

    /**
     * A method that accepts as an animal type and food type parameters,
     * if the animal can eat the food the function returns the weight gained by the animal as a result of eating
     * otherwise returns 0
     * @param animal Describing a type of animal
     * @param food that describes the type of food (EFoodType)
     * @return returns the weight gained by the animal as a result of eating
     * otherwise returns 0
     */
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
    /**
     * A method that returns the class type as a string
     * @return returns the class type as a string
     */
    public String toString() {return "[Omnivore]";}
}
