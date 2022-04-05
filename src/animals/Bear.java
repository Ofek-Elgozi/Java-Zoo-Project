package animals;

import diet.Carnivore;
import diet.Herbivore;
import diet.Omnivore;
import food.EFoodType;
import mobility.Point;
import utilities.MessageUtility;

import java.util.Objects;

//Ofek Elgozi 318432085
//Elyasaf Sinvani 318551728
//Campus Ashdod

/**
 * A class describing a "bear" type animal describes the bear's voices and general behavior
 * @version 1.10 3 April 2022
 * @author Elyasaf Sinvani
 * @see Elephant
 */
public class Bear extends RoaringAnimal {
    private static final EFoodType BEAR = EFoodType.MEAT;
    private static final double STARTING_WEIGHT = 308.2;
    private static final Point STARTING_POSITION = new Point(100, 5);
    private static final String DEFAULT_FURCOLOR = "GRAY";
    private static final String roar = "Stands on its hind legs, roars and scratches its belly";
    private String furColor;

    private enum FurColors
    {
        WHITE("WHITE"),
        GRAY("GRAY"),
        BLACK("BLACK");

        private final String color;

        FurColors(String color) {
            this.color = color;
        }

        public String getFurcolorValue() {
            return this.color;
        }
    }

    /**
     * The class constructor that receives the bear name as a string,
     * and initializes the other fields of the bear (weight, position, color ...)
     * to be the constant values of creating a new "bear" type object
     * @param name A string-type object that describes the bear's name
     */
    public Bear(String name)
    {
        super(name, STARTING_POSITION);
        this.setWeight(STARTING_WEIGHT);
        this.setFurColor(DEFAULT_FURCOLOR);
        this.setDiet(new Omnivore());
    }

    /**
     * Another constructor for the class that receives as the string the name of the bear and another string that
     * describes the color of the bear (unlike the previous constructor that has a default value),
     * and all other fields of the bear initialize to be the permanent fields of creating a "bear" object
     * @param name A string describing the bear's name
     * @param furColor A string depicting the color of the bear
     */
    public Bear(String name, String furColor)
    {
        super(name, STARTING_POSITION);
        this.setWeight(STARTING_WEIGHT);
        this.setFurColor(furColor);
        this.setDiet(new Omnivore());
    }

    /**
     *A Boolean method that receives a string describing a color name,
     *  checks if the name of the color we got exists in one of the bear's color options, then returns "true", otherwise "false"
     * @param furColor A string depicting some color
     * @return If the color we received exists in one of the bear color options, "true" will be returned,
     * otherwise "false" will be returned
     */
    public boolean validFurColor(String furColor)
    {
        boolean isSuccess = false;
        for (FurColors color : FurColors.values())
        {
            if (color.getFurcolorValue().equals(furColor))
            {
                isSuccess = true;
            }
        }
        MessageUtility.logBooleanFunction(this.getName(),"validFurColor",furColor,isSuccess);
        return isSuccess;
    }

    /**
     * A method that prints the sound the bear makes while eating
     */
    public void roar()
    {
        MessageUtility.logSound(this.getName(), roar);
    }

    /**
     * A method that receives a color name (string type) as a parameter,
     * checks if the color is valid (exists in one of the colors the bear can be),
     * then changes the color of the bear to the color it received and returns "true",
     * otherwise the bear's color changes to the default color ("gray") And a "lie" will be returned
     * @param furColor A string depicting some color
     * @return If the valid color is returned "true" otherwise "false" will be returned
     */
    public boolean setFurColor(String furColor)
    {
        boolean isSuccess = false;
        if(validFurColor(furColor))
        {
            this.furColor = furColor;
            isSuccess = true;
        }
        else
        {
            this.furColor = DEFAULT_FURCOLOR;
        }
        MessageUtility.logSetter(this.getName(),"setFurColor",furColor,isSuccess);
        return isSuccess;
    }


}