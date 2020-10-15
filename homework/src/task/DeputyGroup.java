package task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DeputyGroup {

	private String deputyGroupName;

	public DeputyGroup(String deputyGroupName) {
		this.deputyGroupName = deputyGroupName;
	}

	public String getDeputyGroupName() {
		return deputyGroupName;
	}

	public void setDeputyGroupName(String deputyGroupName) {
		this.deputyGroupName = deputyGroupName;
	}

	ArrayList<Deputy> deputyGroupArray = new ArrayList<Deputy>();

	public void addDeputy() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the deputy:");
		String surname = scanner.next();
		System.out.println("Enter the name of the deputy:");
		String name = scanner.next();
		System.out.println("Enter the age of the deputy:");
		int age = scanner.nextInt();
		System.out.println("Enter the height of the deputy:");
		int height = scanner.nextInt();
		System.out.println("Enter Deputy weight:");
		int weight = scanner.nextInt();
		System.out.println("Does the deputy take bribes (true/false):");
		boolean bribeTaker = scanner.nextBoolean();

		Deputy deputy = new Deputy(surname, name, age, height, weight, bribeTaker);

		if (deputy.isBribeTaker()) {
			deputy.giveBribe();
		}

		deputyGroupArray.add(deputy);
		System.out.println("Deputy " + deputy.toString() + " successfully added to the faction!");
	}

	public void removeDeputy() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the deputy:");
		String surname = scanner.next();
		System.out.println("Enter the name of the deputy:");
		String name = scanner.next();

		boolean typeCorrect = isDeputyExists(deputyGroupArray, surname, name);

		if (typeCorrect) {

			Iterator<Deputy> iterator = deputyGroupArray.iterator();

			while (iterator.hasNext()) {
				Deputy nextDeputy = iterator.next();

				if (nextDeputy.getSurname().equalsIgnoreCase(surname) && nextDeputy.getName().equalsIgnoreCase(name)) {
					iterator.remove();
					System.out.println("Deputy " + nextDeputy.toString() + " successfully removed from faction!");
				}
			}

		} else {
			System.out.println("The introduced deputy is not in this faction!");
		}
	}

	public void getBribeTakers() {
		System.out.println("Members of the faction taking bribes:");
		for (Deputy deputy : deputyGroupArray) {
			if (deputy.isBribeTaker()) {
				System.out.println(deputy.toString());
			}
		}
	}

	public void getLargestBribeTaker() {
		int bribeSize = 0;
		int deputyIndex = -1;

		for (int i = 0; i < deputyGroupArray.size(); i++) {
			if (deputyGroupArray.get(i).isBribeTaker()) {
				if (deputyGroupArray.get(i).getBribeSize() > bribeSize) {
					bribeSize = deputyGroupArray.get(i).getBribeSize();
					deputyIndex = deputyGroupArray.indexOf(deputyGroupArray.get(i));
				}
			}
		}

		if (deputyIndex >= 0) {
			System.out.println("The biggest bribe taker of the faction " + deputyGroupArray.get(deputyIndex).toString());
		} else {
			System.out.println("There are no bribe-takers in this batch!");
		}
	}

	public void getAllDeputies() {
		System.out.println("Members of this faction:");
		for (Deputy deputy : deputyGroupArray) {
			System.out.println(deputy.toString());
		}
	}

	public void clearDeputyGroup() {
		deputyGroupArray.clear();
		System.out.println("All MPs have been successfully removed from the faction!");
	}

	static boolean isDeputyExists(ArrayList<Deputy> deputyGroupArray, String surname, String name) {
		boolean flag = false;

		for (Deputy deputy : deputyGroupArray) {
			if (deputy.getSurname().equalsIgnoreCase(surname) && deputy.getName().equalsIgnoreCase(name)) {
				flag = true;
			}
		}

		return flag;
	}

	@Override
	public String toString() {
		return "Fraction \"" + deputyGroupName + "\"";
	}

}