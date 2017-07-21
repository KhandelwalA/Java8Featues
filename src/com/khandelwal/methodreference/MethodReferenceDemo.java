package com.khandelwal.methodreference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import com.khandelwal.lambda.Person;

public class MethodReferenceDemo {

	public static void main(String[] args) {

		List<Person> personList = Arrays.asList(new Person("Abhishek", "Khandelwal", 10),
				new Person("Monika", "Khandelwal", 8), new Person("Dhriti", "Khandelwal", 5),
				new Person("Vijay", "Pant", 12), new Person("Amit", "Widhani", 10));

		printConditionally(personList, p -> p.getLastName().toUpperCase().startsWith("K"), System.out::println);
	}
	/* Above, System.out::println is method reference.*/

	private static void printConditionally(List<Person> personList, Predicate<Person> predicate,
			Consumer<Person> consumer) {
		for (Person person : personList) {
			if (predicate.test(person)) {
				consumer.accept(person);
			}
		}
	}
}