package Resources;

import java.util.List;

import Creatures.Creature;

public class Path {

	  private static PathFinder pf = new PathFinder();

	  
	  private List<Coordinate> points;
	  public List<Coordinate> points() { return points; }

	  public Path(Creature creature, int x, int y){
	      points = pf.findPath(creature, new Coordinate(creature.x, creature.y, creature.z), 
	                           new Coordinate(x, y, creature.z), 
	                           300);
	  }
}
