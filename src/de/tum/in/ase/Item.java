package de.tum.in.ase;

public class Item {
	private String name;
	private int weight;
	private int value;

	public Item(String name, int weight, int value) {

		if (name == null){
			setName("null");
		} else {
			setName(name);
		}

		setWeight(weight);
		setValue(value);
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	public int getValue() {
		return value;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
