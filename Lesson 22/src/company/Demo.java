package company;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import company.Company.Month;

public class Demo {

	public static void main(String[] args) {
		
		Company reaverLtd = new Company("Reaver Ltd");
		
		Employee tancho = new Employee("Tancho", 38, 3500);
		Employee ivet = new Employee("Ivet", 25, 1600);
		Employee liubo = new Employee("Liubo", 28, 1300);
		Employee katya = new Employee("Katya", 21, 700);
		Employee pesho = new Employee("Pesho", 27, 730);
		
		reaverLtd.addEmployee("Sales", ivet);
		reaverLtd.addEmployee("Sales", katya);
		reaverLtd.addEmployee("Sanitari", liubo);
		reaverLtd.addEmployee("Ailyak", tancho);
		reaverLtd.addEmployee("Ailyak", pesho);
		
		reaverLtd.printAll(Company.Criteria.AGE);
		System.out.println(convertEmps(reaverLtd.getEmployees()));
		
		System.out.println(removeDups(convertEmps(reaverLtd.getEmployees())));
		
		for(Month m : Month.values()){
			reaverLtd.pay(m);
		}
		
		reaverLtd.printSalaries();
	}
	
	public static TreeSet<Employee> removeDups(TreeSet<Employee> emps){
		TreeSet<Employee> set = new TreeSet<>(new ComparatorByNameAndAge());
		//do some black magic;
		set.addAll(emps);
		return set;
	}
	
	public static TreeSet<Employee> convertEmps(Map<String, HashSet<Employee>> emps){
		TreeSet<Employee> set = new TreeSet<>(new ComparatorByName());
		//do some black magic;
		for(HashSet<Employee> e : emps.values()){
			set.addAll(e);
		}
		return set;
	}
}
