package tenacity.Entity.Mind.Data;

public class Item extends Data {
	Item item;
	
	public Item(Item item) {
		type = "item";
		this.item = item;
	}
}
