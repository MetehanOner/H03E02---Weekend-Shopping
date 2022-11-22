package de.tum.in.ase;


import java.util.Arrays;
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

		if(getShoppingList()==null) {
			return -1;
		}

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
		if(getShoppingList()==null){
			return -1;
		}

		Item result = getShoppingList()[0];
		int index = 0;
		for (int i = 1; i < getShoppingList().length; i++) {
			if(!(getShoppingList()[i] ==null)){
				if (getShoppingList()[i].getValue() < result.getValue()) {
					result = getShoppingList()[i];
					index = i;
				}
			}
		}

		return index;

	}

	// TODO: implement findMax()
	public int findMax(){
		if(getShoppingList() == null){
			return -1;
		}

		Item result = getShoppingList()[0];
		int index = 0;
		for (int i = 1; i < getShoppingList().length; i++) {
			if(!(getShoppingList()[i] == null)) {
				if (getShoppingList()[i].getValue() > result.getValue()) {
					result = getShoppingList()[i];
					index = i;
				}
			}
		}

		return index;

	}


	// TODO: implement fillBagMax()
	public Item[] fillBagMax(){

		if (getShoppingList() == null) {
			return null;
		}

		int nullCounter = 0;
		for(int i=0; i < getShoppingList().length; i++) {
			if(getShoppingList()[i] == null) {
				nullCounter++;
			}
		}

		Item[] copy = new Item[getShoppingList().length-nullCounter];

		int currentBagCapacity = getBagCapacity();

		for(int i=0; i < getShoppingList().length; i++){
			if(!(getShoppingList()[i] == null)){

				int currentItemValue = getShoppingList()[i].getValue();

				if(getShoppingList()[i].getWeight() <= currentBagCapacity){

					int j = 0;
					while (j < i && currentItemValue > copy[j].getValue()) {
						j++;
					}

					for (int k = i - 1; k >= j; k--) {
						copy[k + 1] = copy[k];
					}

					copy[j] = getShoppingList()[i];
					currentBagCapacity = currentBagCapacity - copy[j].getWeight();
				}

			}
		}

		return copy;
	}



	// TODO: implement calValue()
	public int calValue(){

		if(getShoppingList()==null){
			return 0;
		}

		Item[] newList = fillBagMax();

		if (!(newList==null)) {
			int totalValue = 0;
			for(int i=0; i < newList.length; i++){
				if(!(newList[i] == null)){
					totalValue = totalValue + newList[i].getValue();
				}
			}
			return totalValue;
		}
		return 0;

	}


	public static void main(String[] args) {
		//you can test your code here by creating your own shopping object
		Item a = new Item("hafer", 10, 8);
		Item b = new Item("salat", 3, 7);
		Item c = new Item("banana", 5, 4);
		Item d = new Item("tomato", 6, 1);
		Item e = new Item("timber", 6, 5);

		Item[] items = new Item[10];
		items[0] = a;
		items[3] = c;
		items[6] = d;
		items[7] = b;
		items[9] = e;

		Shopping s = new Shopping(items, 10);
		int cool = s.search("hafer");


		System.out.println(cool);
		System.out.println(s.findMin());
		System.out.println(s.findMax());
		System.out.println(s.calValue());

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
