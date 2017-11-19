package Education;

public class StudentGroup {

	String groupSubject;
	Student[] students;
	int freePlaces;
	
	StudentGroup(){
		this.students = new Student[5];
		this.freePlaces = 5;
	}
	
	StudentGroup(String subject){
		this();
		this.groupSubject = subject;
	}
	
	void addStudent(Student s){
		if(this.groupSubject.length() == s.subject.length() && this.groupSubject.contains(s.subject)){
			for (int i = 0; i < students.length; i++) {
				if(this.students[i] == null){
					this.students[i] = s;
					this.freePlaces--;
					break;
				}
			}
		}else{
			System.out.println("Student's subject and group subject do not match");
		}
		
	}
	
	void emptyGroup(){
		for (int i = 0; i < students.length; i++) {
			this.students[i] = null;
		}
		this.freePlaces = this.students.length;
	}
	
	String bestStudent(){
		double max = 0.0;
		int index = 0;
		for (int i = 0; i < students.length; i++) {
			if(this.students[i].grade > max){
				max = this.students[i].grade;
				index = i;
			}
		}
		return this.students[index].name;
	}
	
	void printStudentsInGroup(){
		for (int i = 0; i < students.length; i++) {
			System.out.println("=====");
			System.out.println("Name: "+this.students[i].name);
			System.out.println("Grade: "+this.students[i].grade);
			System.out.println("Subject: "+this.students[i].subject);
			System.out.println("Year: "+this.students[i].yearInCollege);
			
		}
	}
}
