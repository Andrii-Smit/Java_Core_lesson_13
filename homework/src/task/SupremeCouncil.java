package task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public final class SupremeCouncil {

	private static SupremeCouncil instance = new SupremeCouncil();

	private SupremeCouncil() {
	}

	public static SupremeCouncil getInstance() {
		if (instance == null) {
			instance = new SupremeCouncil();
		}

		return instance;
	}

	
	ArrayList<DeputyGroup> supremeCouncilArray = new ArrayList<DeputyGroup>();

	public void addDeputyGroup() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the faction:");
		String deputyGroupName = scanner.next();

		DeputyGroup deputyGroup = new DeputyGroup(deputyGroupName);

		supremeCouncilArray.add(deputyGroup);
		System.out.println(deputyGroup.toString() + " successfully added to the Verkhovna Rada!");
	}

	public void removeDeputyGroup() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the faction:");
		String deputyGroupName = scanner.next();

		boolean typeCorrect = isDeputyGroupExists(supremeCouncilArray, deputyGroupName);

		if (typeCorrect) {

			Iterator<DeputyGroup> iterator = supremeCouncilArray.iterator();

			while (iterator.hasNext()) {
				DeputyGroup nextDeputyGroup = iterator.next();

				if (nextDeputyGroup.getDeputyGroupName().equalsIgnoreCase(deputyGroupName)) {
					iterator.remove();
					System.out.println(nextDeputyGroup.toString() + " successfully removed from the Verkhovna Rada!");
				}
			}

		} else {
			System.out.println("There is no faction introduced in the Verkhovna Rada!");
		}
	}

	public void getAllDeputyGroups() {
		System.out.println("Factions registered in Verkhovna Rada:");
		for (DeputyGroup deputyGroup : supremeCouncilArray) {
			System.out.println(deputyGroup.toString());
		}
	}

	public void clearDeputyGroup() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the faction:");
		String deputyGroupName = scanner.next();

		boolean typeCorrect = isDeputyGroupExists(supremeCouncilArray, deputyGroupName);

		if (typeCorrect) {
			for (DeputyGroup deputyGroup : supremeCouncilArray) {
				if (deputyGroup.getDeputyGroupName().equalsIgnoreCase(deputyGroupName)) {
					deputyGroup.clearDeputyGroup();
				}
			}

		} else {
			System.out.println("There is no faction introduced in the Verkhovna Rada!");
		}
	}

	public void getDeputyGroup() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the faction:");
		String deputyGroupName = scanner.next();

		for (DeputyGroup deputyGroup : supremeCouncilArray) {
			if (deputyGroup.getDeputyGroupName().equalsIgnoreCase(deputyGroupName)) {
				System.out.println(deputyGroup.toString());
				deputyGroup.getAllDeputies();
			}
		}
	}

	public void addDeputyToDeputyGroup() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the faction:");
		String deputyGroupName = scanner.next();

		boolean typeCorrect = isDeputyGroupExists(supremeCouncilArray, deputyGroupName);

		if (typeCorrect) {
			for (DeputyGroup deputyGroup : supremeCouncilArray) {
				if (deputyGroup.getDeputyGroupName().equalsIgnoreCase(deputyGroupName)) {
					deputyGroup.addDeputy();
				}
			}

		} else {
			System.out.println("There is no faction introduced in the Verkhovna Rada!");
		}
	}
	
	public void removeDeputyFromDeputyGroup() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the faction:");
		String deputyGroupName = scanner.next();

		boolean typeCorrect = isDeputyGroupExists(supremeCouncilArray, deputyGroupName);

		if (typeCorrect) {
			for (DeputyGroup deputyGroup : supremeCouncilArray) {
				if (deputyGroup.getDeputyGroupName().equalsIgnoreCase(deputyGroupName)) {
					deputyGroup.removeDeputy();
				}
			}

		} else {
			System.out.println("There is no faction introduced in the Verkhovna Rada!");
		}
	}
	
	public void getBribeTakersFromDeputyGroup() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the faction:");
		String deputyGroupName = scanner.next();

		boolean typeCorrect = isDeputyGroupExists(supremeCouncilArray, deputyGroupName);

		if (typeCorrect) {
			for (DeputyGroup deputyGroup : supremeCouncilArray) {
				if (deputyGroup.getDeputyGroupName().equalsIgnoreCase(deputyGroupName)) {
					deputyGroup.getBribeTakers();
				}
			}

		} else {
			System.out.println("There is no faction introduced in the Verkhovna Rada!");
		}
	}
	
	public void getLargestBribeTakerFromDeputyGroup() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the faction:");
		String deputyGroupName = scanner.next();

		boolean typeCorrect = isDeputyGroupExists(supremeCouncilArray, deputyGroupName);

		if (typeCorrect) {
			for (DeputyGroup deputyGroup : supremeCouncilArray) {
				if (deputyGroup.getDeputyGroupName().equalsIgnoreCase(deputyGroupName)) {
					deputyGroup.getLargestBribeTaker();
				}
			}

		} else {
			System.out.println("There is no faction introduced in the Verkhovna Rada!");
		}
	}
	
	public void getAllDeputiesFromDeputyGroup() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the faction:");
		String deputyGroupName = scanner.next();

		boolean typeCorrect = isDeputyGroupExists(supremeCouncilArray, deputyGroupName);

		if (typeCorrect) {
			for (DeputyGroup deputyGroup : supremeCouncilArray) {
				if (deputyGroup.getDeputyGroupName().equalsIgnoreCase(deputyGroupName)) {
					deputyGroup.getAllDeputies();;
				}
			}

		} else {
			System.out.println("There is no faction introduced in the Verkhovna Rada!");
		}
	}
	
	static boolean isDeputyGroupExists(ArrayList<DeputyGroup> supremeCouncilArray, String deputyGroupName) {
		boolean flag = false;

		for (DeputyGroup deputyGroup : supremeCouncilArray) {
			if (deputyGroup.getDeputyGroupName().equalsIgnoreCase(deputyGroupName)) {
				flag = true;
			}
		}

		return flag;
	}

}

