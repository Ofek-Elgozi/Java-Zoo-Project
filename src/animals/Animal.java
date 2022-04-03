package animals;

import diet.IDiet;
import food.EFoodType;
import mobility.Mobile;
import mobility.Point;
import food.IEdible;
import utilities.MessageUtility;

public abstract class Animal extends Mobile implements IEdible {

    private String name;
    private double weight;
    private IDiet diet;

    public Animal(String name, Point location){
        super(location);
        MessageUtility.logConstractor("Animal",name);
        this.setName(name);
    }


    public abstract void makeSound();
    public abstract EFoodType getFoodtype();


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

    public double move(Point nextLocation)
    {
        double distance =  super.move(nextLocation);
        if (distance != 0) {
            this.setWeight(getWeight() - (distance * getWeight() * 0.00025));
            MessageUtility.logSetter(this.getName(),"move",nextLocation,true);
        }
        else {
            MessageUtility.logSetter(this.getName(), "move", nextLocation, false);
        }
        return distance;
    }

    //setters
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
    public boolean setDiet(IDiet diet) {
        boolean isSuccess = true;
        this.diet = diet;
        MessageUtility.logSetter(this.getName(), "setDiet", this.diet, isSuccess);
        return isSuccess;
    }
    //getters
    public String getName(){
        return this.name;
    }

    public double getWeight(){
        MessageUtility.logGetter(this.getName(), "getWeight", this.weight);
        return this.weight;
    }

    public String toString() {

        if(this instanceof Lion)
        {
            return "[Lion]"+this.name;
        }
        if(this instanceof Turtle)
        {
            return "[Turtle]"+this.name;
        }
        if(this instanceof Elephant)
        {
            return "[Elephant]"+this.name;
        }
        if(this instanceof Giraffe)
        {
            return "[Giraffe]"+this.name;
        }
        if(this instanceof Bear)
        {
            return "[Bear]"+this.name;
        }
        else return "Animal";
    }
}