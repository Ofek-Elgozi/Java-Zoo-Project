package animals;

import graphics.ZooPanel;
import mobility.Point;
//Ofek Elgozi 318432085
//Elyasaf Sinvani 318551728
//Campus Ashdod
/**
 * A class describing the sounds made by some of the animals in the zoo while eating
 * @version 1.10 2 April 2022
 * @author Elyasaf Sinvani
 * @see ChewingAnimals
 */
public abstract class RoaringAnimal  extends Animal
{
    /**
     * The class builder who receives as parameters the name of the RoaringAnimal,
     * its location, its color, and the panel in which it exists
     * @param name A string describing the name of the animal
     * @param location A "point" type object that describes the position of the animal
     * @param color A string describing the color of the animal
     * @param panel A zoopanel object that describes the panel in which the animal is present
     */
    public RoaringAnimal(String name, Point location, String color, ZooPanel panel) {
        super(name, location,color,panel);
    }
    /**
     * A method that performs a roar while eating
     */
    public void makeSound() {
        this.roar();
    }

    public abstract void roar();
}
