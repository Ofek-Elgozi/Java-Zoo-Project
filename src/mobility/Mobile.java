package mobility;

import utilities.MessageUtility;
//Ofek Elgozi 318432085
//Elyasaf Sinvani 318551728
//Campus Ashdod

/**
 * An abstract class that defines motion in space and implements the Ilocatable interface.
 * By using points that are in space and calculating distances between them
 * @version 1.10 29 March 2022
 * @author Elyasf Sinvani
 * @see Point
 */
public abstract class Mobile implements ILocatable
{
    private Point location;
    private double totalDistance;

    /**
     * A constructor that receives as an initial position parameter and the distance the animal has traveled is initialized to be 0
     * @param location Initial position point (point type)
     */
    public Mobile(Point location)
    {
        this.setLocation(location);
        this.totalDistance = 0;
    }

    /**
     * A method that accepts as a distance parameter (double type) and adds to the existing distance the distance it received
     * @param distance Some distance (double type)
     */
    public void addTotalDistance(double distance)
    {
        if (distance > 0)
            this.totalDistance += distance;
    }

    /**
     * A method that receives as a parameter a point in space of
     * thought and returns the distance from the current point to the point we received (by Pythagoras)
     * @param newLocation Any location in space (point type)
     * @return returns the distance from the current point to the point we received (by Pythagoras)
     */
    public double calcDistance(Point newLocation)
    {
        double X_coordinate = newLocation.getX() - this.location.getX();
        double Y_coordinate = newLocation.getY() - this.location.getY();
        return Math.sqrt(Math.pow(X_coordinate, 2) + Math.pow(Y_coordinate, 2));
    }

    /**
     * A method that receives as a parameter some point in space (point type) And checks if the point is in the range (Y coordinate between 0 and 600, X coordinate between 0 and 800),
     *if thr point in range calculates the distance from the current point to the point we got,
     * adds the distance to the current distance, updates our position to the position we got as a parameter,
     * and returns the distance calculated,else returns 0.
     * @param newLocation Any location in space (point type)
     * @return if the point is in the range (Y coordinate between 0 and 600, X coordinate between 0 and 800) Returns (double type) the distance from the current point to the point we got as a parameter,else returns 0.
     */
    public double move(Point newLocation)
    {
        if(Point.checkBoundaries(newLocation) == true)
        {
            double distanceMade = this.calcDistance(newLocation);
            this.addTotalDistance(distanceMade);
            this.setLocation(newLocation);
            return distanceMade;
        }
        return 0;
    }

    /**
     * Receives as a parameter a new position (point type),
     * checks if the point in the range(Y coordinate between 0 and 600, X coordinate between 0 and 800), if so,
     * updates the current position to the position we received, and returns "true",
     * otherwise the current position does not change and "false" is returned
     * @param point Positioning (point type)
     * @return if the point in the range(Y coordinate between 0 and 600, X coordinate between 0 and 800), if so,
     * updates the current position to the position we received, and returns "true",
     * otherwise the current position does not change and "false" is returned
     */
    public boolean setLocation(Point point)
    {
        boolean isSuccess;
        if(Point.checkBoundaries(point) == true)
        {
            isSuccess=true;
            this.location = new Point(point);
        }
        else
            isSuccess = false;
        return isSuccess;
    }

    /**
     * A method that returns the current position
     * @return the current position
     */
    public Point getLocation() {
        return this.location;
    }
}
