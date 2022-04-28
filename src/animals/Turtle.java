package animals;

import diet.Herbivore;
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
    private int Age;
    private static final Point starting_location = new Point(80,0);
    private static final Herbivore diet = new Herbivore();
    private ZooPanel panel;

    public Turtle(String name,float weight,String color,ZooPanel panel) {
        super(name,starting_location,color,panel);
        super.setWeight(weight);
        super.setDiet(diet);
        this.Age = 1;
        this.loadImages("trt");
        this.panel = panel;
        this.panel.repaint();

    }

    public boolean setAge(int Age) {
        if(0 <= Age && Age <= 500) {
            this.Age = Age;
            return true;
        }
        return false;

    }

    @Override
    public EFoodType getFoodtype() {
        return EFoodType.MEAT;
    }

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
}