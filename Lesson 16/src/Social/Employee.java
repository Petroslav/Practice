package Social;

public class Employee extends Person {
	
	private double salary;
	
	Employee(String name, int age, boolean isMale, double salary) {
		super(name, age, isMale);
		this.setSalary(salary);
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		if(salary > 0){
			this.salary = salary;
		}
	}
	
	public void showEmployeeInfo(){
		this.showPersonInfo();
		System.out.println("Hourly pay: "+this.getSalary());
	}
	
	public double calculateOvertime(double hours){
		
		if(this.getAge() < 18){
			return 0;
		}else{
			return (hours*this.getSalary())*1.5;
		}
	}
	
	

}
