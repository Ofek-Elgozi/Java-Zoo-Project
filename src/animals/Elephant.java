package animals;

import diet.Herbivore;
import diet.IDiet;
import food.EFoodType;
import food.IEdible;
import graphics.ZooPanel;
import mobility.Point;
//Ofek Elgozi 318432085
//Elyasaf Sinvani 318551728
//Campus Ashdod

/**
 * A class describing a "elephant" type animal describes the elephant's voices and general behavior
 * @version 1.10 3 April 2022
 * @author Ofek Elgozi
 * @see Bear
 */
public class Elephant extends ChewingAnimals{
    private static final Herbivore diet = new Herbivore();
    private static final Point starting_location = new Point(50,90);
    private ZooPanel panel;

    /**
     * The class builder who receives the Elephant details and initializes the fields
     * @param name A string describing the Elephant's name
     * @param weight An actual number describing the weight of the Elephant
     * @param color A string depicting the color of the Elephant
     * @param panel A "ZooPanel" object that the Elephant will hold in that object
     */
    public Elephant(String name,float weight,String color,ZooPanel panel){
        super(name, starting_location,color,panel);
        super.setWeight(weight);
        super.setDiet(diet);
        this.loadImages("elf");
        this.panel = panel;
        this.panel.repaint();
    }
    /**
     *A method that returns what kind of food the Elephant is
     */
    @Override
    public EFoodType getFoodtype() {
        return EFoodType.MEAT;
    }

    public void chew() {
    }
    /**
     *A Boolean method that accepts as a parameter a type of food,
     *  if the Elephant managed to eat increases the weight of the Elephant and returns "true",
     *  otherwise does not increase the weight of the Elephant, and returns "false"
     * @param food A "food" object that describes the food the Elephant is trying to eat
     * @return If the Elephant managed to eat the food, "true" will be returned, otherwise "false" will be returned
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
     * A method that returns a "diet" object that describes what the Elephant can eat
     * @return a "diet" object that describes what the Elephant can eat (Herbivore)
     */
    public IDiet getDiet() {

        return diet;

    }
}