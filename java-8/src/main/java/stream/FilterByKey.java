package stream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class FilterByKey {

	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
		Set<Object> seen = ConcurrentHashMap.newKeySet();
		return t -> seen.add(keyExtractor.apply(t));
	}

	public static void main(String[] args) {

		// https://stackoverflow.com/questions/23699371/java-8-distinct-by-property

		List<Persons> list = new ArrayList<>();
		Persons p1 = new Persons("A", 12);
		list.add(p1);
		Persons p2 = new Persons("B", 13);
		list.add(p2);
		Persons p3 = new Persons("C", 14);
		list.add(p3);
		Persons p4 = new Persons("D", 12);
		list.add(p4);
		Persons p5 = new Persons("A", 12);
		list.add(p5);

		// Consumer<Persons> action = p -> System.out.println(p.toString());

		List<Persons> filterByName = list.stream() //
				.filter(distinctByKey(Persons::getName)) //
				.collect(Collectors.toList());
		System.out.println(filterByName.size());
		// filterByName.forEach(action);

		List<Persons> filterByAge = list.stream() //
				.filter(distinctByKey(Persons::getAge)) //
				.collect(Collectors.toList());
		System.out.println(filterByAge.size());
		// filterByAge.forEach(action);

		// cach 2
		Set<String> set = new HashSet<>(list.size());
		int x = list.stream() //
				.filter(p -> set.add(p.getName())) //
				.collect(Collectors.toList()).size();
		System.out.println(x);
	}

}

class Persons {

	private String name;
	private int age;

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

	public Persons() {
	}

	public Persons(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}