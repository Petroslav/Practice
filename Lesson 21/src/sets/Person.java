package sets;

public class Person implements Comparable<Person>{

	private String name;
	private int age;
	private boolean virgin;
	
	public Person(String name, int age, boolean virgin) {
		this.name = name;
		this.age = age;
		this.virgin = virgin;
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return name;
	}
		
	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Person o) {
		return this.name.compareTo(o.name);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (virgin ? 1231 : 1237);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		Person p = (Person)obj;
		return name.equals(p.getName());
	}

	
	
	
	
	
	
}
