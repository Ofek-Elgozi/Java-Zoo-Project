package graphics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZooFrame extends JFrame {
    private ZooPanel zooPanel;

    public ZooFrame() {
        zooPanel = new ZooPanel();
        this.setTitle("Zoo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                JOptionPane.showMessageDialog(null,"Home Work 2\n GUI", "Message",JOptionPane.OK_OPTION,i);
            }
        });
        this.setSize(1550, 774);
    }

    public static void main(String[] args)
    {
        ZooFrame f = new ZooFrame();
        f.setVisible(true);
    }
}
