package plants;
//Ofek Elgozi 318432085
//Elyasaf Sinvani 318551728
//Campus Ashdod
import graphics.ZooPanel;

import java.awt.*;

/**
 * Lettuce Class That Set Food For Animals That Their Diet Is Herbivore (Omnivore Too)
 */
public class Lettuce extends Plant {
	/**
	 * Constractor Of Object Lettuce That Set ZooPanel
	 * @param zoopanel
	 */
	public Lettuce(ZooPanel zoopanel) {
		super(zoopanel);
	}

	/**
	 *
	 * @return The Color Of The Lettuce (Its An Image So Null)
	 */
	@Override
	public String getColor() {
		return null;
	}
}
