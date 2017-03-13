package Resources;

import java.io.Serializable;
import java.util.Random;

public class Dice implements Serializable {
	
	Random r = new Random(); 
	
	public int rollDice(int times, int diceType)
	{
		int result = 0;
		for(int x = 0; x < times; x++)
		{
			result += r.nextInt(diceType)+1;
		}
		
		return result;
	}
}
