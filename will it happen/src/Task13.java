import java.util.Scanner;

public class Task13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please input the temperature: ");
		int temp = sc.nextInt();
		if(temp < -100 && temp > 100){
			System.out.println("You're probably dead");
		}else{
			if(temp < -20){
				System.out.println("ICE COLD");
			}
			if(temp >= - 20 && temp <= 0){
				System.out.println("Cold");
			}
			if(temp > 0 && temp < 15){
				System.out.println("Chilly");
			}
			if(temp >= 15 && temp <= 25){
				System.out.println("Warm");
			}
			if(temp > 25){
				System.out.println("HOT AF");
			}
		}
	}
}
