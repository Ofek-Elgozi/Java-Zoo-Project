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
 * A class describing a "turtle" type animal describes the bear's voices and general behavior
 * @version 1.10 3 April 2022
 * @author Elyasaf Sinvani
 * @see Giraffe
 */
public class Turtle extends ChewingAnimals
{
    private static final Point starting_location = new Point(80,0);
    private static final Herbivore diet = new Herbivore();
    private ZooPanel panel;
    /**
     * The class builder who receives the Turtle details and initializes the fields
     * @param name A string describing the Turtle's name
     * @param weight An actual number describing the weight of the Turtle
     * @param color A string depicting the color of the Turtle
     * @param panel A "ZooPanel" object that the Turtle will hold in that object
     */
    public Turtle(String name,float weight,String color,ZooPanel panel) {
        super(name,starting_location,color,panel);
        super.setWeight(weight);
        super.setDiet(diet);
        this.loadImages("trt");
        this.panel = panel;
        this.panel.repaint();

    }

    /**
     *A method that returns what kind of food the Turtle is
     */
    @Override
    public EFoodType getFoodtype() {
        return EFoodType.MEAT;
    }
    /**
     *A Boolean method that accepts as a parameter a type of food,
     *  if the Turtle managed to eat increases the weight of the Turtle and returns "true",
     *  otherwise does not increase the weight of the Turtle, and returns "false"
     * @param food A "food" object that describes the food the Turtle is trying to eat
     * @return If the Turtle managed to eat the food, "true" will be returned, otherwise "false" will be returned
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

    @Override
    public void chew() {

    }
    /**
     * A method that returns a "diet" object that describes what the Turtle can eat
     * @return a "diet" object that describes what the Turtle can eat (Herbivore)
     */
    public IDiet getDiet() {

        return diet;

    }
}