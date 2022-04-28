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

    public ChewingAnimals(String name, Point location, String color, ZooPanel panel) {
        super(name, location,color,panel);

    }

    public void makeSound() {
        this.chew();
    }

    public abstract void chew();
}
