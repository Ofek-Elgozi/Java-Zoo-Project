package animals;

import diet.IDiet;
import graphics.IAnimalBehavior;
import graphics.IDrawable;
import graphics.ZooPanel;
import mobility.Mobile;
import mobility.Point;
import food.IEdible;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
public abstract class Animal extends Mobile implements IEdible,IAnimalBehavior,IDrawable {

    private String name;
    private double weight;
    private IDiet diet;
    private final int EAT_DISTANCE = 10;
    private int size;
    private String col;
    private int horSpeed;
    private int verSpeed;
    private boolean coordChanged;
    private int x_dir = 1;
    private int y_dir = 1;
    private int eatCount;
    private ZooPanel pan;
    private BufferedImage img1, img2;

    /**
     * The class builder who receives as parameters the name of the animal,
     * its location, its color, and the panel in which it exists
     * @param name A string describing the name of the animal
     * @param location A "point" type object that describes the position of the animal
     * @param col A string describing the color of the animal
     * @param zoopanel A zoopanel object that describes the panel in which the animal is present
     */
    public Animal(String name, Point location , String col ,ZooPanel zoopanel)
    {
        super(location);
        this.name = name;
        eatCount = 0 ;
        this.img1 = null;
        this.img2 =null;
        this.pan = zoopanel;
        this.col = col;
    }
    public abstract void makeSound();
    public abstract boolean eat(IEdible food);

    /**
     * A Boolean method that accepts the weight of the animal, if the cursor is greater than zero,
     * changes the weight of the animal to the parameter it received and returns "true", otherwise returns "false"
     * @param weight A double object that describes the weight of the animal
     * @return If the object is greater than 0 returns "true" otherwise returns "false"
     */
    public boolean setWeight(double weight) {
        if (weight > 0) {
            this.weight = weight;
            return true;
        }
        return false;
    }

    /**
     * A method that receives a "diet" object and places it on the current animal and returns "true"
     * @param diet An object that describes the type of food the animal eats
     * @return "true"
     */
    public boolean setDiet(IDiet diet)
    {
        this.diet = diet;
        return true;
    }

    /**
     * A method that returns the name of the animal
     * @return  the name of the animal string object
     */
    public String getName() {
        return this.name;
    }
    /**
     * A method that returns the Weight of the animal
     * @return  the Weight of the animal double object
     */
    public double getWeight() {
        return this.weight;
    }

    /**
     * A method that returns the type of animal as a string
     * @return the type of animal as a string
     */
    public String getAnimalName() {
        return this.getClass().getSimpleName();
    }

    /**
     * A method that returns the size of the animal in integers
     * @return the size of the animal in integers
     */
    public int getSize() {
        return this.size;
    }

    /**
     * A method that increases by 1 the number of eats the animal has performed
     */
    public void eatInc() {
        this.eatCount++;
    }

    /**
     * A method that returns the amount of food the animal has eaten
     * @return the amount of food the animal has eaten int object
     */
    public int getEatCount() {
        return this.eatCount;
    }

    /**
     * A method that returns "true" if the animal moves to some point, otherwise returns "false"
     * @return "true" if the animal moves to some point, otherwise returns "false"
     */
    public boolean getChanges () {
        return this.coordChanged;
    }

    /**
     * A method that receives a Boolean object that describes whether the animal is moving or not,
     * and performs a placement to the Boolean field whether the animal is moving or not
     * @param state a Boolean object that describes whether the animal is moving or not
     */
    public void setChanges (boolean state) {
        this.coordChanged = state;
    }

    /**
     * A method that returns the color of the animal as a string
     * @return the color of the animal as a string
     */
    public String getColor() {
        return this.col;
    }

    /**
     * A method that returns the velocity of the animal on the X-axis
     * @return the velocity of the animal on the X-axis
     */
    public int getHorSpeed() {

        return this.horSpeed;
    }

    /**
     * A method that returns the velocity of the animal on the  Y-axis
     * @return the velocity of the animal on the Y-axis
     */
    public int getVerSpeed() {

        return this.verSpeed;
    }

    /**
     * A method that accepts the number of eats the animal has performed and assigns a field to the number of eatCount eats
     * @param eat The number of eats the animal performed int object
     * @return true
     */
    public boolean setEat(int eat) {
        this.eatCount = eat;
        return true;
    }

    /**
     * A method that accepts the size of the animal as an integer, names the current animal and returns "true"
     * @param size An "integer" object that describes the size of the animal
     * @return true
     */
    public boolean setSize(int size) {
        this.size = size;
        return true;
    }

    /**
     * A method that accepts the speed of the animal on the X-axis, and places it in the "horspeed" field and returns "true"
     * @param hor An "integer" object that describes the speed of the animal on the X-axis
     * @return true
     */
    public boolean setHorSpeed(int hor) {
        this.horSpeed = hor;
        return true;
    }
    /**
     * A method that accepts the speed of the animal on the Y-axis, and places it in the "verspeed" field and returns "true"
     * @param ver An "integer" object that describes the speed of the animal on the Y-axis
     * @return true
     */
    public boolean setVerSpeed(int ver) {
        this.verSpeed = ver;
        return true;
    }

    /**
     * A method that receives the name of the animal as a string and loads the image from the image file according
     * to the name of the animal it received and according to the updated field of the color of the animal,
     * performs the name of the animal image to the left and the animal image to the right
     * @param ani_name A string describing th
     *           e name of the animal in a format written on the image file of that animal
     */
    public void loadImages(String ani_name)
    {
        if(this.col == "Red")
        {

            try
            {
                this.img1 = ImageIO.read(new File(PICTURE_PATH +"\\"+ ani_name + "_r_1.png"));
                this.img2 = ImageIO.read(new File(PICTURE_PATH +"\\"+ ani_name + "_r_2.png"));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        else if(this.col == "Blue")
        {
            try
            {
                this.img1 = ImageIO.read(new File(PICTURE_PATH +"\\"+ ani_name + "_b_1.png"));
                this.img2 = ImageIO.read(new File(PICTURE_PATH +"\\"+ ani_name + "_b_2.png"));
            }
            catch (IOException e)
            {
                e.printStackTrace();

            }
        }
        else
        {
            try
            {
                this.img1 = ImageIO.read(new File(PICTURE_PATH +"\\"+ ani_name + "_n_1.png"));
                this.img2 = ImageIO.read(new File(PICTURE_PATH +"\\"+ ani_name + "_n_2.png"));
            }
            catch (IOException e)
            {
                e.printStackTrace();

            }
        }
    }

    /**
     * A method that returns the animal image of the right side
     * @return the animal image of the right side BufferedImage object
     */
    public BufferedImage getImage1() {
        return this.img1;
    }
    /**
     * A method that returns the animal image of the left side
     * @return the animal image of the right side BufferedImage object
     */
    public BufferedImage getImage2() {
        return this.img2;
    }

    /**
     * A method that returns the X_dir field that describes whether the image should be on the right or left side
     * @return the X_dir field that describes whether the image should be on the right or left side
     */
    public int getX_dir() {
        return this.x_dir;
    }

    /**
     * A method that "draws" on our panel the current animal according to its location and size
     * @param g A graphics object through which the panel is drawn
     */
    public void drawObject (Graphics g)
    {
        int size =this.getSize();
        if(this.getX_dir() == 1)
            g.drawImage(this.getImage1(), this.getLocation().getX()-size/2, this.getLocation().getY()-size/10, size, size, pan);
        else
            g.drawImage(this.getImage2(), this.getLocation().getX(), this.getLocation().getY()-size/10, size, size, pan);
    }

    /**
     * A method that returns the type of "diet" of the animal that describes its behavior regarding food
     * @return the type of "diet" of the animal that describes its behavior regarding food
     */
    public IDiet getDiet() {
        return this.diet;
    }

    /**
     * A method that returns the eating distance
     * (what is the maximum distance from the predator to the prey that the predator can eat)
     * @return the eating distance int object
     */
    public int getEatDistance() {
        return this.EAT_DISTANCE;
    }
}


