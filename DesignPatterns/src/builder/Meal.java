package builder;

import java.util.ArrayList;
import java.util.List;

public class Meal {
	
	private List<Item> items = new ArrayList<Item>(); 
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public float getTotalCost() {
		float cost = 0;
		for (Item item : items) {
			cost+=item.price();
		}
		return cost;
	}
	
	public void showItems() {
		for (Item item : items) {
			System.out.println("Name ->"+item.name());
			System.out.println("Price ->"+item.price());
			System.out.println("Packing ->"+item.packing().pack());			
		}
	}
}
