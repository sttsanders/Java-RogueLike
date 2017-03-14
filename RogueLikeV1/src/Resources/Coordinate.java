package Resources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coordinate 
{
	public int x;
    public int y;
    public int z;

    public Coordinate(int x, int y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    @Override
    public int hashCode() 
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        result = prime * result + z;
        return result;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj)
        {
        	return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (!(obj instanceof Coordinate))
        {
            return false;
        }
        
        Coordinate other = (Coordinate) obj;
        
        if (x != other.x)
        {
            return false;
        }
        if (y != other.y)
        {
            return false;
        }
        if (z != other.z)
        {
        	return false;
        }
        return true;
    }
    
    public List<Coordinate> whichEightNeighbors()
    {
        List<Coordinate> points = new ArrayList<Coordinate>();
      
        for (int otherx = -1; otherx <= 1; otherx++){
            for (int othery = -1; othery <= 1; othery++){
                if (otherx == 0 && othery == 0)
                    continue;
        
                points.add(new Coordinate(x+otherx, y+othery, z));
            }
        }

        Collections.shuffle(points);
        return points;
    }
}
