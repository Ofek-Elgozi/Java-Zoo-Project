package animals;


import diet.Herbivore;
import mobility.Point;
import utilities.MessageUtility;
/**
 * A class describing a "giraffe" type animal describes the bear's voices and general behavior
 * @version 1.10 3 April 2022
 * @author Ofek Elgozi
 * @see Turtle
 */
public class Giraffe extends ChewingAnimals {

    private static final double STARTING_WEIGHT = 450;
    private static final Point STARTING_POSITION = new Point(50,0);
    private static final double MIN_NECK_LENGTH = 1;
    private static final double MAX_NECK_LENGTH = 2.5;
    private static final double DEFAULT_NECK_LENGTH = 1.5;
    private static final String chew ="Bleats and Stomps its legs, then chews";
    private double neckLength;

    /**
     * A class builder that receives as a parameter the giraffe name (string type)
     * and updates the new giraffe object to the name it received as a parameter,
     * the giraffe neck length is updated to be the default value (1.5) and all other fields are
     * initialized to the initial set values of each giraffe object creation
     * @param name A string-type object that describes the name of the giraffe
     */
    public Giraffe(String name){
        super(name,STARTING_POSITION);
        this.setWeight(STARTING_WEIGHT);
        this.setNeckLength(DEFAULT_NECK_LENGTH);
        this.setDiet(new Herbivore());
    }

    /**
     * Another class builder, which receives as parameters the giraffe name (string type) and giraffe neck length (double type),
     * updates the giraffe name to be the value it received as a parameter,
     * checks if the length value of the neck is valid (between 1 and 2.5),
     * updates the The neck length of the giraffe should be the value it received as a parameter
     * @param name A string-type object that describes the name of the giraffe
     * @param neckLength A double object depicting the length of the giraffe's neck
     */
    public Giraffe(String name, double neckLength){
        super(name,STARTING_POSITION);
        this.setWeight(STARTING_WEIGHT);
        this.setNeckLength(neckLength);
        this.setDiet(new Herbivore());
    }
    /**
     * A method that prints the sound the giraffe makes while eating
     */
    public void chew(){
        MessageUtility.logSound(this.getName(),chew );
    }

    /**
     * A Boolean method that takes as a parameter the giraffe neck length (double type),
     * if the length is valid (between 1 and 2.5) updates the current giraffe neck field to the value we got as a parameter and returns "true",
     * otherwise the giraffe neck field does not change, and the method returns "false"
     * @param neckLength A double object depicting the length of the giraffe's neck
     * @return If the parameter value (describing the girth's neck length) is valid (between 1 and 2.5) "true" will be returned
     * otherwise "false" will be returned
     */
    public boolean setNeckLength(double neckLength){
        boolean isSuccess = false;
        if(neckLength > MIN_NECK_LENGTH && neckLength < MAX_NECK_LENGTH){
            this.neckLength = neckLength;
            isSuccess = true;
        }
        MessageUtility.logSetter(this.getName(),"setNeckLength",neckLength,isSuccess);
        return isSuccess;
    }
}