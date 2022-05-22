package plants;
//Ofek Elgozi 318432085
//Elyasaf Sinvani 318551728
//Campus Ashdod
import food.EFoodType;
import graphics.ZooPanel;

/**
 * Meat Class That Set Food For Animals That Their Diet Is Carnivore (Omnivore Too)
 */
public class Meat extends Plant
{
    /**
     * Constractor Of Object Meat That Set ZooPanel
     * Set Image Of Meat In The Panel
     * @param pan
     */
    public Meat(ZooPanel pan)
    {
        super(pan);
        this.loadImages("meat.gif");
    }

    /**
     *
     * @return The Type Of The Meat (MEAT)
     */
    @Override
    public EFoodType getFoodtype() {
        return EFoodType.MEAT;
    }
}
