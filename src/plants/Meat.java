package plants;
//Ofek Elgozi 318432085
//Elyasaf Sinvani 318551728
//Campus Ashdod
import food.EFoodType;
import graphics.ZooPanel;

public class Meat extends Plant
{
    public Meat(ZooPanel pan)
    {
        super(pan);
        this.loadImages("meat.gif");
    }

    @Override
    public EFoodType getFoodtype() {
        return EFoodType.MEAT;
    }
}
