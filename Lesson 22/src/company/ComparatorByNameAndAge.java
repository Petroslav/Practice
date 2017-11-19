package company;

import java.util.Comparator;

public class ComparatorByNameAndAge implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		if(o1.getName().equals(o2.getName())){
			return o1.getAge() - o2.getAge();
		}
		return o1.getName().compareTo(o2.getName());
	}

}
