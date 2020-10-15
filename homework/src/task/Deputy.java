package task;

import java.util.Scanner;

public class Deputy extends Human {

	private String surname;
	private String name;
	private int age;
	private boolean bribeTaker;
	private int bribeSize;

	public Deputy(String surname, String name, int age, int height, int weight, boolean bribeTaker) {
		super(weight, height);
		this.surname = surname;
		this.name = name;
		this.age = age;
		this.bribeTaker = bribeTaker;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBribeTaker() {
		return bribeTaker;
	}

	public String bribeTakerToString() {
		if (this.bribeTaker) {
			return "взяточник";
		} else { return "честный человек";
		}
	}
	
	public void setBribeTaker(boolean bribeTaker) {
		this.bribeTaker = bribeTaker;
	}

	public int getBribeSize() {
		return bribeSize;
	}

	public void setBribeSize(int bribeSize) {
		this.bribeSize = bribeSize;
	}

	public void giveBribe() {
		if (this.bribeTaker == false) {
			System.out.println("Shame on you! This deputy is the most honest man, and you are here with your envelope!");
		}

		if (this.bribeTaker == true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the bribe amount:");
			int bribeAmount = scanner.nextInt();

			if (bribeAmount > 5000) {
				System.out.println("NABU employees are already leaving to arrest the bribe!");
			} else {
				this.bribeSize = bribeAmount;
			}
		}
	}

	@Override
	public String toString() {
		return surname + " " + name + ", " + age + " years, growth " + super.getHeight() + " cm, weight " + super.getWeight()
				+ " kg, " + bribeTakerToString();
	}

}
