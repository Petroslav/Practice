package Education;

public class Student {

	String name;
	String subject;
	double grade;
	int yearInCollege;
	int age;
	boolean isDegree;
	double money;
	
	Student(){
		this.grade = 4.0;
		this.yearInCollege = 1;
		this.isDegree = false;
		this.money = 0;
	}
	
	Student(String name, String subject, int age){
		this();
		this.name = name;
		this.subject = subject;
		this. age = age;
	}
	
	void upYear(){
		if(this.yearInCollege < 4){
			this.yearInCollege++;
		}
		if(this.yearInCollege == 4){
			this.isDegree = true;
		}
	}
	
	double receiveScholarship(double min, double amount){
		if(this.grade >= min && this.age < 30){
			this.money+= amount;
		}else{
			System.out.println("Student is ineligible for a scholarship"+ "");
		}
		return this.money;
	}
	
}
