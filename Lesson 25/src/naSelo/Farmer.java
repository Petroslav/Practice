package naSelo;

import java.util.ArrayList;

public class Farmer {

	private String name;
	private int age = 0;
	private Brain mozuk;
	
	public Farmer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		this.mozuk = new Brain();
	}
	
	class Brain{
		private int cells = 100000000;
		private int age = 4;
		
		Brain(){
			age = 0;
			Farmer.this.age = 4;
		}
	}
	
	public void growUp(){
		age++;
		mozuk.cells-=50000;
	}
	
	public void harvest(){
		
		class Wheat extends Plant{
			private int foodValue = 100;
			
			@Override
			public String toString() {
				return "Wheat with food value = " + foodValue;
			}
		}
		ArrayList<Harvestable> ojunato = new ArrayList<Harvestable>();
		ojunato.add(new Wheat());
		ojunato.add(new Wheat());
		ojunato.add(new Success());
		ojunato.add(new Weed());
		ojunato.add(new Wheat());
		ojunato.add(new Weed());
		ojunato.add(new Wheat());
				
		ojunato.add(new Weed(){
			@Override
			public String toString() {
				return "secret weed - gluharche";
			}
		});
		
		
		ojunato.add(new Weed(){
			@Override
			public String toString() {
				return "golden ivy";
			}
		});
		
		Harvestable guba = new Harvestable() {
						
		};
		
		ojunato.add(guba);
		
		ojunato.add(new Wheat());
		ojunato.add(new Weed());
		ojunato.add(new Wheat());
		
		for(Harvestable h : ojunato){
			System.out.println(h);
		}
	}
}
