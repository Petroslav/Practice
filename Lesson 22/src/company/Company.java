package company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

public class Company {
	
	enum Criteria {AGE, NAME, SALARY};
	enum Month {JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER};

	private String name;
	private TreeMap<String, HashSet<Employee>> employees;
//	private static final HashSet<String> deps = new HashSet<>();
//	
//	static{
//		deps.add("Sales");
//		deps.add("Production");
//		deps.add("Superheroes");
//		deps.add("Sanitari");
//	}
	
	public Company(String name) {
		this.name = name;
		employees = new TreeMap<>();
	}
	
	public void addEmployee(String dep, Employee emp){
		//do some magic here
		if(!employees.containsKey(dep)){
			employees.put(dep, new HashSet<>());
		}
		employees.get(dep).add(emp);
	}
	
	public void printAll(Criteria criteria){
		for(Entry<String, HashSet<Employee>> e : employees.entrySet()){
			System.out.println("------Otdel " + e.getKey() + "------");
			HashSet<Employee> set = e.getValue();
			TreeSet<Employee> tree = new TreeSet();
			switch(criteria){
				case NAME:
				tree = new TreeSet<>(new ComparatorByName());
				break;
				case AGE:
				tree = new TreeSet<>(new ComparatorByAge());
				break;
				case SALARY:
				tree = new TreeSet<>(new ComparatorBySalary());
				break;
				default:
					System.out.println("No such criteria. Will now exit.");
					return;
			}
			tree.addAll(set);
			for(Employee emp : tree){
				System.out.println("   - Slujitel: " + emp);
			}
		}
	}
	
	public Map<String, HashSet<Employee>> getEmployees() {
		return Collections.unmodifiableMap(employees);
	}
	
	public void pay(Month month){
		TreeSet<Employee> allEmps = Demo.convertEmps(employees);
		for(Employee e : allEmps){
			e.receiveMoney(month);
		}
	}
	
	public void printSalaries(){
		TreeSet<Employee> allEmps = Demo.convertEmps(employees);
		for (Month m : Month.values()) {
			System.out.println("Month " + m);
			for(Employee e : allEmps){
				e.printSalaries(m);
			}
		}
		System.out.println("=====TOTAL=====");
		for(Employee e : allEmps){
			e.printSalaries();
		}
	}
	
}
