package Mortal_Combat;

public class Fight {

	public static void main(String[] args) {
		Fighter f1 = new Fighter(100, 10, "Evlogi");
		Fighter f2 = new Fighter(100, 10, "Chernio");
		f1.setEnemy(f2);
		f2.setEnemy(f1);
		int f1wins = 0;
		int f2wins = 0;
		
		for (int i = 0; i < 5; i++) {
			f1.printStats();
			f2.printStats();
			while(true){
				f1.hit();
				if(f2.isDead()) {
					System.out.println(f1.getName() + " wins!");
					f1wins++;
					break;
				}
				f2.hit();
				if(f1.isDead()){
					System.out.println(f1.getName() + " wins!");
					f2wins++;
					break;
				}
			}
		}
		
		System.out.println(f1.getName() + " wins: " + f1wins);
		System.out.println(f2.getName() + " wins: " + f2wins);
	}
}
