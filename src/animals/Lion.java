package animals;

import diet.Carnivore;
import diet.IDiet;
import food.EFoodType;
import food.IEdible;
import graphics.ZooPanel;
import mobility.Point;

import java.util.Random;
//Ofek Elgozi 318432085
//Elyasaf Sinvani 318551728
//Campus Ashdod

/**
 * A class describing a "lion" type animal describes the bear's voices and general behavior
 * @version 1.10 3 April 2022
 * @author Ofek Elgozi
 * @see Bear
 */
public class Lion extends RoaringAnimal {

    private static final Point starting_location = new Point(20,0);
    private static final Carnivore diet = new Carnivore();
    private ZooPanel panel;
    /**
     * The class builder who receives the Lion details and initializes the fields
     * @param name A string describing the Lion's name
     * @param weight An actual number describing the weight of the Lion
     * @param color A string depicting the color of the Lion
     * @param panel A "ZooPanel" object that the Lion will hold in that object
     */
    public Lion(String name,float weight , String color,ZooPanel panel) {
        super(name,starting_location,color,panel);
        super.setWeight(weight);
        super.setDiet(diet);
        this.loadImages("lio");
        this.panel = panel;
        this.panel.repaint();

    }

    public void roar() {

    }
    /**
     *A Boolean method that accepts as a parameter a type of food,
     *  if the Lion managed to eat increases the weight of the Lion and returns "true",
     *  otherwise does not increase the weight of the Lion, and returns "false"
     * @param food A "food" object that describes the food the Lion is trying to eat
     * @return If the Lion managed to eat the food, "true" will be returned, otherwise "false" will be returned
     */
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
     *A method that returns what kind of food the Lion is
     */
    @Override
    public EFoodType getFoodtype() {
        return EFoodType.NOTFOOD;
    }
    /**
     * A method that returns a "diet" object that describes what the Lion can eat
     * @return a "diet" object that describes what the Lion can eat (Carnivore)
     */
    public IDiet getDiet() {

        return diet;
    }
}
