package mobility;

/**
 * Interface that describes the functionality of the place, by returning the current location and defining a new location
 * @version 1.10 29 March 2022
 * @author Elyasaf Sinvani
 * @see Point
 */
public interface ILocatable
{
    Point getLocation();
    boolean setLocation(Point newLocation);
}
