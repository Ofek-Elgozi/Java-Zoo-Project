package animals;

import food.EFoodType;
import mobility.Point;
import utilities.MessageUtility;

/**
 * A class describing the sounds made by some of the animals in the zoo while eating
 * @version 1.10 2 April 2022
 * @author Elyasaf Sinvani
 * @see ChewingAnimals
 */
public abstract class RoaringAnimal  extends Animal
{
    /**
     * The class constructor, which receives as parameters the name of the animal (type of string) and its position (point type),
     * and initializes to be the name of the object to be the name it received and the position to be the position it received
     * @param name A string-type object that describes the name of the animal
     * @param location A point-type object that describes the position of the animal in space
     */
    public RoaringAnimal(String name, Point location)
    {
        super(name, location);
        MessageUtility.logConstractor(getClass().getSimpleName(), name);
    }

    public abstract void roar();
    /**
     * A method that calls the function of the type of sound that the animal makes
     */
    public void makeSound() {
            roar();
    }
    /**
     * A method that returns the current type of animal as a food (all types of meat animals, except lions)
     * @return A "food" object that is "meat"
     */
    public EFoodType getFoodtype() {
        MessageUtility.logGetter(this.getName(), "getFoodtype", EFoodType.MEAT);
        return EFoodType.MEAT;
    }

}
