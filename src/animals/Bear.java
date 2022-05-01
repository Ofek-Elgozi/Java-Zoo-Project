package animals;

import diet.IDiet;
import diet.Omnivore;
import food.EFoodType;
import food.IEdible;
import graphics.ZooPanel;
import mobility.Point;

//Ofek Elgozi 318432085
//Elyasaf Sinvani 318551728
//Campus Ashdod

/**
 * A class describing a "bear" type animal describes the bear's voices and general behavior
 * @version 1.10 3 April 2022
 * @author Elyasaf Sinvani
 * @see Elephant
 */
public class Bear extends RoaringAnimal {
    private static final Point starting_location = new Point(100,5);
    private static final Omnivore diet = new Omnivore();
    private ZooPanel panel;

    /**
     * The class builder who receives the bear details and initializes the fields
     * @param name A string describing the bear's name
     * @param weight An actual number describing the weight of the bear
     * @param color A string depicting the color of the bear
     * @param panel A "ZooPanel" object that the bear will hold in that object
     */
    public Bear(String name,float weight,String color,ZooPanel panel) {
        super(name,starting_location,color, panel);
        super.setWeight(weight);
        this.loadImages("bea");
        this.panel = panel;
        this.panel.repaint();
    }

    public void roar() {
    }

    @Override
    /**
     *A method that returns what kind of food the bear is
     */
    public EFoodType getFoodtype() {
        return EFoodType.MEAT;
    }

    /**
     *A Boolean method that accepts as a parameter a type of food,
     *  if the bear managed to eat increases the weight of the bear and returns "true",
     *  otherwise does not increase the weight of the bear, and returns "false"
     * @param food A "food" object that describes the food the bear is trying to eat
     * @return If the bear managed to eat the food, "true" will be returned, otherwise "false" will be returned
     */
    @Override
    public boolean eat(IEdible food) {
        double W = diet.eat(this, food);
        if(W > 0) {
            super.setWeight(super.getWeight()+W);
            super.makeSound();
            return true;
        }
        return false;
    }

    /**
     * A method that returns a "diet" object that describes what the bear can eat
     * @return a "diet" object that describes what the bear can eat (Omnivore)
     */
    public IDiet getDiet() {

        return diet;

    }
}