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

	private Point location;
	private int height;
	private int width;
	private ZooPanel zoopanel;
	private BufferedImage plant_image = null;

	public Plant(ZooPanel zoopanel) {
		int x = 400;
		int y = 260;
		this.location = new Point(x, y);
		this.height = 40;
		this.width = 40;
		this.zoopanel = zoopanel;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public EFoodType getFoodtype() {
		return EFoodType.VEGETABLE;
	}

	@Override
	public Point getLocation() {
		return this.location;
	}

	@Override
	public boolean setLocation(Point newLocation) {
		boolean isSuccess = Point.checkBoundaries(newLocation);
		if (isSuccess) {
			this.location = newLocation;
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
			g.drawImage(plant_image, this.location.getX(), this.location.getY(), this.getWidth(), this.getHeight(), zoopanel);
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
