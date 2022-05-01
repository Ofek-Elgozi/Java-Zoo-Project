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

    public IDiet getDiet() {

        return this.diet;

    }
}