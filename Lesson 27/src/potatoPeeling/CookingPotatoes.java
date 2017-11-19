package potatoPeeling;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CookingPotatoes {

	public static void main(String[] args) {
		Kitchen kitchen = new Kitchen();
		Cook fero = new Cook(kitchen);
		NoobCook joro = new NoobCook(kitchen);
		ExecutorService cooking = Executors.newFixedThreadPool(2);
		cooking.execute(fero);
		cooking.execute(joro);
	}
}
