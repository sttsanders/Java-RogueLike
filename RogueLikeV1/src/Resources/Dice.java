package Resources;

import java.io.Serializable;
import java.util.Random;

public class Dice implements Serializable 
{
	
	Random r = new Random(); 
	
	public int rollDice(int times, DiceType diceType)
	{
		int result = 0;
		for(int x = 0; x < times; x++)
		{
			switch (diceType) {
        		case D3:  	result += r.nextInt(3)	+1; break;
            	case D4:  	result += r.nextInt(4)	+1; break;
            	case D6:  	result += r.nextInt(6)	+1; break;
            	case D8:  	result += r.nextInt(8)	+1; break;
            	case D10:  	result += r.nextInt(10)	+1; break;
            	case D12:  	result += r.nextInt(12)	+1; break;
            	case D20:  	result += r.nextInt(20)	+1; break;
			}
		}
		
		return result;
	}
}
