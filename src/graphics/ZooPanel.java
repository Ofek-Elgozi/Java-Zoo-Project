package graphics;

import animals.Animal;
import diet.Carnivore;
import diet.Omnivore;
import mobility.Point;
import plants.Cabbage;
import plants.Lettuce;
import plants.Meat;
import plants.Plant;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *The "panel" department of the zoo, for creating "panel" objects within the "panel",
 *  with the rest of the outer panel being the background where all the animals inside the zoo will be, and the inner panel will contain all the options the user can make at the zoo
 * (adding animal, moving animal, Deletion of all the animals in the zoo, food, information about all the animals in the zoo, exit)
 * @author Elyasaf Sinvani
 * @see ZooFrame
 */
public class ZooPanel extends JPanel implements Runnable
{
    private BufferedImage image = null;
    private ArrayList<Animal> animals_list;
    private Plant plant;
    private Boolean Check = false;
    private ImageIcon icon;
    private static final int LETTUCE = 1;
    private static final int CABBAGE = 2;
    private static final int MEAT = 3;
    private static final int DELETE = 4;

    /**
     * The class builder who initializes the panel within a panel of the zoo
     */
    public ZooPanel() {
        animals_list = new ArrayList<Animal>();
        plant = null;
        icon = new ImageIcon("LOGO.png");
        this.setLayout(new BorderLayout());
        this.setSize(800, 600);
        JPanel Secendpanel = new JPanel();
        Secendpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        JButton button1 = new JButton("Add Animal");
        JButton button2 = new JButton("Move Animal");
        JButton button3 = new JButton("Clear");
        JButton button4 = new JButton("Food");
        JButton button5 = new JButton("Info");
        JButton button6 = new JButton("Exit");
        button1.setPreferredSize(new Dimension(130, 40));
        button2.setPreferredSize(new Dimension(130, 40));
        button3.setPreferredSize(new Dimension(130, 40));
        button4.setPreferredSize(new Dimension(130, 40));
        button5.setPreferredSize(new Dimension(130, 40));
        button6.setPreferredSize(new Dimension(130, 40));
        Secendpanel.add(button1);
        Secendpanel.add(button2);
        Secendpanel.add(button3);
        Secendpanel.add(button4);
        Secendpanel.add(button5);
        Secendpanel.add(button6);
        this.add(Secendpanel, BorderLayout.SOUTH);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddAnimalDialog(ZooPanel.this, new ZooFrame());
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (animals_list.size() == 0) {
                    JOptionPane.showMessageDialog(null, "There are no animals in the zoo, please add an animal first ...",
                            "Message", JOptionPane.ERROR_MESSAGE, icon);
                }
                else
                {
                    new MoveAnimalDialog(new ZooFrame(), ZooPanel.this);
                }
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DeleteAllAnimals();
                setPlant(DELETE);
                repaint();
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog foodDialog = new JDialog(new ZooFrame(), "Food for animlas", true);
                JButton Lettuce = new JButton("Lettuce");
                JButton Cabbage = new JButton("Cabbage");
                JButton Meat = new JButton("Meat");
                Lettuce.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e1)
                    {
                            setPlant(LETTUCE);
                            foodDialog.dispose();

                    }
                });


                Cabbage.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e1)
                    {


                            setPlant(CABBAGE);
                            foodDialog.dispose();

                    }
                });

                Meat.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e1) {

                            setPlant(MEAT);
                            foodDialog.dispose();

                    }
                });
                JLabel foodLabel = new JLabel("Please choose food");
                foodLabel.setIcon(icon);
                foodLabel.setIconTextGap(25);
                JPanel panel = new JPanel();
                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new FlowLayout());
                buttonPanel.add(Cabbage);
                buttonPanel.add(Lettuce);
                buttonPanel.add(Meat);
                panel.setLayout(new BorderLayout());
                panel.add(buttonPanel, BorderLayout.SOUTH);
                panel.add(foodLabel,BorderLayout.CENTER);
                foodDialog.add(panel);
                foodDialog.pack();
                foodDialog.setVisible(true);
                setVisible(true);
            }

        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog info_dialog = new JDialog(new ZooFrame(), "Zoo info", true);
                InfoTable at = new InfoTable(ZooPanel.this);
                JTable table = new JTable(at);
                table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                table.setPreferredScrollableViewportSize(new Dimension(500, 70));
                table.setFillsViewportHeight(true);
                info_dialog.add(new JScrollPane(table));
                info_dialog.pack();
                info_dialog.setVisible(true);
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * A method that draws the background of the zoo inside the outer panel,
     * and draws all the animals in the zoo on the outer panel
     * @param g A "graphics" object that allows you to draw the animal images and background on the outer panel.
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D gr = (Graphics2D) g;
        gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if(Check)
        {
            Dimension size = this.getSize();
            gr.drawImage(image, 0, 0, size.width, size.height, this);
        }
        try
        {
            for(Animal animals: animals_list)
                animals.drawObject(gr);
            plant.drawObject(gr);
        }
        catch(Exception e)
        {
            return;
        }

    }

    /**
     * A method that replaces backgrounds on the outer panel,
     * gets a string object that describes the background we want to be displayed on the outer panel
     * @param Picture string object that describes the background we want to be displayed on the outer panel
     */
    public void setBackground(String Picture)
    {
        if (Picture == "savana")
        {
            try {
                image = ImageIO.read(new File("C:\\Java-Zoo-Project\\images\\savanna.png"));
                Check =true;
                this.setBackground((Color) null);
                repaint();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (Picture == "green") {
            image = null;
            Check =false;
            this.setBackground(Color.GREEN);
            repaint();

        } else if (Picture == "none") {
            image = null;
            Check =false;
            this.setBackground(Color.WHITE);
            repaint();
        }
    }

    /**
     * A method that deals with eating at the zoo, checks if an animal is a Carnivore or Omnivore,
     * then checks that the animal that wants to eat can eat the prey,
     * and if the weight of the predatory animal is at least twice as large as the prey,
     * and if the distance between them is smaller than the prey,
     * if all conditions are met Delete the eaten animal and add to the carnivorous animal its weight and number of eats,
     * and also treat in case an animal eats food,
     * if the distance of the animal from the food is less than 10 pixels in both axis X and axis Y the animal eats the food,
     * delete the food from the panel and increase the weight of the animal eaten
     */
    public void manageZoo()
    {
        if(Changed() == true)
        {
            repaint();
            List<Animal> toRemove = new ArrayList<Animal>();
            for(Animal animal : animals_list)
            {
                if(animal.getDiet() instanceof Carnivore || animal.getDiet() instanceof Omnivore)
                {
                    for(int i = 0 ; i < animals_list.size(); i++ )
                    {
                        if(animal.calcDistance(animals_list.get(i).getLocation()) < animals_list.get(i).getWeight())
                            if(animal.getWeight() > 2 * animals_list.get(i).getWeight())
                                if(animal.eat(animals_list.get(i)))
                                {
                                    toRemove.add(animals_list.get(i));
                                    animal.eatInc();
                                    repaint();
                                }
                    }
                }
                if(this.plant != null)
                {
//                    if( animal.calcDistance(new Point(400,260)) < animal.getEatDistance() && animal.eat(this.plant))
                    if(plant.getLocation().getX() - animal.getLocation().getX() < 10 && plant.getLocation().getY() - animal.getLocation().getY() < 10)
                    {
                        this.plant = null;
                        animal.eatInc();
                        repaint();
                    }
                }
            }
            animals_list.removeAll(toRemove);
        }
    }

    /**
     * A method that returns "true" if the position of at least one of the animals in the zoo has changed,
     * otherwise returns "false"
     * @return  "true" if the position of at least one of the animals in the zoo has changed, otherwise returns "false"
     */
    private boolean Changed()
    {
        for(Animal animal: animals_list)
        {
            if(animal.getChanges())
                return true;
        }
        return false;

    }

    /**
     * A method that returns the array size of existing zoos
     * @return  the array size of existing zoos (number of the animaks in zoo)
     */
    public int getAnimalSize()
    {
        return this.animals_list.size();
    }

    /**
     * A method that returns the array of all the animals in the zoo
     * @return the array of all the animals in the zoo
     */
    public ArrayList<Animal> getAnimals() {

        return this.animals_list;
    }

    /**
     * A method that handles the addition of a new animal to the zoo, the method accepts as an parameter an "animal" type, if there are 10 animals in the zoo an error message will be displayed to the user (it is not possible to have more than 10 animals at the zoo),
     * Otherwise the method will add the animal it received as a parameter to the zoo's array of animals
     * @param animal An animal object depicting a new animal that you want to add to the zoo
     */
    public void addAnimallist(Animal animal)
    {
        try {
            if ( animals_list.size() == 10)
            {
                throw new ArrayIndexOutOfBoundsException();
            }
            animals_list.add(animal);
        }
        catch(ArrayIndexOutOfBoundsException error) {
            ImageIcon icon =new ImageIcon("LOGO.png");
            JOptionPane.showMessageDialog(null, "You cannot add more than 10 animlas",
                    "Message", JOptionPane.ERROR_MESSAGE, icon);
        }
    }

    /**
     * A method that deletes all existing animals in the zoo (initializes the set of animals to null)
     */
    public void DeleteAllAnimals() {
        animals_list.clear();
    }

    /**
     *A method that initializes the "plant" field,
     *  gets an int type object that describes the type of food we want to load its image into the "plant" class field,
     *  if the parameter is 4 then initialize the "plant" field to be null
     * @param TempPlanet An "int" object that describes the type of plant we want to initialize its image to
     *                  the "plant" field of the class, if the number is 4 we start the "plant" field to be null
     */
    public void setPlant(int TempPlanet ) {
        if(TempPlanet == 1) {
            this.plant = new Lettuce(this);
            this.plant.loadImages("lettuce.png");
            this.repaint();
        }
        else if(TempPlanet == 2) {
            this.plant = new Cabbage(this);
            this.plant.loadImages("cabbage.png");
            this.repaint();

        }
        else if (TempPlanet == 3) {
            this.plant = new Meat(this);
            this.plant.loadImages("meat.gif");
            this.repaint();
        }
        else
            this.plant = null;
    }

    @Override
    public void run() {

    }

}
