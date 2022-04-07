package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZooFrame extends JFrame
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setTitle("Zoo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920,774);
        JLabel background;
        ImageIcon icon = new ImageIcon("savanna.png");
        frame.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
        JButton button1 = new JButton("Add Animal");
        JButton button2 = new JButton("Move Animal");
        JButton button3 = new JButton("Clear");
        JButton button4 = new JButton("Food");
        JButton button5 = new JButton("Info");
        JButton button6 = new JButton("Exit");
        button1.setPreferredSize(new Dimension(255,40));
        button2.setPreferredSize(new Dimension(255,40));
        button3.setPreferredSize(new Dimension(255,40));
        button4.setPreferredSize(new Dimension(255,40));
        button5.setPreferredSize(new Dimension(255,40));
        button6.setPreferredSize(new Dimension(255,40));
        panel.setPreferredSize(new Dimension(1920,40));
        panel.setBackground(Color.lightGray);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        frame.add(panel,BorderLayout.SOUTH);
        background =new JLabel("",icon,JLabel.CENTER);
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu BackgraondMenu = new JMenu("Backgraond");
        JMenu helpMenu = new JMenu("Helo");
        menuBar.add(fileMenu);
        menuBar.add(BackgraondMenu);
        menuBar.add(helpMenu);
        frame.setJMenuBar(menuBar);
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
        exitItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        imageItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().setBackground(Color.WHITE);
                frame.add(background);
                frame.invalidate();
                frame.validate();
                frame.repaint();

            }
        });
        noneItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(background);
                frame.getContentPane().setBackground(Color.WHITE);
                frame.invalidate();
                frame.validate();
                frame.repaint();
            }
        });
        greenItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(background);
                frame.getContentPane().setBackground(Color.GREEN);
                frame.invalidate();
                frame.validate();
                frame.repaint();
            }
        });
        helpItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon i = new ImageIcon("LOGO.png");
                JOptionPane.showMessageDialog(null,"Home Work 2\n GUI", "Message",JOptionPane.OK_OPTION,i);
                frame.invalidate();
                frame.validate();
                frame.repaint();
            }
        });
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
