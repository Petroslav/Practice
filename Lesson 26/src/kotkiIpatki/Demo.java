package kotkiIpatki;

import java.util.Comparator;
import java.util.TreeSet;

public class Demo {

	public static void main(String[] args) {
		
		putCats(new CatComparatorByAge());
		putCats((o1, o2) ->   o1.getName().compareTo(o2.getName())	 			);
		putCats((o1, o2) ->   o1.getMustacheLength() - o2.getMustacheLength()  	);
		putCats((o1, o2) ->   o1.getColor().compareTo(o2.getColor())  			);
	}
	
	private static void putCats(Comparator<Cat> comp){
		System.out.println("----------------------");
		Cat pisi1 = new Cat("Pesho", 4, "brown", 16);
		Cat pisi2 = new Cat("Gosho", 3, "orange", 11);
		Cat pisi3 = new Cat("Minka", 8, "black", 14);
		Cat pisi4 = new Cat("Pisana", 14, "white", 12);
		Cat pisi5 = new Cat("Maca", 11, "red", 22);
		
		TreeSet<Cat> kotkiPoAge = new TreeSet<Cat>(comp);
		kotkiPoAge.add(pisi1);
		kotkiPoAge.add(pisi2);
		kotkiPoAge.add(pisi3);
		kotkiPoAge.add(pisi4);
		kotkiPoAge.add(pisi5);
		
		for (Cat cat : kotkiPoAge) {
			System.out.println(cat);
		}
	}
}
