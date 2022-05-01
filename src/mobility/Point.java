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
public class Point {
    private int x;
    private int y;
    private final int Max_x = 1550;
    private final int Max_y = 744;
    private final int Min_x = 0;
    private final int Min_y = 0;

    /**
     * Points in two-dimensional space by coordinates (integer type) X Y ,A constructor that receives two integers (X, Y) and updates coordinate X to parameter X,
     * and coordinate Y to parameter Y.
     *
     * @param x Coordinate X in space (integer type)
     * @param y Coordinate Y in space (integer type)
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * A copy constructor that receives a point type parameter,
     * checks if the point we got in the range,
     * then copies the X, Y coordinates of the point we got and the current point,
     * otherwise it does not change the current point
     *
     * @param other Point type object
     */
    public Point(Point other) {
        if (Point.checkBoundaries(other) == true) {
            this.x = other.getX();
            this.y = other.getY();
        }
    }

    /**
     * A boolean method that accepts as a position parameter (point type),
     * checks if the point is in the range (X between 0 and 800, Y between 0 600),
     * then returns "true" otherwise returns "false"
     *
     * @param p Any location in space (point type)
     * @return checks if the point is in the range (X between 0 and 800, Y between 0 600),
     * then returns "true" otherwise returns "false"
     */
    public static boolean checkBoundaries(Point p)
    {
        if (p.getX() <= p.getMax_x() && p.getX() >= p.getMin_x() && p.getY() <= p.getMax_y() && p.getY() >= p.getMin_y())
        {
            return true;
        }
        return false;
    }

    /**
     * A method that returns the current X coordinate
     * @return returns the current X coordinate (type integer)
     */

    /**
     * A method that returns the current Y coordinate
     * @return returns the current Y coordinate (type integer)
     */

    /**
     * A method that returns as a string the coordinates X, Y, in the format "(X, Y)"
     * @return as a string the coordinates X, Y, in the format "(X, Y)"
     */

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getMin_x() {
        return this.Min_x;
    }

    public int getMin_y() {
        return this.Min_y;
    }

    public int getMax_x() {
        return this.Max_x;
    }

    public int getMax_y() {
        return this.Max_y;
    }
}
