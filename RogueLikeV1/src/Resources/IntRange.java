package Resources;

import java.util.Random;

public class IntRange
{
    public int m_Min;       // The minimum value in this range.
    public int m_Max;       // The maximum value in this range.
    Random r = new Random(); 

    // Constructor to set the values.
    public IntRange(int min, int max)
    {
        m_Min = min;
        m_Max = max;
    }


    // Get a random value from the range.
    public int getRandom()
    {
    	int range = m_Max - m_Min + 1;
    	int randomNum =  r.nextInt(range) + m_Min;
    	return randomNum;
    }
}
