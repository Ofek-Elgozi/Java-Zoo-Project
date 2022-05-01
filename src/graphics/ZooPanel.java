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

    public ZooPanel() {
        animals_list = new ArrayList<Animal>();
        plant = null;
        icon = new ImageIcon("LOGO.png");
        this.setLayout(new BorderLayout());
        this.setSize(1550, 774);
        JPanel Secendpanel = new JPanel();
        Secendpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        JButton button1 = new JButton("Add Animal");
        JButton button2 = new JButton("Move Animal");
        JButton button3 = new JButton("Clear");
        JButton button4 = new JButton("Food");
        JButton button5 = new JButton("Info");
        JButton button6 = new JButton("Exit");
        button1.setPreferredSize(new Dimension(255, 40));
        button2.setPreferredSize(new Dimension(255, 40));
        button3.setPreferredSize(new Dimension(255, 40));
        button4.setPreferredSize(new Dimension(255, 40));
        button5.setPreferredSize(new Dimension(255, 40));
        button6.setPreferredSize(new Dimension(255, 40));
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
                new MoveAnimalDialog(new ZooFrame(), ZooPanel.this);
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
                    if( animal.calcDistance(new Point(775,337)) < animal.getEatDistance() && animal.eat(this.plant))
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

    private boolean Changed()
    {
        for(Animal animal: animals_list)
        {
            if(animal.getChanges())
                return true;
        }
        return false;

    }

    public int getAnimalSize()
    {
        return this.animals_list.size();
    }

    public ArrayList<Animal> getAnimals() {

        return this.animals_list;
    }

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

    public void DeleteAllAnimals() {
        animals_list.clear();
    }

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
