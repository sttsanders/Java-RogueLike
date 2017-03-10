package Resources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import Creatures.Creature;

public class PathFinder {
    private ArrayList<Coordinate> open;
    private ArrayList<Coordinate> closed;
    private HashMap<Coordinate, Coordinate> parents;
    private HashMap<Coordinate,Integer> totalCost;
  
    public PathFinder() {
          this.open = new ArrayList<Coordinate>();
          this.closed = new ArrayList<Coordinate>();
          this.parents = new HashMap<Coordinate, Coordinate>();
          this.totalCost = new HashMap<Coordinate, Integer>();
    }
  
    private int heuristicCost(Coordinate from, Coordinate to) {
          return Math.max(Math.abs(from.x - to.x), Math.abs(from.y - to.y));
    }

    private int costToGetTo(Coordinate from) {
          return parents.get(from) == null ? 0 : (1 + costToGetTo(parents.get(from)));
    }
  
    private int totalCost(Coordinate from, Coordinate to) {
          if (totalCost.containsKey(from))
              return totalCost.get(from);
        
          int cost = costToGetTo(from) + heuristicCost(from, to);
          totalCost.put(from, cost);
          return cost;
    }

    private void reParent(Coordinate child, Coordinate parent){
          parents.put(child, parent);
          totalCost.remove(child);
    }

    public ArrayList<Coordinate> findPath(Creature creature, Coordinate start, Coordinate end, int maxTries) {
          open.clear();
          closed.clear();
          parents.clear();
          totalCost.clear();
    
          open.add(start);
        
          for (int tries = 0; tries < maxTries && open.size() > 0; tries++){
        	  Coordinate closest = getClosestPoint(end);
              
                open.remove(closest);
                closed.add(closest);

                if (closest.equals(end))
                      return createPath(start, closest);
                else
                      checkNeighbors(creature, end, closest);
          }
          return null;
    }

     private Coordinate getClosestPoint(Coordinate end) {
    	 Coordinate closest = open.get(0);
         for (Coordinate other : open){
             if (totalCost(other, end) < totalCost(closest, end))
                 closest = other;
         }
         return closest;
     }

     private void checkNeighbors(Creature creature, Coordinate end, Coordinate closest) {
         for (Coordinate neighbor : closest.whichEightNeighbors()) {
             if (closed.contains(neighbor)
              || !creature.canEnter(neighbor.x, neighbor.y, creature.z)
              && !neighbor.equals(end))
                  continue;
 
             if (open.contains(neighbor))
                 reParentNeighborIfNecessary(closest, neighbor);
             else
                 reParentNeighbor(closest, neighbor);
         }
     }

     private void reParentNeighbor(Coordinate closest, Coordinate neighbor) {
         reParent(neighbor, closest);
         open.add(neighbor);
     }

     private void reParentNeighborIfNecessary(Coordinate closest, Coordinate neighbor) {
    	 Coordinate originalParent = parents.get(neighbor);
         double currentCost = costToGetTo(neighbor);
         reParent(neighbor, closest);
         double reparentCost = costToGetTo(neighbor);

         if (reparentCost < currentCost)
             open.remove(neighbor);
         else
             reParent(neighbor, originalParent);
     }

     private ArrayList<Coordinate> createPath(Coordinate start, Coordinate end) {
         ArrayList<Coordinate> path = new ArrayList<Coordinate>();

         while (!end.equals(start)) {
             path.add(end);
             end = parents.get(end);
         }

         Collections.reverse(path);
         return path;
     }
 }