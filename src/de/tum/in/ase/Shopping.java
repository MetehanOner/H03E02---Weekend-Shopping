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
			if(!(getShoppingList()[i] == null)) {
				String a = getShoppingList()[i].getName().toLowerCase().replaceAll("\\s+", "");
				String b = itemName.toLowerCase().replaceAll("\\s+", "");
				found = Objects.equals(a, b);
				i++;
			} else {
				i++;
			}
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

		Item result = null;
		for (int i = 0; i < getShoppingList().length; i++) {
			if (!(getShoppingList()[i] == null)) {
				result = getShoppingList()[i];
				break;
			}
		}

		int index = 0;
		for (int i = 1; i < getShoppingList().length; i++) {
			if(!(getShoppingList()[i] == null)){
				assert result != null;
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

		Item result = null;
		for (int i = 0; i < getShoppingList().length; i++) {
			if (!(getShoppingList()[i] == null)) {
				result = getShoppingList()[i];
				break;
			}
		}


		int index = 0;
		for (int i = 1; i < getShoppingList().length; i++) {
			if(!(getShoppingList()[i] == null)) {
				assert result != null;
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

		Item[] copy = new Item[getShoppingList().length];
		Item itemHolder = new Item("null",9999999,0);

		for(int z=0; z < copy.length; z++) {
			copy[z] = itemHolder;
		}

		int currentBagCapacity = getBagCapacity();

		for(int i=0; i < getShoppingList().length; i++) {
			if(!(getShoppingList()[i] == null)) {

				int currentItemValue = getShoppingList()[i].getValue();

				//if(currentBagCapacity >= getShoppingList()[i].getWeight()) {

					int j = 0;
					while (j < i && currentItemValue < copy[j].getValue()) {
						j++;
					}

					for (int k = i - 1; k >= j; k--) {
						copy[k + 1] = copy[k];
					}

					copy[j] = getShoppingList()[i];
					//currentBagCapacity = currentBagCapacity - copy[j].getWeight();

				//}
			}
		}

		int nullCounter = 0;
		for(int i=0; i < copy.length; i++) {
			if(copy[i].getName() == "null") {
				nullCounter++;
			}
		}

		Item[] master = new Item[copy.length-nullCounter];

		for(int y=0; y < master.length; y++) {
			master[y] = itemHolder;
		}

		for(int c=0; c < copy.length; c++) {
			if(currentBagCapacity >= copy[c].getWeight()) {
				master[c] = copy[c];
				currentBagCapacity = currentBagCapacity - copy[c].getWeight();
			}
		}

		int o = 0;
		boolean evreka = false;

		while (!evreka && o < master.length) {
			String a = master[o].getName().toLowerCase().replaceAll("\\s+", "");
			String b = "null".toLowerCase().replaceAll("\\s+", "");
			evreka = Objects.equals(a ,b);
			o++;
		}

		int partyNull = o-1;

		return Arrays.copyOfRange(master, 0, partyNull);
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
		items[7] = a;
		items[8] = c;
		items[9] = d;
		items[5] = b;
		items[6] = e;

		Shopping s = new Shopping(items, 10);
		int cool = s.search("hafer");

		System.out.println(cool);
		System.out.println(s.findMin());
		System.out.println(s.findMax());
		System.out.println(s.fillBagMax());
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
