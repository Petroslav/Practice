package sets;

import java.util.TreeMap;
import java.util.TreeSet;

public class SetsExample {

	public static void main(String[] args) {

		Person tedi = new Person("Tedi", 15);
		Person doni = new Person("Doni", 15);
		Person boni = new Person("Boni", 28);
		Person tanya = new Person("Tanq", 16);
		Person katya = new Person("Katq", 21);
		Person bobi = new Person("Bobi", 17);
		
		TreeSet<Person> tree = new TreeSet<Person>();
		tree.add(katya);
		tree.add(doni);
		tree.add(boni);
		tree.add(bobi);
		tree.add(tedi);
		tree.add(tanya);
		System.out.println(tree);
		
		TreeMap<String, Person> people = new TreeMap<String, Person>();
		people.put(tedi.getName(), tedi);
		people.put(boni.getName(), boni);
		people.put(tanya.getName(), tanya);
		people.put(bobi.getName(), bobi);
		System.out.println(people);
		System.out.println(people.get(tedi.getName()).getAge());
	}
}
