package graphics;

import animals.Animal;
import animals.Lion;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 *Class That Gives The Option To See The Information About All The Animals That Are Exist In The Panel With Several Fields. (Name,Color,Weigth,Horizonal Speed,Vertical Speed)
 */
public class InfoTable extends AbstractTableModel {

    private ArrayList<Animal> animals;
    private ZooPanel zoopanel;
    private final String[] columnNames = {"Name","Color","Weight","Hor","Ver","Eat"};

    /**
     * Constractor THat Build The Table(Panel) To See An Information About Animals With Serveral Fields (Select Animal,Size,Horizon Speed, Vertical Speed)
     * @param zoopanel
     */
    public InfoTable(ZooPanel zoopanel) {
        this.zoopanel = zoopanel;

        animals = new ArrayList<Animal>();
        int tot_eat = 0;
        for(int i = 0; i< zoopanel.getAnimalSize(); i++) {
            animals.add(zoopanel.getAnimals().get(i));
            tot_eat += zoopanel.getAnimals().get(i).getEatCount();
        }
        Animal total = new Lion("Total",10,"Red", zoopanel);
        total.setEat(tot_eat);
        animals.add(total);

    }

    /**
     * Getter For The Amount Of The Animals That Added
     * @return Amount Of Animals
     */
    @Override
    public int getRowCount() {
        return animals.size();
    }

    /**
     * Getter For The Amount Of Fields In The Information Table
     * @return 6 Columns
     */
    @Override
    public int getColumnCount() {

        return 6;
    }

    /**
     * Getter For The Name Of The Field In The Table
     * @param column
     * @return Column Name
     */
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    /**
     * Get The Values For A Specific Column (Field) And Animal In The Table
     * @param rowIndex
     * @param columnIndex
     * @return Information About A Specific Field Of A Specific Animal
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Animal a = animals.get(rowIndex);
        switch(columnIndex) {
            case 0: if(a.getName()=="default") {return a.getAnimalName();}
            else {return a.getName();}
            case 1:if(a.getName()=="default") {return a.getColor();}
            else {return " ";}
            case 2:if(a.getName()=="default") {return a.getWeight();}
            else {return " ";}
            case 3:if(a.getName()=="default") {return a.getHorSpeed();}
            else {return " ";}
            case 4:if(a.getName()=="default") {return a.getVerSpeed();}
            else {return " ";}
            case 5:return a.getEatCount();

        }
        return null;
    }
}
