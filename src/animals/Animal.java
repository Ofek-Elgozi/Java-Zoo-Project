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
    public boolean setWeight(double weight) {
        if (weight > 0) {
            this.weight = weight;
            return true;
        }
        return false;
    }

    public boolean setDiet(IDiet diet)
    {
        this.diet = diet;
        return true;
    }

    public String getName() {
        return this.name;
    }

    public double getWeight() {
        return this.weight;
    }

    public String getAnimalName() {
        return this.getClass().getSimpleName();
    }
    public int getSize() {
        return this.size;
    }
    public void eatInc() {
        this.eatCount++;
    }
    public int getEatCount() {
        return this.eatCount;
    }

    public boolean getChanges () {
        return this.coordChanged;
    }

    public void setChanges (boolean state) {
        this.coordChanged = state;
    }

    public String getColor() {
        return this.col;
    }

    public int getHorSpeed() {

        return this.horSpeed;
    }

    public int getVerSpeed() {

        return this.verSpeed;
    }

    public boolean setEat(int eat) {
        this.eatCount = eat;
        return true;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean setHorSpeed(int hor) {
        this.horSpeed = hor;
        return true;
    }

    public boolean setVerSpeed(int hor) {
        this.verSpeed = hor;
        return true;
    }
    public void loadImages(String nm)

    {
        if(this.col == "Red")
        {
            try
            {
                this.img1 = ImageIO.read(new File(PICTURE_PATH +"\\"+ nm + "_r_1.png"));
                this.img2 = ImageIO.read(new File(PICTURE_PATH +"\\"+ nm + "_r_2.png"));
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
                this.img1 = ImageIO.read(new File(PICTURE_PATH +"\\"+ nm + "_b_1.png"));
                this.img2 = ImageIO.read(new File(PICTURE_PATH +"\\"+ nm + "_b_2.png"));
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
                this.img1 = ImageIO.read(new File(PICTURE_PATH +"\\"+ nm + "_n_1.png"));
                this.img2 = ImageIO.read(new File(PICTURE_PATH +"\\"+ nm + "_n_2.png"));
            }
            catch (IOException e)
            {
                e.printStackTrace();

            }
        }
    }

    public BufferedImage getImage1() {
        return this.img1;
    }

    public BufferedImage getImage2() {
        return this.img2;
    }

    public int getX_dir() {
        return this.x_dir;
    }

    public void drawObject (Graphics g)
    {
        int size =this.getSize();
        if(this.getX_dir() == 1)
            g.drawImage(this.getImage1(), this.getLocation().getX()-size/2, this.getLocation().getY()-size/10, size, size, pan);
        else
            g.drawImage(this.getImage2(), this.getLocation().getX(), this.getLocation().getY()-size/10, size, size, pan);
    }

    public IDiet getDiet() {
        return this.diet;
    }

    public int getEatDistance() {
        return this.EAT_DISTANCE;
    }
}


