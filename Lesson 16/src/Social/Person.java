package Social;

public class Person {

	private final String NAME;
	private int age;
	private final boolean IS_MALE;
	
	public int getAge() {
		return age;
	}

	public void levelUP(int age) {
		this.age++;
	}

	public String getNAME() {
		return NAME;
	}

	public boolean isMale() {
		return IS_MALE;
	}

	
	Person(String name, int age, boolean IS_MALE){
		this.NAME = name;
		this.age = age;
		this.IS_MALE = IS_MALE;
	}
	
	void showPersonInfo(){
		System.out.println(this.getNAME()+" is "+(this.IS_MALE ? "male and " : "female and ")+this.getAge()+" years old");
	}
	
	
}
