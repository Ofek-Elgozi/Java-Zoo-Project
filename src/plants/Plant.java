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
//Ofek Elgozi 318432085
//Elyasaf Sinvani 318551728
//Campus Ashdod
/**
 * Plant Class That Set Food For Animals (Meat,Lattuce,Cabbage)
 */
public abstract class Plant implements IEdible, ILocatable, IDrawable
{
	private Point location;
	private int height;
	private int width;
	private ZooPanel zoopanel;
	private BufferedImage plant_image = null;

	/**
	 * Constractor Of Object Plant That Set Width,Height,Location And ZooPanel
	 * @param zoopanel
	 */
	public Plant(ZooPanel zoopanel) {
		int x = 400;
		int y = 260;
		this.location = new Point(x, y);
		this.height = 40;
		this.width = 40;
		this.zoopanel = zoopanel;
	}

	/**
	 * Getter That Return The Width Of The Of The Food (Meat,Lattuce,Cabbage)
	 * @return Return The Width Of The Of The Food
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Getter Thar Return The Height Of The Of The Food (Meat,Lattuce,Cabbage)
	 * @return The Height Of The Of The Food
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Getter That Gives The Food Type
	 * @return The Food Type
	 */
	@Override
	public EFoodType getFoodtype() {
		return EFoodType.VEGETABLE;
	}

	/**
	 * Getter That Gives The Food Location
	 * @return The Location Of The Food
	 */
	@Override
	public Point getLocation() {
		return this.location;
	}

	/**
	 * Setter That Setting The Food Location
	 * @param newLocation
	 * @return True If The Food Was Located, Otherwise False
	 */
	@Override
	public boolean setLocation(Point newLocation) {
		boolean isSuccess = Point.checkBoundaries(newLocation);
		if (isSuccess) {
			this.location = newLocation;
		}
		return isSuccess;
	}

	/**
	 * Method ToString Gives The Name Of The Food (Meat,Lattuce,Cabbage)
	 * @return The Name Of The Food
	 */
	@Override
	public String toString() {
		return "[" + this.getClass().getSimpleName() + "] ";
	}

	/**
	 * Draw Food To The Center Of The Screen (400,260)
	 * @param g
	 */
	public void drawObject(Graphics g)
	{
		if (plant_image != null)
			g.drawImage(plant_image, this.location.getX(), this.location.getY(), this.getWidth(), this.getHeight(), zoopanel);
		//zoopanel.manageZoo();
	}

	/**
	 * Load The Picture Of The Food (Meat,Lattuce,Cabbage)
	 * @param plant_name
	 */
	public void loadImages(String plant_name)
	{
		try
		{
			plant_image = ImageIO.read(new File(PICTURE_PATH +"\\"+ plant_name));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Getter For Color Field
	 * @return The Color Of The Food
	 */
	@Override
	public String getColor() {
		return null;
	}
}
