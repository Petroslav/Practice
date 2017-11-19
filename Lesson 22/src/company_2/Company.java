package company_2;

import java.util.*;
import java.util.Map.Entry;

public class Company {

	private String name;
	private HashMap<String, ArrayList<Employee>> staff;
	
	public Company(String name) {
		this.name = name;
		this.staff = new HashMap<String, ArrayList<Employee>>();
	}
	
	public void hireEmployee(Employee e){
		if(this.staff.get(e.getDepartment()) == null){
			this.staff.put(e.getDepartment(), new ArrayList<Employee>());
		}
		this.staff.get(e.getDepartment()).add(e);
	}
	
	public HashMap<String, ArrayList<Employee>> getStaff() {
		return staff;
	}
	
	public HashMap<String, ArrayList<Employee>> getStaffByAge() {
		for(Entry<String, ArrayList<Employee>> it : this.staff.entrySet()){
			Collections.sort(it.getValue(), new AgeComparator());
		}
		return staff;
	}
	
	public HashMap<String, ArrayList<Employee>> getStaffBySalary() {
		for(Entry<String, ArrayList<Employee>> it : this.staff.entrySet()){
			Collections.sort(it.getValue(), new SalaryComparator());
		}
		return staff;
	}
	
	public HashMap<String, ArrayList<Employee>> getStaffByName() {
		for(Entry<String, ArrayList<Employee>> it : this.staff.entrySet()){
			Collections.sort(it.getValue(), new NameComparator());
		}
		return staff;
	}
	
	
}
