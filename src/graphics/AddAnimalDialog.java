package graphics;

import animals.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAnimalDialog extends JDialog  implements ActionListener {

    private JLabel label;
    private JComboBox<String> box;
    private JLabel size_label;
    private JLabel horizon_speed_label;
    private JLabel vertical_speed_label;
    private  JTextField size_field;
    private  JTextField horizon_speed_field;
    private  JTextField vertical_speed_field;
    private JPanel displayPanel;
    private JComboBox<String> animal_color;
    private JButton create;
    private ZooPanel zoopanel;
    private String colors[]= {"Natural","Red","Blue"};
    private String[] animals = {"Lion","Bear","Elephant","Giraffe","Turtle"};




    public AddAnimalDialog(ZooPanel zoopanel, ZooFrame Zoo) {
        super(Zoo, "Add animal", true);
        displayPanel = new JPanel();
        this.zoopanel = zoopanel;
        create = new JButton("Create");
        create.addActionListener(this);
        box = new JComboBox(animals);
        box.addActionListener(this);
        animal_color = new JComboBox(colors);
        animal_color.addActionListener(this);
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.PAGE_AXIS));
        ImageIcon icon =new ImageIcon("LOGO.png");


        this.label = new JLabel();
        this.label = new JLabel("Select animal");
        this.label.setVerticalTextPosition(JLabel.TOP);
        this.label.setHorizontalAlignment(JLabel.LEFT);
        displayPanel.add(label);
        displayPanel.add(box);
        displayPanel.add(size_label = new JLabel("Size:"));
        displayPanel.add(size_field= new JTextField());
        displayPanel.add(horizon_speed_label = new JLabel("Horizon speed:"));
        displayPanel.add(horizon_speed_field= new JTextField());
        displayPanel.add(vertical_speed_label = new JLabel("Vertical speed:"));
        displayPanel.add(vertical_speed_field= new JTextField());
        displayPanel.add(animal_color);
        create.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String animal_choosen = box.getItemAt(box.getSelectedIndex());
                    int size = Integer.parseInt(size_field.getText());
                    int horizon_speed = Integer.parseInt(horizon_speed_field.getText());
                    int vertical_speed = Integer.parseInt(vertical_speed_field.getText());
                    String color = animal_color.getItemAt(animal_color.getSelectedIndex());
                    String name = "default";
                    float weight = 0;
                    if(50 > size || size > 300 || horizon_speed < 1 || horizon_speed > 10
                            ||vertical_speed < 1 || vertical_speed > 10 )
                        throw new NumberFormatException();
                    switch(animal_choosen) {
                        case "Lion":
                            weight = (float) (size * 0.8);


                            Animal lion = new Lion(name,weight,color,zoopanel);
                            lion.setHorSpeed(horizon_speed);
                            lion.setVerSpeed(vertical_speed);
                            lion.setSize(size);
                            zoopanel.addAnimallist(lion);
                            zoopanel.repaint();

                            break;

                        case "Bear":
                            weight = (float) (size * 1.5);
                            Animal bear = new Bear(name,weight,color,zoopanel);
                            bear.setHorSpeed(horizon_speed);
                            bear.setVerSpeed(vertical_speed);
                            bear.setSize(size);
                            zoopanel.addAnimallist(bear);
                            break;

                        case "Giraffe":
                            weight = (float) (size * 2.2);
                            Animal giraffe = new Giraffe(name,weight,color,zoopanel);
                            giraffe.setHorSpeed(horizon_speed);
                            giraffe.setVerSpeed(vertical_speed);
                            giraffe.setSize(size);
                            zoopanel.addAnimallist(giraffe);
                            break;


                        case "Elephant":
                            weight = size * 10;
                            Animal elephant = new Elephant(name,weight,color,zoopanel);
                            elephant.setHorSpeed(horizon_speed);
                            elephant.setVerSpeed(vertical_speed);
                            elephant.setSize(size);
                            zoopanel.addAnimallist(elephant);
                            break;


                        case "Turtle":
                            weight = (float) (size * 0.5);
                            Animal turtle = new Turtle(name,weight,color,zoopanel);
                            turtle.setHorSpeed(horizon_speed);
                            turtle.setVerSpeed(vertical_speed);
                            turtle.setSize(size);
                            zoopanel.addAnimallist(turtle);
                            break;


                    }

                }
                catch(NumberFormatException err) {
                    JOptionPane.showMessageDialog(null, "Wrong input entered",
                            "Message", JOptionPane.ERROR_MESSAGE, icon);
                }

                dispose();

            }});

        displayPanel.add(create);

        this.add(displayPanel);


        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
