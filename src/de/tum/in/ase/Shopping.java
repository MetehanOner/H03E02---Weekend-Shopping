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

		Item itemHolder = new Item("null",1,0);
		Item[] copy = new Item[getShoppingList().length];

		for(int z=0; z < copy.length; z++) {
			copy[z] = itemHolder;
		}

		for(int i=0; i < getShoppingList().length; i++){
			if(!(getShoppingList()[i] == null)){

				int currentRatio = (getShoppingList()[i].getValue())/(getShoppingList()[i].getWeight());

				int j = 0;
				while (j < i && currentRatio < (copy[j].getValue())/(copy[j].getWeight())) {
					j++;
				}

				for (int k = i - 1; k >= j; k--) {
					copy[k + 1] = copy[k];
				}

				copy[j] = getShoppingList()[i];

			} else {
				getShoppingList()[i] = itemHolder;
			}
		}

		int r = 0;
		boolean found = false;

		while (!found && r < copy.length) {
			String a = copy[r].getName().toLowerCase().replaceAll("\\s+", "");
			String b = "null".toLowerCase().replaceAll("\\s+", "");
			found = Objects.equals(a ,b);
			r++;
		}

		int firstNull = r-1;
		Item[] modifiedArray = Arrays.copyOfRange(copy, 0, firstNull);
		Item[] newFoundLand = new Item[modifiedArray.length];


		for(int p=0; p < newFoundLand.length; p++) {
			newFoundLand[p] = itemHolder;
		}

		int currentBagCapacity = getBagCapacity();
		for(int i=0; i < modifiedArray.length; i++){
				if(currentBagCapacity > modifiedArray[i].getWeight()){
					newFoundLand[i] = modifiedArray[i];
					currentBagCapacity = currentBagCapacity - newFoundLand[i].getWeight();
				}
		}

		int o = 0;
		boolean evreka = false;

		while (!evreka && o < newFoundLand.length) {
			String a = newFoundLand[o].getName().toLowerCase().replaceAll("\\s+", "");
			String b = "null".toLowerCase().replaceAll("\\s+", "");
			evreka = Objects.equals(a ,b);
			o++;
		}

		int partyNull = o-1;

		return Arrays.copyOfRange(newFoundLand, 0, partyNull);
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
