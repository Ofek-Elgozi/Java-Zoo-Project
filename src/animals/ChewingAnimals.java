package animals;

import graphics.ZooPanel;
import mobility.Point;
//Ofek Elgozi 318432085
//Elyasaf Sinvani 318551728
//Campus Ashdod

/**
 * A class describing the sounds made by some of the animals in the zoo while eating
 * @version 1.10 2 April 2022
 * @author Ofek Elgozi
 * @see RoaringAnimal
 */
public abstract class ChewingAnimals extends Animal
{
    /**
     * The class builder who receives as parameters the name of the ChewingAnimals,
     * its location, its color, and the panel in which it exists
     * @param name A string describing the name of the animal
     * @param location A "dot" type object that describes the position of the animal
     * @param color A string describing the color of the animal
     * @param panel A zoopanel object that describes the panel in which the animal is present
     */
    public ChewingAnimals(String name, Point location, String color, ZooPanel panel) {
        super(name, location,color,panel);

    }

    /**
     * A method that performs chewing of the animal while eating
     */
    public void makeSound() {
        this.chew();
    }

    public abstract void chew();
}
