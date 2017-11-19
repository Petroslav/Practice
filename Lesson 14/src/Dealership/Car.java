package Dealership;

public class Car {

	String brand;
	String model;
	int maxSpeed;
	int currentSpeed;
	String color;
	int currentGear;
	Person owner;
	int maxGear = 5;
	double price;
	boolean isSportsCar;
	
	Car(String modelParam, boolean isSportsCarParam){
		model = modelParam;
		isSportsCar = isSportsCarParam;
		currentGear = 1;
		currentSpeed = 0;
	}
	
	void accelerate(){
		if(currentSpeed < maxSpeed){
			currentSpeed++;
		}
	}
	
	void changeGearUp(){
		if(currentGear < maxGear){
			currentGear++;
		}
	}
	
	void changeGearDown(){
		if(currentGear > 1){
			currentGear--;
		}
	}
	
	void changeGear(int nextGear){
		if(nextGear >=1 && nextGear <= maxGear){
			currentGear = nextGear;
		}
	}
	
	void changeColor(String newColor){
		color = newColor;
	}
}
