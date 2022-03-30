package mobility;

public class Mobile implements ILocatable {

    private Point location;
    private double totalDistance;

    public Mobile(Point location)
    {
        this.location.setX(location.getX());
        this.location.setY(location.getY());
        this.totalDistance = 0;
    }

    public void addTotalDistance(double distance)
    {
        this.totalDistance += distance;
    }

    public double calcDistance(Point newLocation)
    {
        double X_coordinate = newLocation.getX() - this.location.getX();
        double Y_coordinate = newLocation.getY() - this.location.getY();
        return Math.sqrt(Math.pow(X_coordinate, 2) + Math.pow(Y_coordinate, 2));
    }

    //TODO
    public double move(Point newLocation){
        return 0;
    }

    //TODO
    public boolean setLocation(Point point) {
        return true;
    }

    public Point getLocation() {
        return this.location;
    }
}
