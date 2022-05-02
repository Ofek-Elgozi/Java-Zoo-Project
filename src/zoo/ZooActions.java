package zoo;

import animals.*;
import food.IEdible;
import mobility.Point;
import plants.Plant;

import java.util.Random;
import java.util.Scanner;
//Ofek Elgozi 318432085
//Elyasaf Sinvani 318551728
//Campus Ashdod

/**
 * A department that implements all the actions in the zoo, including a main executable file (main)
 * @version 1.10 3 April 2022
 * @author Ofek Elgozi
 * @see Animal
 */

public class ZooActions
{
    /**
     * A method that checks the type of object we received if it is an animal type does dawncusting from an object to an animal,
     * and activates whether the "eat" function of the specific animal,
     * if the animal was able to eat returns "true" if not returns "false"
     * @param animal Describing a type of animal
     * @param food that describes the type of food (EFoodType)
     * @return if the animal was able to eat returns "true" if not returns "false"
     */

    public static boolean eat(Object animal, IEdible food) {

        if(animal instanceof Lion)
        {
            if(((Lion) animal).eat(food))
            {
                return true;
            }
            else return false;
        }
        if(animal instanceof Bear)
        {
            if(((Bear) animal).eat(food))
            {
                if(food instanceof Animal) {
                    return true;
                }
                else return false;
            }
            if(food instanceof Plant) {
                return true;
            }
            else return false;

        }

        if(animal instanceof Elephant)
        {
            if(((Elephant) animal).eat(food))
            {
                return true;
            }
            else return false;
        }
        if(animal instanceof Giraffe)
        {
            if(((Giraffe) animal).eat(food))
            {
                return true;
            }
            else return false;
        }
        if(animal instanceof Turtle)
        {
            if(((Turtle) animal).eat(food))
            {
                return true;
            }
            else return false;
        }
        return false;
    }

    /**
     * a static method that gets an animal and a point checks if the point is between bounds
     * if the animal is a known animal and moves the animal
     * @param animal
     *            - an animal object
     * @param point
     *            - a point object
     * @return boolean
     *            - true if the animal moved successfully, otherwise false
     */

    public static boolean  move(Object animal, Point point){

        double distance = 0;
        double weight = 0;
        if(animal instanceof Lion)
        {
            distance = ((Lion) animal).move(point);
            double animal_weight = ((Lion) animal).getWeight();
            weight = animal_weight - (distance*animal_weight*0.00025);
            ((Lion) animal).setLocation(point);
            ((Lion)animal).setChanges(true);
            return ((Lion) animal).setWeight(weight);
        }
        if(animal instanceof Bear)
        {
            distance = ((Bear) animal).move(point);
            double animal_weight = ((Bear) animal).getWeight();
            weight = animal_weight - (distance*animal_weight*0.00025);
            ((Bear) animal).setLocation(point);
            ((Bear)animal).setChanges(true);
            return ((Bear) animal).setWeight(weight);
        }
        if(animal instanceof Elephant)
        {
            distance = ((Elephant) animal).move(point);
            double animal_weight = ((Elephant) animal).getWeight();
            weight = animal_weight - (distance*animal_weight*0.00025);
            ((Elephant) animal).setLocation(point);
            ((Elephant)animal).setChanges(true);
            return ((Elephant) animal).setWeight(weight);
        }
        if(animal instanceof Giraffe)
        {
            distance = ((Giraffe) animal).move(point);
            double animal_weight = ((Giraffe) animal).getWeight();
            weight = animal_weight - (distance*animal_weight*0.00025);
            ((Giraffe) animal).setLocation(point);
            ((Giraffe)animal).setChanges(true);
            return ((Giraffe) animal).setWeight(weight);
        }
        if(animal instanceof Turtle)
        {
            distance = ((Turtle) animal).move(point);
            double animal_weight = ((Turtle) animal).getWeight();
            weight = animal_weight - (distance*animal_weight*0.00025);
            ((Turtle) animal).setLocation(point);
            ((Turtle)animal).setChanges(true);
            return ((Turtle) animal).setWeight(weight);
        }
        return false;
    }

}
