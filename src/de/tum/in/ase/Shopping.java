package de.tum.in.ase;


import java.util.Objects;

public final class Shopping {
	private final Item[] shoppingList;
	private int bagCapacity;

	public Shopping(Item[] shoppingList, int bagCapacity) {
		setBagCapacity(bagCapacity);
		this.shoppingList  = shoppingList;

	}

	// TODO: implement search(String itemName)
	public int search(String itemName){
		int i = 0;
		boolean found = false;

		while (!found && i < getShoppingList().length) {
			String a = getShoppingList()[i].getName().toLowerCase().replaceAll("\\s+", "");
			String b = itemName.toLowerCase().replaceAll("\\s+", "");
			found = Objects.equals(a ,b);
			i++;
		}

		if(!found){
			return -1;
		} else {
			return i-1;
		}

	}

	// TODO: implement findMin()
	public int findMin(){
		Item result = getShoppingList()[0];
		int index = 0;
		for (int i = 1; i < getShoppingList().length; i++) {
			if (getShoppingList()[i].getValue() < result.getValue()) {
				result = getShoppingList()[i];
				index = i;
			}
		}

		if(getShoppingList() == null){
			return -1;
		} else {
			return index;
		}
	}

	// TODO: implement findMax()
	public int findMax(){
		Item result = getShoppingList()[0];
		int index = 0;
		for (int i = 1; i < getShoppingList().length; i++) {
			if (getShoppingList()[i].getValue() > result.getValue()) {
				result = getShoppingList()[i];
				index = i;
			}
		}

		if(getShoppingList() == null){
			return -1;
		} else {
			return index;
		}
	}


	// TODO: implement fillBagMax()


	// TODO: implement calValue()



	public static void main(String[] args) {
		//you can test your code here by creating your own shopping object
		Item a = new Item("hafer", 1, 8);
		Item b = new Item("salat", 4, 200);
		Item c = new Item("banana", 3, 500);
		Item d = new Item("salat", 4, 2);

		Item[] items = new Item[4];
		items[0] = a;
		items[1] = b;
		items[2] = c;
		items[3] = d;

		Shopping s = new Shopping(items, 10);
		int cool = s.search("hafer");


		System.out.println(cool);
		System.out.println(s.findMin());
		System.out.println(s.findMax());

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
