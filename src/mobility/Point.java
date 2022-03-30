package mobility;

public class Point
{
    private int x;
    private int y;
    private static final int Max_x= 800;
    private static final int Max_y = 600;

    //TODO
    public Point(int x, int y)
    {
        this.setX(x);
        this.setY(y);
    }

    public Point(Point other)
    {
        this.setX(other.getX());
        this.setY(other.getY());
    }

    //TODO
    public static boolean checkBoundaries(Point p)
    {
        if( p.x <= Max_x && p.x >= 0 && p.y <= Max_y && p.y >= 0)
            return true;
        return false;
    }

    public int getX(){return this.x;}
    public int getY(){return this.y;}

    public boolean setX(int x){
        if(x < Max_x && x > 0 ){
            this.x = x;
            return true;
        }
        this.x = 0;
        return false;
    }

    public boolean setY(int y){
        if(y < Max_y && y > 0 ){
            this.y = y;
            return true;
        }
        this.y = 0;
        return false;
    }
}
