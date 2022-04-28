package graphics;

import java.awt.*;

public interface IDrawable
{
    public final static String PICTURE_PATH = "C:\\Java-Zoo-Project\\images";
    public void loadImages(String nm);
    public void drawObject (Graphics g);
    public String getColor();
}
