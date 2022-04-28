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
 * A class describing a "elephant" type animal describes the bear's voices and general behavior
 * @version 1.10 3 April 2022
 * @author Ofek Elgozi
 * @see Bear
 */
public class Elephant extends ChewingAnimals{
    private double trunkLength ;
    private static final Herbivore diet = new Herbivore();
    private static final Point starting_location = new Point(50,90);
    private ZooPanel panel;


    public Elephant(String name,float weight,String color,ZooPanel panel){
        super(name, starting_location,color,panel);
        super.setWeight(weight);
        this.trunkLength = 1;
        this.loadImages("elf");
        this.panel = panel;
        this.panel.repaint();
    }

    @Override
    public EFoodType getFoodtype() {
        return EFoodType.MEAT;
    }

    public void chew() {
    }

    public boolean setTrunk(double trunk) {
        if(0.5 <= trunk && trunk >= 3) {
            this.trunkLength = trunk;
            return true;
        }
        return false;
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
}