package plants;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import food.IEdible;
import food.EFoodType;
import graphics.IDrawable;
import graphics.ZooPanel;
import mobility.ILocatable;
import mobility.Point;

import javax.imageio.ImageIO;


public abstract class Plant implements IEdible, ILocatable, IDrawable {

	private double height;
	private Point location;
	private double weight;
	private ZooPanel zoopanel;
	private BufferedImage plant_image = null;

	public Plant(ZooPanel zoopanel) {
		Random rand = new Random();
		int x = rand.nextInt(30);
		int y = rand.nextInt(12);
		this.location = new Point(x, y);
		this.height = rand.nextInt(30);
		this.weight = rand.nextInt(12);
		this.zoopanel = zoopanel;
	}

	@Override
	public EFoodType getFoodtype() {
		return EFoodType.VEGETABLE;
	}

	public double getHeight() {
		return this.height;
	}

	@Override
	public Point getLocation() {
		return this.location;
	}

	public double getWeight() {
		return weight;
	}

	public boolean setHeight(double height) {

		boolean isSuccess = (height >= 0);
		if (isSuccess) {
			this.height = height;
		} else {
			this.height = 0;
		}
		return isSuccess;
	}

	@Override
	public boolean setLocation(Point newLocation) {
		boolean isSuccess = Point.checkBoundaries(newLocation);
		if (isSuccess) {
			this.location = newLocation;
		}
		//MessageUtility.logSetter(this.getClass().getSimpleName(), "setLocation", newLocation, isSuccess);
		return isSuccess;
	}

	public boolean setWeight(double weight) {
		boolean isSuccess = (weight >= 0);
		if (isSuccess) {
			this.weight = weight;
		} else {
			this.weight = 0;
		}
		return isSuccess;
	}

	@Override
	public String toString() {
		return "[" + this.getClass().getSimpleName() + "] ";
	}

	public void drawObject(Graphics g)
	{
		if (plant_image != null)
			g.drawImage(plant_image, 775, 337, 40, 40, zoopanel);
		zoopanel.manageZoo();
	}

	public void loadImages(String nm)
	{
		try
		{
			plant_image = ImageIO.read(new File(PICTURE_PATH +"\\"+ nm));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public String getColor() {
		return null;
	}


}
