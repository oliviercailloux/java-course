package io.github.oliviercailloux.teaching_examples;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class Person {

	public static void main(String[] args) {
		List<Person> l = new ArrayList<>();
		l.add(new Person("olivier", new PhoneNumber(33, 6, "…")));

		Iterator<Person> iterator = l.iterator();
		System.out.println("Start: " + iterator.hasNext());
		Person p1 = iterator.next();
		System.out.println(p1.name);

		System.out.println("Next: " + iterator.hasNext());
		Person p2 = iterator.next();
		System.out.println(p2.name);
	}

	/**
	 * Not {@code null}
	 */
	private String name;

	private Optional<PhoneNumber> phoneNumber;

	public Person(String name, PhoneNumber phoneNumber) {
		Preconditions.checkNotNull(name);
		this.name = name;
		if (phoneNumber == null) {
			this.phoneNumber = Optional.empty();
		} else {
			this.phoneNumber = Optional.of(phoneNumber);
		}
	}

	@Override
	public String toString() {
		if (phoneNumber.isPresent()) {
			return name + "\n" + phoneNumber.get().getCountryCode();
		}
		return name;
	}
}
