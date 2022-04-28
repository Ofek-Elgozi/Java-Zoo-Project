package mobility;

//Ofek Elgozi 318432085
//Elyasaf Sinvani 318551728
//Campus Ashdod

/**
 * Points in two-dimensional space by X Y coordinates
 * @version 1.10 29 March 2022
 * @author Ofek Elgozi
 * @see Mobile
 */
public class Point
{
    private int x;
    private int y;
    private static final int Max_x= 800;
    private static final int Max_y = 600;

    /**
     * Points in two-dimensional space by coordinates (integer type) X Y ,A constructor that receives two integers (X, Y) and updates coordinate X to parameter X,
     * and coordinate Y to parameter Y.
     * @param x Coordinate X in space (integer type)
     * @param y Coordinate Y in space (integer type)
     */
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Receives coordinate X as a parameter (integer type) checks if parameter X is in the range (between 0 and 800),
     * and updates the current X coordinate to the parameter we received,
     * If the placement was successful to X,
     * "true" would be returned otherwise "false" would be returned.
     * @param x An integer describing the X coordinate
     * @return If the placement was successful to X,
     *   "true" would be returned otherwise "false" would be returned.
     */
    public boolean setX(int x)
    {
        if(x >= 0 && x <= Max_x)
        {
            this.x = x;
            return true;
        }
        return false;
    }

    /**
     * Receives coordinate Y as a parameter (integer type) checks if parameter Y is in the range (between 0 and 600),
     *      * and updates the current Y coordinate to the parameter we received,
     *      * If the placement was successful to Y,
     *      * "true" would be returned otherwise "false" would be returned.
     * @param y An integer describing the Y coordinate
     * @return If the placement was successful to Y,
     *   "true" would be returned otherwise "false" would be returned.
     */
    public boolean setY(int y)
    {
        if(y >= 0 && y <= Max_y)
        {
            this.y = y;
            return true;
        }
        return false;
    }

    /**
     * A copy constructor that receives a point type parameter,
     * checks if the point we got in the range,
     * then copies the X, Y coordinates of the point we got and the current point,
     * otherwise it does not change the current point
     * @param other Point type object
     */
    public Point(Point other)
    {
        if (Point.checkBoundaries(other) == true)
        {
            this.x = other.getX();
            this.y = other.getY();
        }
    }

    /**
     * A boolean method that accepts as a position parameter (point type),
     * checks if the point is in the range (X between 0 and 800, Y between 0 600),
     * then returns "true" otherwise returns "false"
     * @param p Any location in space (point type)
     * @return checks if the point is in the range (X between 0 and 800, Y between 0 600),
     * then returns "true" otherwise returns "false"
     */
    public static boolean checkBoundaries(Point p)
    {
        if( p.x <= Max_x && p.x >= 0 && p.y <= Max_y && p.y >= 0)
            return true;
        return false;
    }

    /**
     * A method that returns the current X coordinate
     * @return returns the current X coordinate (type integer)
     */
    public int getX(){return this.x;}
    /**
     * A method that returns the current Y coordinate
     * @return returns the current Y coordinate (type integer)
     */
    public int getY(){return this.y;}

    /**
     * A method that returns as a string the coordinates X, Y, in the format "(X, Y)"
     * @return as a string the coordinates X, Y, in the format "(X, Y)"
     */
}
