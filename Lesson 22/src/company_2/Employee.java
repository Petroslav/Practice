package company_2;

public class Employee {

	private String name;
	private int age;
	private double salary;
	private int id;
	private String department;
	
	public Employee(String name, int age, double salary, int id, String dpt) {
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.id = id;
		this.department = dpt;
	}
	
	public String getDepartment() {
		return department;
	}

	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if(this.name.equals(other.getName()) && this.age == other.getAge()) 
			return true;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
