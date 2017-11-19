package Social;

public class Student extends Person {
	
	private double score;
	
	Student(String name, int age, boolean isMale, double score) {
		super(name, age, isMale);
		this.setScore(score);
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		if(score <= 6 || score >= 2){
			this.score = score;
		}else{
			System.out.println("Invalid grade");
		}
	}
	
	void showStudentInfo(){
		super.showPersonInfo();
		System.out.println("Average grade: "+this.getScore());
	}
	
	

	
}
