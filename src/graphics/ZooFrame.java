package graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ZooFrame extends JFrame {
    private ZooPanel zooPanel;

    public ZooFrame() {
        zooPanel = new ZooPanel();
        this.setTitle("Zoo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920, 774);
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu BackgraondMenu = new JMenu("Backgraond");
        JMenu helpMenu = new JMenu("Helo");
        menuBar.add(fileMenu);
        menuBar.add(BackgraondMenu);
        menuBar.add(helpMenu);
        this.setJMenuBar(menuBar);
        this.add(zooPanel);
        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem imageItem = new JMenuItem("Image");
        JMenuItem greenItem = new JMenuItem("Green");
        JMenuItem noneItem = new JMenuItem("None");
        JMenuItem helpItem = new JMenuItem("Help");
        fileMenu.add(exitItem);
        BackgraondMenu.add(imageItem);
        BackgraondMenu.add(greenItem);
        BackgraondMenu.add(noneItem);
        helpMenu.add(helpItem);
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        imageItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zooPanel.setBacgroud("savana");

            }
        });
        greenItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zooPanel.setBacgroud("green");
            }
        });
        noneItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zooPanel.setBacgroud("none");
            }
        });
        helpItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon i = new ImageIcon("LOGO.png");
                JOptionPane.showMessageDialog(null,"Home Work 2\n GUI", "Message",JOptionPane.OK_OPTION,i);
            }
        });
    }

    public static void main(String[] args) {
        ZooFrame f = new ZooFrame();
        f.setResizable(true);
        f.setVisible(true);
    }
}
