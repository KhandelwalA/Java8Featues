package com.khandelwal.foreachloop;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.khandelwal.lambda.Person;

public class ForEachLoopDemo {

	public static void main(String[] args) {

		List<Person> personList = Arrays.asList(new Person("Abhishek", "Khandelwal", 10),
				new Person("Monika", "Khandelwal", 8), new Person("Dhriti", "Khandelwal", 5),
				new Person("Vijay", "Pant", 12), new Person("Amit", "Widhani", 10));

	/**Traditional way of looping collection. 
	 * This is external iterator over collection which runs sequentially
	 */
		for(int i=0; i<personList.size(); i++) {
			System.out.println("External iterator using index:"+personList.get(i));
		}
		
		/**Another Traditional way of looping collection. 
		 * This is external iterator over collection which runs sequentially
		 */
		for(Person p: personList) {
			System.out.println("External iterator using for in:"+p);
		}
		
		/**New way of looping collection, introduced with java 8. 
		 * This is internal iterator over collection which can runs parallel supporting parallel processing 
		 */
		//Via lamda expression
		personList.forEach(p->System.out.println("internal iterator using lamda:"+p));
		
		/**New way of looping collection, introduced with java 8. 
		 * This is internal iterator over collection which can runs parallel supporting parallel processing 
		 */
		//Via method reference
		personList.forEach(System.out::println);
	}	
}