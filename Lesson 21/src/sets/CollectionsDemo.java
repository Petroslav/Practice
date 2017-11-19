package sets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class CollectionsDemo {

	public static void main(String[] args) {
		

		Person tedi = new Person("Tedi", 15, false);
		Person doni = new Person("Doni", 15, false);
		Person boni = new Person("Boni", 28, true);
		Person tanya = new Person("Tanq", 16, false);
		Person katya = new Person("Katq", 21, false);
		Person bobi = new Person("Bobi", 17, true);
		
//		ArrayList<Person> list = new ArrayList<Person>();
//		list.add(katya);
//		list.add(doni);
//		list.add(boni);
//		list.add(tanya);
//
//		System.out.println(list);
		
		HashSet<Person> hahaset = new HashSet<Person>();
		hahaset.add(tedi);
		hahaset.add(doni);
		hahaset.add(boni);
		hahaset.add(tanya);
		hahaset.add(katya);
		hahaset.add(bobi);
		
		
		
		for(Iterator<Person> it = hahaset.iterator(); it.hasNext();){
			Person test = it.next();
			if(it.next().getAge() > 18) continue;
			else System.out.println(test.getName());
		}
//		
//		for(int i = 0; i < list.size(); i++){
//			System.out.println(list.get(i));
//		}
//		System.out.println("-------------");
//		for(Iterator<Person> it = list.iterator(); it.hasNext();){
//			System.out.println(it.next());
//		}
//		
//		TreeSet<Person> set = new TreeSet<Person>();
//		set.add(katya);
//		set.add(doni);
//		set.add(boni);
//		System.out.println(set);
		
		
	}
}
