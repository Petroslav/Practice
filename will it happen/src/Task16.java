import java.util.Scanner;

public class Task16 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if(num < 100 || num > 999){
			System.out.println("The number must be between 100 and 999");
			return;
		}
		int a = num / 100;
		int b = (num%100) / 10;
		int c = num % 10;
		if(a == b && a == c){
			System.out.println("All numbers are equal");
			return;
			
		}
		if(a > b && b > c){
			System.out.println("Numbers are in descending order");
			return;
			
		}
		if(c > b && b > a){
			System.out.println("Numbers are in àscending order");
			return;
			
		}else{
			System.out.println("Numbers are in no particular order");
			return;
		}
	}
}
