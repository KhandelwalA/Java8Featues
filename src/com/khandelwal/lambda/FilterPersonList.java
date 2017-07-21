package com.khandelwal.lambda;

import java.util.List;

@FunctionalInterface
public interface FilterPersonList {

	List<Person> filterList (List<Person> PersonList, String lastNameCharacter);
}
