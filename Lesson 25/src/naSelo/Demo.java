package naSelo;

import java.util.Comparator;
import java.util.TreeSet;

import naSelo.Farmer.Brain;

public class Demo {

	public static void main(String[] args) throws Exception {
		
		//na nivata
		
//		Farmer stavri = new Farmer("Stavri", 54);
//		stavri.harvest();
		
		class HPComparator implements Comparator<Tractor>{

			@Override
			public int compare(Tractor o1, Tractor o2) {
				return o1.getHp() - o2.getHp();
			}
		}
		
		Tractor tractor1 = new Tractor(123, "Lambo");
		Tractor tractor2 = new Tractor(345, "Volvo");
		Tractor tractor3 = new Tractor(185, "Bulgar");
		Tractor tractor4 = new Tractor(99, "Madara");
		Tractor tractor5 = new Tractor(411, "Bulgar2");
		TreeSet<Tractor> tkzs = new TreeSet<>(new HPComparator());
		tkzs.add(tractor1);		
		tkzs.add(tractor2);		
		tkzs.add(tractor3);		
		tkzs.add(tractor4);		
		tkzs.add(tractor5);	

		TreeSet<Tractor> tkzs2 = new TreeSet<>((o1, o2) ->o1.getModel().compareTo(o2.getModel()));
		
		tkzs2.addAll(tkzs);
		
		for(Tractor t : tkzs){
			System.out.println(t);
		}
		System.out.println("------------");
		for(Tractor t : tkzs2){
			System.out.println(t);
		}
	}
}
