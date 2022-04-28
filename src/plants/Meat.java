package plants;

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
