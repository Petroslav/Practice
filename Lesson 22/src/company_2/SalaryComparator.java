package company_2;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return (int)o1.getSalary() - (int)o2.getSalary();
	}

}
