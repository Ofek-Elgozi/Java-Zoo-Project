package animals;

import diet.Carnivore;
import food.EFoodType;
import food.IEdible;
import mobility.Point;
import utilities.MessageUtility;

import java.awt.*;
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

    private static final EFoodType LION = EFoodType.NOTFOOD;
    private static final double STARTING_WEIGHT = 408.2;
    private static final Point STARTING_POSITION = new Point(20,0);
    private static final String roar= "Roars, then stretches and shakes its mane";
    private int scarCount = 0;

    /**
     * The class builder that receives as a string the name of the lion and updates the name of the created object to be the string we received,
     * in addition updates all the other lion fields (weight, position ...)
     * to be the constant values of each new lion object creation
     * @param name A string describing the name of the lion
     */
    public Lion(String name){
        super(name,STARTING_POSITION);
        this.setWeight(STARTING_WEIGHT);
        this.setDiet(new Carnivore());
    }

    /**
     * A method that prints the sound the lion makes while eating
     */
    public void roar(){
        MessageUtility.logSound(this.getName(), roar);
    }

    /**
     * A method that accepts as a parameter a "food" object checks whether the lion was able to eat the food returns "true",
     * and adds a scar to the lion at a 50% chance, if the lion was unable to eat returns "false"
     * @param food A constant that describes the type of food
     * @return If the lion managed to eat, "true" will be returned, otherwise "false" will be returned
     */
    public boolean eat(IEdible food) {
        boolean isSuccess = super.eat(food);
        if (isSuccess){
            this.setScar(1);
        }
        return isSuccess;
    }

    /**
     * A method that receives a number of scars (type integer),
     * and with a 50 percent chance adds to the current lion the number of scars it received as a parameter,
     * if the lion received the scars will be returned "true", otherwise "false" will be returned
     * @param scar An integer describing the number of scars
     * @return If the lion received a scar will be returned "true", otherwise "false" will be returned
     */
    public boolean setScar(int scar){
        boolean isSuccess = false;
        Random random = new Random();
        if ( random.nextInt(2) == 1) {
            scarCount+= scar;
            isSuccess = true;
        }

        MessageUtility.logSetter(this.getName(), "setScar", scar, isSuccess);
        return isSuccess;
    }

    /**
     * A method that returns the current type of lion as a food
     * @return A "food" object that is "NOTFOOD"
     */
    public EFoodType getFoodtype(){
        MessageUtility.logGetter(this.getName(), "getFoodType", LION);
        return LION;
    }

    @Override
    public String getAnimalName() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void eatInc() {

    }

    @Override
    public int getEatCount() {
        return 0;
    }

    @Override
    public boolean getChanges() {
        return false;
    }

    @Override
    public void setChanges(boolean state) {

    }

    @Override
    public void loadImages(String nm) {

    }

    @Override
    public void drawObject(Graphics g) {

    }

    @Override
    public String getColor() {
        return null;
    }
}
