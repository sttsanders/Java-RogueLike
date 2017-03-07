package Screen;

import Creatures.Creature;
import Resources.Item;
import asciiPanel.AsciiPanel;

public class DropScreen extends InventoryScreen{
	public DropScreen(Creature player) {
        super(player);
    }
	
	protected String getVerb() {
        return "drop";
    }
	
	protected boolean isAcceptable(Item item) {
        return true;
    }
	
	protected Screen use(Item item) {
        player.drop(item);
        return null;
    }
	
	
}
