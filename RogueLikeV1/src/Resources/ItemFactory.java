package Resources;

import asciiPanel.AsciiPanel;

public class ItemFactory {
	private World world;
	
	public ItemFactory(World world){
		this.world = world;
	}
	
	public void createItems() {
		// TODO Auto-generated method stub
		for (int z = 0; z < world.getDepth(); z++){
	        for (int i = 0; i < 40; i++){
	            newSpear(z);
	        }
	    }
	}
	
	
	public Item newSpear(int depth){
        Item spear = new Item('-', AsciiPanel.green, "spear");
        world.addAtEmptyLocation(spear, depth);
        return spear;
    }
	
	
}
