import java.util.Scanner;

public class Task13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input a number for the sum (Must be between 2 and 27");
		int sum = sc.nextInt();
		if(sum > 27 || sum < 2){
			System.out.println("Mst be between 2 and 27");
			return;
		}
		for (int i = 101; i < 1000; i++) {
			if((i/100 + (i/10)%10 + i%10) == sum){
				if(((i+1)/100 + ((i+1)/10)%10 + (i+1)%10) > sum){
					System.out.print(i+".");
				}else{
					System.out.print(i+", ");
				}
			}
		}
		
	}
}
