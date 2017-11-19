package Dealership;

public class Person {

	String name;
	int age;
	String sex;
	double weight;
	Person friend;
	int health;
	int hunger;
	int mentality;
	
	void eat(){
		hunger--;
	}
	
	void heal(){
		health++;
	}
	
}