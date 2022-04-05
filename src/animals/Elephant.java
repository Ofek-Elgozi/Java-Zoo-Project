package animals;

import diet.Herbivore;
import mobility.Point;
import utilities.MessageUtility;
//Ofek Elgozi 318432085
//Elyasaf Sinvani 318551728
//Campus Ashdod

/**
 * A class describing a "elephant" type animal describes the bear's voices and general behavior
 * @version 1.10 3 April 2022
 * @author Ofek Elgozi
 * @see Bear
 */
public class Elephant extends ChewingAnimals {


    private static final double STARTING_WEIGHT = 500;
    private static final Point STARTING_POSITION = new Point(50,90);
    private static final double MIN_TRUNK_LENGTH = 0.5;
    private static final double MAX_TRUNK_LENGTH = 3;
    private static final double DEFAULT_TRUNK_LENGTH = 1;
    private static final String chew = "Trumpets with joy while flapping its ears, then chews";
    private double TrunkLength;

    /**
     * The class builder that receives as a parameter a string that describes the name of the elephant,
     * and updates the name of the elephant to be the string it received,
     * updates the length of the trunk to be the value by default (length 1),
     * and updates all other elephant fields according to each elephant object object
     * @param name A string describing the name of the elephant
     */
    public Elephant(String name)
    {
        super(name,STARTING_POSITION);
        this.setWeight(STARTING_WEIGHT);
        this.setTrunkLength(DEFAULT_TRUNK_LENGTH);
        this.setDiet(new Herbivore());
    }

    /**
     * Another builder for the class that receives as parameters the name of the elephant (string type) and the length of the elephant trunk (double type),
     * updates the name of the elephant to be the name it received and the length of the trunk length if the trunk length is valid (between 0.5 and 3),
     * and all other elephant fields to be values The constant initials of creating a new elephant-type object
     * @param name A string describing the name of the elephant
     * @param TrunkLength A double object that describes the length of the elephant's trunk
     */
    public Elephant(String name,double TrunkLength)
    {
        super(name,STARTING_POSITION);
        this.setWeight(STARTING_WEIGHT);
        this.setTrunkLength(TrunkLength);
        this.setDiet(new Herbivore());
    }
    /**
     * A method that prints the sound the elephant makes while eating
     */
    public void chew(){
        MessageUtility.logSound(this.getName(),chew);
    }

    /**
     * A Boolean method that accepts as a parameter the length of the elephant's trunk (double type),
     * if the length of the trunk is valid (between 0.5 and 3) updates the length of the current elephant's trunk to
     * the length it received as a parameter, returns "true",
     * otherwise does not change current elephant's trunk length and returns "false"
     * @param TrunkLength A double object that describes the length of the elephant's trunk
     * @return If the length of the trunk received as a valid parameter (between 0.5 and 3),
     * "true" will be returned otherwise "false" will be returned
     */
    public boolean setTrunkLength(double TrunkLength){
        boolean isSuccess = false;
        if(TrunkLength > MIN_TRUNK_LENGTH && TrunkLength < MAX_TRUNK_LENGTH){
            this.TrunkLength = TrunkLength;
            isSuccess = true;
        }
        MessageUtility.logSetter(this.getName(),"setTrunkLength",TrunkLength,isSuccess);
        return isSuccess;
    }
}