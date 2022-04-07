package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;
//Ofek Elgozi 318432085
//Elyasaf Sinvani 318551728
//Campus Ashdod

/**
 * Interface describing eating functionality
 * @version 1.10 28 March 2022
 * @author Elyasaf sinvani
 * @see IEdible
 */

public interface IDiet
{
    boolean canEat(EFoodType food);
    double eat(Animal animal, IEdible food);
}
