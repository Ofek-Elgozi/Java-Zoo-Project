package graphics;

<<<<<<< HEAD
import mobility.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import animals.Bear;
import animals.Elephant;
import animals.Giraffe;
import animals.Lion;
import animals.Turtle;
=======
import animals.*;
>>>>>>> main
import mobility.Point;
import zoo.ZooActions;

import javax.swing.*;
<<<<<<< HEAD
import java.awt.event.ActionListener;

public class MoveAnimalDialog extends JDialog implements ActionListener {
=======
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoveAnimalDialog extends JDialog implements ActionListener
{
>>>>>>> main

    private Point location;
    private JComboBox<String> animals_box;
    private String[] animals_string;
    private JLabel labelX;
    private JTextField x_field ;
    private JTextField y_field ;
    private JLabel labelY;
    private JPanel displayPanel;
    private JButton move;

<<<<<<< HEAD


=======
>>>>>>> main
    public MoveAnimalDialog(ZooFrame Zoo,ZooPanel zoopanel) {
        super(Zoo, "Move animal", true);
        displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.PAGE_AXIS));
        move = new JButton("Move");
        move.addActionListener(this);
<<<<<<< HEAD


=======
>>>>>>> main
        int size = zoopanel.getAnimals().size() ;
        int counter = 0;
        animals_string = new String[size];
        int LionCounter = 0;
        int BearCounter = 0;
        int ElephantCounter = 0;
        int GiraffeCounter = 0;
        int TurtleCounter = 0;
<<<<<<< HEAD




        for(int i = 0 ; i < size; i++) {

            if (zoopanel.getAnimals().get(i) == null)
                break;
            else {
                if (zoopanel.getAnimals().get(i) instanceof Lion ) {
=======
        for(int i = 0 ; i < size; i++) {
            if (zoopanel.getAnimals().get(i) == null)
                break;
            else {
                if (zoopanel.getAnimals().get(i) instanceof Lion) {
>>>>>>> main
                    LionCounter++;
                    animals_string[i] = zoopanel.getAnimals().get(i).getClass().getSimpleName()+" "+
                            LionCounter+" ("+zoopanel.getAnimals().get(i).getColor()+")";
                }
<<<<<<< HEAD
                if (zoopanel.getAnimals().get(i) instanceof Bear ) {
=======
                if (zoopanel.getAnimals().get(i) instanceof Bear) {
>>>>>>> main
                    BearCounter++;
                    animals_string[i] =  zoopanel.getAnimals().get(i).getClass().getSimpleName()+" "+
                            BearCounter+" ("+zoopanel.getAnimals().get(i).getColor()+")";
                }
<<<<<<< HEAD
                if (zoopanel.getAnimals().get(i) instanceof Elephant ) {
=======
                if (zoopanel.getAnimals().get(i) instanceof Elephant) {
>>>>>>> main
                    ElephantCounter++;
                    animals_string[i] =  zoopanel.getAnimals().get(i).getClass().getSimpleName()+" "+
                            ElephantCounter+" ("+zoopanel.getAnimals().get(i).getColor()+")";
                }
<<<<<<< HEAD
                if (zoopanel.getAnimals().get(i) instanceof Giraffe ) {
=======
                if (zoopanel.getAnimals().get(i) instanceof Giraffe) {
>>>>>>> main
                    GiraffeCounter++;
                    animals_string[i] =  zoopanel.getAnimals().get(i).getClass().getSimpleName()+" "+
                            GiraffeCounter+" ("+zoopanel.getAnimals().get(i).getColor()+")";
                }
<<<<<<< HEAD
                if (zoopanel.getAnimals().get(i) instanceof Turtle ) {
=======
                if (zoopanel.getAnimals().get(i) instanceof Turtle) {
>>>>>>> main
                    TurtleCounter++;
                    animals_string[i] =  zoopanel.getAnimals().get(i).getClass().getSimpleName()+" "+
                            TurtleCounter+" ("+zoopanel.getAnimals().get(i).getColor()+")";
                }
            }
<<<<<<< HEAD

        }
        ImageIcon icon =new ImageIcon("LOGO.png");
=======
        }
        ImageIcon icon =new ImageIcon("Mpicture.png");
>>>>>>> main
        animals_box = new JComboBox(animals_string);
        animals_box.addActionListener(this);
        displayPanel.add(animals_box);
        displayPanel.add(labelX = new JLabel("Enter X:"));
        displayPanel.add(x_field= new JTextField());
        displayPanel.add(labelY = new JLabel("Enter Y:"));
        displayPanel.add(y_field= new JTextField());
<<<<<<< HEAD


        move.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {

=======
        move.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
>>>>>>> main
                    int x = Integer.parseInt(x_field.getText());
                    int y = Integer.parseInt(y_field.getText());
                    int array_index = animals_box.getSelectedIndex();
                    if(ZooActions.move(zoopanel.getAnimals().get(array_index),new Point(x,y))) {
<<<<<<< HEAD

                        zoopanel.getAnimals().get(array_index).setChanges(true);
                        zoopanel.manageZoo();


=======
                        zoopanel.getAnimals().get(array_index).setChanges(true);
                        zoopanel.manageZoo();
>>>>>>> main
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Out of bounds",
                                "Message", JOptionPane.ERROR_MESSAGE, icon);
                    }
<<<<<<< HEAD


=======
>>>>>>> main
                }
                catch(NumberFormatException err) {
                    JOptionPane.showMessageDialog(null, "Wrong input entered",
                            "Message", JOptionPane.ERROR_MESSAGE, icon);
                }
                dispose();
            }
<<<<<<< HEAD

        });



=======
        });
>>>>>>> main
        displayPanel.add(move);
        this.add(displayPanel);
        this.pack();
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
        // TODO Auto-generated method stub

    }




=======

    }
>>>>>>> main
}
