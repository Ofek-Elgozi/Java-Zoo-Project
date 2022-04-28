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
 * A class describing a "giraffe" type animal describes the bear's voices and general behavior
 * @version 1.10 3 April 2022
 * @author Ofek Elgozi
 * @see Turtle
 */
public class Giraffe extends ChewingAnimals {

    private static final Herbivore diet = new Herbivore();
    private static final Point starting_location = new Point(50,0);
    private double neckLength;
    private ZooPanel panel;

    public Giraffe(String name,float weight,String color,ZooPanel panel) {
        super(name,starting_location,color,panel);
        super.setWeight(weight);
        super.setDiet(diet);
        this.neckLength = 1.5 ;
        this.loadImages("grf");
        this.panel = panel;
        this.panel.repaint();

    }

    public boolean setNeck(double neck) {
        if(1 <= neck && neck >= 2.5) {
            this.neckLength = neck;
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