package graphics;

import animals.Animal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Ofek Elgozi 318432085
//Elyasaf Sinvani 318551728
//Campus Ashdod
/**
 *A department that describes a zoo frame, builds a frame, and includes the entire user menu on the zoo frame
 * @author Elyasaf Sinvani
 * @see ZooPanel
 */
public class ZooFrame extends JFrame {
    private ZooPanel zooPanel;

    /**
     * The class builder initializes the "zoopanel" field, and builds the zoo frame including a menu of possibilities
     * (frame background change performed by "zoopanel", program closing, and user help)
     */
    public ZooFrame() {
        zooPanel = new ZooPanel();
        this.setTitle("Zoo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu BackgroundMenu = new JMenu("Backgraond");
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(fileMenu);
        menuBar.add(BackgroundMenu);
        menuBar.add(helpMenu);
        this.setJMenuBar(menuBar);
        this.add(zooPanel);
        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem imageItem = new JMenuItem("Image");
        JMenuItem greenItem = new JMenuItem("Green");
        JMenuItem noneItem = new JMenuItem("None");
        JMenuItem helpItem = new JMenuItem("Help");
        fileMenu.add(exitItem);
        BackgroundMenu.add(imageItem);
        BackgroundMenu.add(greenItem);
        BackgroundMenu.add(noneItem);
        helpMenu.add(helpItem);
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Animal A:zooPanel.getAnimals())
                {
                    A.getThread().stop();
                }
                zooPanel.getController().stop();

                System.exit(0);
            }
        });
        imageItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zooPanel.setBackground("savana");

            }
        });
        greenItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zooPanel.setBackground("green");
            }
        });
        noneItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zooPanel.setBackground("none");
            }
        });
        helpItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon i = new ImageIcon("LOGO.png");
                JOptionPane.showMessageDialog(null,"Home Work 3\n GUI", "Message",JOptionPane.OK_OPTION,i);
            }
        });
    }

    public static void main(String[] args)
    {
        ZooFrame f = new ZooFrame();
        f.setVisible(true);
        f.setResizable(false);
    }
}
