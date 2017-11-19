package company;

import java.util.TreeMap;

import company.Company.Month;

public class Employee {

	private String name;
	private int age;
	private double salary;
	private final int idNumber;
	private static int uniqueId = 1;
	private int bankBalance = 0;
	private TreeMap<Month, Double> salaries;
	
	public Employee(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.idNumber = uniqueId++;
		salaries = new TreeMap<>();
	}
	
	@Override
	public String toString() {
		//return name + "( na "+age+" godini, pribira "+salary+" ot parite na sobstvenika)";
		return name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void receiveMoney(Month month){
		bankBalance+=salary;
		salaries.put(month, salary);
	}

	public void printSalaries(Month m) {
		System.out.println(name + " - " + salaries.get(m));
	}

	public void printSalaries() {
		double all = 0;
		for(Double d : salaries.values()){
			all += d;
		}
		System.out.println(name + " - " + all);
	}

}
