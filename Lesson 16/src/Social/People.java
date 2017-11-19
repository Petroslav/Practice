package Social;

public class People {

	public static void main(String[] args) {
		
		Person[] ppl = new Person[10];
		Person pesho = new Person("Pesho", 19, true);
		addPerson(pesho, ppl);
		Person luba = new Person("Luba", 23, false);
		addPerson(luba, ppl);
		Student lili = new Student("Lili", 12, false, 5.54);
		Employee gosho = new Employee("Gosho", 41, true, 2.12);
		Student blyat = new Student("Blyatka", 21, false, 6);
		Employee kushka = new Employee("Kushka", 63, false, 4.25);
		addPerson(lili, ppl);
		addPerson(gosho, ppl);
		addPerson(blyat, ppl);
		addPerson(kushka, ppl);
		
		for (int i = 0; i < ppl.length; i++) {
			if(ppl[i] == null) break;
					
			if(ppl[i] instanceof Employee){
				((Employee) ppl[i]).showEmployeeInfo();
				double pay = ((Employee) ppl[i]).calculateOvertime(2);
				System.out.println("Overtime pay: " + pay);
			}
			if(ppl[i] instanceof Student){
				((Student) ppl[i]).showStudentInfo();
			}
			if(!(ppl[i] instanceof Employee) && !(ppl[i] instanceof Student)){
				ppl[i].showPersonInfo();
			}

			
		}
				
	}
	
	static void addPerson(Person person, Person[] ppl){
		
		for (int i = 0; i < ppl.length; i++) {
			if(ppl[i] == null){
				ppl[i] = person;
				break;
			}
		}
	}
}
