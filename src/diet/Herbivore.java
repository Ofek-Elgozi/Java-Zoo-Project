package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;
import utilities.MessageUtility;

/**
 * A class that defines animals that eat vegetarian. Implementing the IDiot interface.
 * @version 1.10 28 March 2022
 * @author Elyasaf Sinvani
 * @see Carnivore
 */

public class Herbivore implements IDiet
{
    /**
     * A method that accepts a type of food, returns true if it is of the "vegetarian" type otherwise returns "false"
     * @param food that describes the type of food (EFoodType)
     * @return If the type of food is meat will be returned "true", otherwise "false"
     */
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

    /**
     * A method that accepts as an animal type and food type parameters,
     * if the animal can eat the food the function returns the weight gained by the animal as a result of eating
     * otherwise returns 0
     * @param animal Describing a type of animal
     * @param food that describes the type of food (EFoodType)
     * @return Returns the weight that the animal we received as parameter 1 gained as a result of eating the food we received as parameter 2 if the animal was able to eat the food, otherwise returns 0
     */
    @Override
    public double eat(Animal animal, IEdible food)
    {
        if(canEat(food.getFoodtype()) && !(animal == food))
        {
            return (animal.getWeight()*0.07);
        }
        return 0;
    }

    /**
     * A method that returns the class type as a string
     * @return returns the class type as a string
     */
    public String toString() {return "[Herbivore]";}
}
