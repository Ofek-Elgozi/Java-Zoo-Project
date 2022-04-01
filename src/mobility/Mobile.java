package mobility;

import utilities.MessageUtility;

public abstract class Mobile implements ILocatable
{
    private Point location;
    private double totalDistance;

    public Mobile(Point location)
    {
        this.setLocation(location);
        this.totalDistance = 0;
    }

    public void addTotalDistance(double distance)
    {
        if (distance > 0)
            this.totalDistance += distance;
    }

    public double calcDistance(Point newLocation)
    {
        double X_coordinate = newLocation.getX() - this.location.getX();
        double Y_coordinate = newLocation.getY() - this.location.getY();
        return Math.sqrt(Math.pow(X_coordinate, 2) + Math.pow(Y_coordinate, 2));
    }


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

    public Point getLocation() {
        return this.location;
    }
}
