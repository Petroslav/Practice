import java.util.ArrayList;
import java.util.Random;

import clients.Client;
import clients.Student;
import clients.Thug;
import clients.Vegan;
import restaurant.Restaurant;
import restaurant.Waiter;

public class Demo2 {

	public static void main(String[] args) {
		Random rng = new Random();
		
		//1.
		Restaurant pesho = new Restaurant("Pri Pesho Talanta", "Vitoshka dge", 1000);
		Waiter w1 = new Waiter("Lili");
		Waiter w2 = new Waiter("Didi");
		Waiter w3 = new Waiter("Jiji");
		Waiter w4 = new Waiter("Hashi");
		Waiter w5 = new Waiter("Baba");
		
		pesho.hireWaiter(w1, w2, w3, w4, w5);
		
		//2.
		ArrayList<Client> clients = new ArrayList<Client>();
		for (int i = 0; i < 15; i++) {
			int chance = rng.nextInt(100) + 1;
			if(chance > 50) clients.add(new Thug());
			if(chance > 20 && chance <= 50) clients.add(new Student());
			if(chance <= 20) clients.add(new Vegan());
		}
		
		//3.
		pesho.seatClients(clients);
		for(Client x : clients){
			x.makeOrder();
			x.makeOrder();
			x.makeOrder();
			x.requestBill();
			x.payBill();
		}
		
		//4.
		System.out.println(pesho.getCapital());
		
		//5.
		System.out.println(pesho.mostTippedServer());
		
		//6.
		System.out.println(pesho.getStaff());
		
		//7.
		System.out.println("=============");
		pesho.printInventory();
	}
}
