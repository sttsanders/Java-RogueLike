package Resources;

public enum Direction 
{
	North, 
	South, 
	East, 
	West;

    Direction opposite;

    static 
    {
    	North.opposite = South;
    	South.opposite = North;
    	East.opposite = West;
    	West.opposite = East;
    }

    public Direction getOppositeDirection() 
    {
        return opposite;
    }
    
    public Direction returnDirectionByInt(int x)
    {
    	switch(x)
    	{
    	case 0: 	return North;
    	case 1: 	return South;
    	case 2: 	return East;
    	default: 	return West;
    	}
    }

	public static int returnInt(Direction direction) 
	{
    	switch(direction)
    	{
    	case North: 	return 0;
    	case South: 	return 1;
    	case East: 		return 2;
    	default: 		return 3;
    	}
	}
}
