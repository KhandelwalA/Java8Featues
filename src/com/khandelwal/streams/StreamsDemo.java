package com.khandelwal.streams;

import java.util.Arrays;
import java.util.List;

import com.khandelwal.lambda.Person;

public class StreamsDemo {

	public static void main(String[] args) {

		List<Person> personList = Arrays.asList(new Person("Abhishek", "Khandelwal", 10),
				new Person("Monika", "Khandelwal", 8), new Person("Dhriti", "Khandelwal", 5),
				new Person("Vijay", "Pant", 12), new Person("Amit", "Widhani", 10));

		/*Stream on collection*/
		personList.stream().
		filter(p -> p.getLastName().startsWith("K")).
		forEach(p -> System.out.println(p));

		/* Parallel processing stream*/
		long count = personList.parallelStream().
					 filter(p -> p.getFirstName().
					 startsWith("A")).count();

		System.out.println(count);
	}

}
