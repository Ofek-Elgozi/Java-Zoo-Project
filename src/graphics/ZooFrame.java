package graphics;

import javax.swing.*;
import java.awt.*;

public class ZooFrame extends JFrame
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setTitle("Zoo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }
}
