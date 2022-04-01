package mobility;

import utilities.MessageUtility;

public class Point
{
    private int x;
    private int y;
    private static final int Max_x= 800;
    private static final int Max_y = 600;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Point(Point other)
    {
        if (Point.checkBoundaries(other) == true)
        {
            this.x = other.getX();
            this.y = other.getY();
        }
    }

    public static boolean checkBoundaries(Point p)
    {
        if( p.x <= Max_x && p.x >= 0 && p.y <= Max_y && p.y >= 0)
            return true;
        return false;
    }

    public int getX(){return this.x;}
    public int getY(){return this.y;}


}
