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
    private int scarCount ;
    private ZooPanel panel;

    public Lion(String name,float weight , String color,ZooPanel panel) {
        super(name,starting_location,color,panel);
        super.setWeight(weight);
        super.setDiet(diet);
        this.scarCount = 0;
        String img1 = null;
        this.loadImages("lio");
        this.panel = panel;
        this.panel.repaint();

    }

    public void roar() {

    }

    public boolean eat(IEdible food) {
        double W = diet.eat(this, food);
        if(W > 0) {
            super.setWeight(super.getWeight()+W);
            boolean val = new Random().nextInt(50)==0;
            if (val)
                this.scarCount += 1;
            super.makeSound();
            return true;
        }
        return false;
    }

    @Override
    public EFoodType getFoodtype() {
        return EFoodType.NOTFOOD;
    }

    public IDiet getDiet() {

        return this.diet;
    }
}
