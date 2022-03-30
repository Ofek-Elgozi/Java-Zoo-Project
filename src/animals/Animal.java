package animals;


import diet.IDiet;
import food.EFoodType;
import food.IEdible;
import mobility.Point;

import java.util.Objects;

public class Animal implements IEdible
{
    private String name;
    private double weight;
    private IDiet diet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public IDiet getDiet() {
        return diet;
    }

    public void setDiet(IDiet diet) {
        this.diet = diet;
    }


    Animal(String s, Point p) {

    }

    void makeSound() {

    }

    boolean eat(IEdible iedible) {
        return false;
    }

    @Override
    public EFoodType getFoodtype()
    {
        return null;
    }
}
