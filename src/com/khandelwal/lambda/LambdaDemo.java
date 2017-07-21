package com.khandelwal.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaDemo {

	public static void main(String[] args) {

		List<Person> personList = Arrays.asList(new Person("Abhishek", "Khandelwal", 10),
				new Person("Monika", "Khandelwal", 8), new Person("Dhriti", "Khandelwal", 5),
				new Person("Vijay", "Pant", 12), new Person("Amit", "Widhani", 10));

		// Sort list by person's last name
		Collections.sort(personList, (p1, p2) -> p1.getFirstName().compareToIgnoreCase(p2.getFirstName()));

		// Lambda expression to prints all elements in list
		PersonList lambdaPrintAllPassenger = (List<Person> persons) -> {
			for (Person person : persons) {
				System.out.println(person.toString());
			}
		};
		// Executing lambda expression
		lambdaPrintAllPassenger.printAllPassenger(personList);

		/*
		 * Option 1, wherein we create a lambda expression & use Custom
		 * Functional interface & execute it
		 */
		// Lambda expression for List of persons whose last name starts with
		// {character}
		FilterPersonList lambdaFilteredListbyLastName = (List<Person> persons, String lastNameCharacter) -> {
			List<Person> filteredList = new ArrayList<Person>();
			for (Person person : persons) {
				if (person.getLastName().toUpperCase().startsWith(lastNameCharacter.toUpperCase())) {
					filteredList.add(person);
				}
			}
			return filteredList;
		};
		// Executing lambda expression
		System.out.println("Using custom Functional interface"
				+ lambdaFilteredListbyLastName.filterList(personList, "k"));

		/*
		 * Option 2, wherein we create a lambda expression & use java provided
		 * functional interfaces Predicate and Consumer & execute them
		 */
		printConditionally(personList, p -> p.getLastName().toUpperCase().startsWith("K"),
				p -> System.out.println("Using Preicate:" + p));
	}

	private static void printConditionally(List<Person> personList, Predicate<Person> predicate,
			Consumer<Person> consumer) {
		for (Person person : personList) {
			if (predicate.test(person)) {
				consumer.accept(person);
			}
		}
	}
}
