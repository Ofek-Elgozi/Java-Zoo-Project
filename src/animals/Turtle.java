package animals;

import diet.Herbivore;
import food.EFoodType;
import mobility.Point;
import utilities.MessageUtility;

import java.awt.*;
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
    private static final double STARTING_WEIGHT = 1;
    private static final Point STARTING_POSITION = new Point(80,0);
    private static final int MIN_AGE = 0;
    private static final int MAX_AGE = 500;
    private static final int DEFAULT_AGE = 1;
    private static final String chew = "Retracts its head in then eats quietly";

    private int age;

    /**
     * The weight builder that receives the turtle name (string type) as a parameter,
     * updates the turtle name to be the parameter we received, updates the turtle age to be the default value (one year old),
     * and updates all other parameters according to the constants of creating a new turtle object
     * @param name A string describing the name of the turtle
     */
    public Turtle(String name)
    {
        super(name, STARTING_POSITION);
        this.setWeight(STARTING_WEIGHT);
        this.setAge(DEFAULT_AGE);
        this.setDiet(new Herbivore());
    }

    /**
     *Another class builder that gets the turtle name as a string and the age of the turtle as an integer,
     *  updates the turtle name and age to the values it received in parameters,
     *  and updates the rest of the fields according to the fixed values of each turtle object creation
     * @param name A string describing the name of the turtle
     * @param age A integer describing the age of the turtle
     */
    public Turtle(String name,int age)
    {
        super(name, STARTING_POSITION);
        this.setWeight(STARTING_WEIGHT);
        this.setAge(age);
        this.setDiet(new Herbivore());
    }
    /**
     * A method that prints the sound the turtle makes while eating
     */
    public void chew(){
        MessageUtility.logSound(this.getName(),chew);
    }

    /**
     * A Boolean method that accepts the turtle as an integer checks if it is valid (between 0 and 500)
     * then updates the current turtle age to the age it received as a parameter and returns "true",
     * otherwise returns "false" and does not change the current turtle age
     * @param age A integer describing the age of the turtle
     * @return If the age is valid (between 0 and 500) "true" will be returned, otherwise "false" will be returned
     */
    public boolean setAge(int age)
    {
        boolean isSuccess = false;
        if(age >= MIN_AGE && age <= MAX_AGE){
            this.age = age;
            isSuccess = true;
        }
        MessageUtility.logSetter(this.getName(),"setAge",age,isSuccess);
        return isSuccess;

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