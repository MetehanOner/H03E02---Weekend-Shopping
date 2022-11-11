package de.tum.in.ase;


import java.util.Objects;

public final class Shopping {
	private final Item[] shoppingList;
	private int bagCapacity;

	public Shopping(Item[] shoppingList, int bagCapacity) {
		this.shoppingList = shoppingList;
		this.bagCapacity = bagCapacity;
	}

	// TODO: implement search(String itemName)
	public int search(String itemName){
		int i = 0;
		boolean found = false;

		while(!found && i < getShoppingList().length) {
			String a = getShoppingList()[i].getName().toLowerCase().replaceAll("\\s+", "");
			String b = itemName.toLowerCase().replaceAll("\\s+", "");
			found = Objects.equals(a ,b);
			i++;
		}

		if(!found){
			return -1;
		} else {
			return i;
		}

	}

	// TODO: implement findMin()


	// TODO: implement findMax()


	// TODO: implement fillBagMax()


	// TODO: implement calValue()



	public static void main(String[] args) {
		//you can test your code here by creating your own shopping object
		Item a = new Item("hafer", 1, 5);
		Item b = new Item("salat", 4, 3);
		Item c = new Item("banana", 3, 8);

		Item[] items = new Item[3];
		items[0] = a;
		items[1] = b;
		items[2] = c;

		Shopping s = new Shopping(items, 10);
		int cool = s.search("SA LAT");

		System.out.print(cool);


	}

	public void setBagCapacity(int bagCapacity) {
		this.bagCapacity = bagCapacity;
	}

	public int getBagCapacity() {
		return bagCapacity;
	}

	public Item[] getShoppingList() {
		return shoppingList;
	}
}
