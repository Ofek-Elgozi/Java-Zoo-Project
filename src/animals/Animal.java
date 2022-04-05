package animals;

import diet.IDiet;
import food.EFoodType;
import mobility.Mobile;
import mobility.Point;
import food.IEdible;
import utilities.MessageUtility;

//Ofek Elgozi 318432085
//Elyasaf Sinvani 318551728
//Campus Ashdod

/**
 * An abstract class that defines the characteristics common to all animals. The department is expanding
 * Mobile and implements IEdible
 * @version 1.10 1 April 2022
 * @author Elyasaf Sinvani
 * @see zoo.ZooActions
 */
public abstract class Animal extends Mobile implements IEdible {

    private String name;
    private double weight;
    private IDiet diet;

    /**
     *The class constructor that receives as parameters the initial position of the animal (type of point), and the name of the animal (type of string).
     *  Initializes the initial position to be the point it received,
     *  and the name of the animal for the name it received
     * @param name A string describing the name of the animal
     * @param location A point describing the initial position of the animal
     */
    public Animal(String name, Point location){
        super(location);
        MessageUtility.logConstractor("Animal",name);
        this.setName(name);
    }

    public abstract void makeSound();
    public abstract EFoodType getFoodtype();

    /**
     *Boolean method that receives a "food" parameter,
     *  if the current animal can eat the food we received as a parameter,
     *  the method will add to the animal the weight it gained as a result of eating and return "true",
     *  otherwise it will return "false"
     * @param food A constant that describes the type of food
     * @return If the animal can eat the food "true" will be returned otherwise "false" will be returned
     */
    public boolean eat(IEdible food)
    {
        boolean isSuccess = false;
        double weightGain = diet.eat( this, food);
        if(weightGain > 0){
               setWeight(this.getWeight()+weightGain);
               this.makeSound();
                isSuccess = true;
        }
        MessageUtility.logBooleanFunction(this.getName(),"eat",food.toString(),isSuccess);
        System.out.println();
        return isSuccess;
    }

    /**
     * Method that receives a position (point type),
     * if the position is valid (see Mobility Class),
     * the method updates the current position to be the position it received,
     * and subtracts from the animal's current weight the weight lost as a result of reaching the new position,
     * and returns the animal's distance from its current position to the new position.
     * If the position is invalid the animal will remain in the same position and will be returned 0
     * @param nextLocation A dot-type position that describes the new position of the animal
     * @return If the position is valid the distance the animal walked to reach the new position will be returned,
     * otherwise 0 will be returned
     */
    public double move(Point nextLocation)
    {
        double PresentWeight;
        double distance =  super.move(nextLocation);
        if (distance != 0)
        {
            PresentWeight = getWeight();
            this.setWeight(PresentWeight - (distance * PresentWeight * 0.00025));
            MessageUtility.logSetter(this.getName(),"move",nextLocation,true);
        }
        else {
            MessageUtility.logSetter(this.getName(), "move", nextLocation, false);
        }
        return distance;
    }

    /**
     * A Boolean method that gets a parameter (string type), and updates the name of the animal to the string we got if the string is valid (string length is greater than 0),
     * and returns "true", if the string is invalid the method will update the animal name to " Empty name ", and return "false"
     * @param name A string describing the name of the animal
     * @return If the name is correct, "true" will be returned, otherwise "false" will be returned.
     */
    public boolean setName(String name){
        boolean isSuccess = false;
        if(name.length() > 0) {
            this.name = name;
            isSuccess = true;
        }
        else {
            this.name = " Empty name ";
        }
        MessageUtility.logSetter(name,"setName",this.name,isSuccess);
        return isSuccess;
    }

    /**
     * Boolean method that accepts as an animal weight parameter (double type),
     * if the weight is correct (greater than 0) the method will update the animal weight to be the weight it received and return "true",
     * otherwise the method will not update the weight and return "false"
     * @param weight A double object that describes the weight of the animal
     * @return If the weight we received as a correct parameter is returned "true", otherwise "false" will be returned
     */
    public boolean setWeight(double weight){
        boolean isSuccess = false;
        if(weight > 0) {
            this.weight = weight;
            isSuccess = true;
        }
        else {
            this.weight = 0;
        }
        MessageUtility.logSetter(name,"setWeight",weight,isSuccess);
        return isSuccess;
    }

    /**
     * A method that accepts as an parameter an object that realizes the behavior of IDiet,
     * and updates the behavior of the animal to be like the object it received (what it can eat, and whether it is edible)
     * @param diet An object realizes the IDiot and describes the behavior of the animal
     * @return Returns "True"
     */
    public boolean setDiet(IDiet diet) {
        boolean isSuccess = true;
        this.diet = diet;
        MessageUtility.logSetter(this.getName(), "setDiet", this.diet, isSuccess);
        return isSuccess;
    }

    /**
     * A method that returns a string-type object that describes the name of the current animal
     * @return A string describing the name of the current animal
     */
    public String getName(){
        return this.name;
    }

    /**
     * A method that returns a double object that describes the current animal weight
     * @return a double object that describes the current animal weight
     */
    public double getWeight(){
        MessageUtility.logGetter(this.getName(), "getWeight", this.weight);
        return this.weight;
    }

    /**
     * A method that checks the specific type of animal (lion, turtle, bear ...),
     * and returns a string containing the type of animal and its name
     * @return a string containing the type of animal and its name
     */
    public String toString() {

        if(this instanceof Lion)
        {
            return "[Lion] "+this.name;
        }
        if(this instanceof Turtle)
        {
            return "[Turtle] "+this.name;
        }
        if(this instanceof Elephant)
        {
            return "[Elephant] "+this.name;
        }
        if(this instanceof Giraffe)
        {
            return "[Giraffe] "+this.name;
        }
        if(this instanceof Bear)
        {
            return "[Bear] "+this.name;
        }
        else return "Animal";
    }
}


