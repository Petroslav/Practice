import java.util.Scanner;

public class Task7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please input the time: ");
		int time = sc.nextInt();
		System.out.print("Please input your budget: ");
		double budget = sc.nextDouble();
		System.out.println("Are you healthy? true / false");
		boolean health = sc.nextBoolean();
		
		if(health == false){
			System.out.println("No going out");
			if(budget > 10){
				System.out.println("I'll buy medicine");
			}else{
				System.out.println("I'll stay at home drinking tea");
			}
		
		}else{
			if(budget < 10){
				System.out.println("I'll go grab a coffee");
			}else{
				System.out.println("Time to go to the movies!");
			}
		}
	}
}
