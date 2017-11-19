import java.util.Scanner;

public class Task8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please input a number: ");
		int num = sc.nextInt();
		if(num < 1000 || num > 9999){
			System.out.println("The number must be between 1000 and 9999. Try again later");
			return;
		}
		int a = num / 1000;
		int b = (num % 1000) / 100;
		int c = (num % 100) / 10;
		int d = num % 10;
		
		int num1 = a*10+d;
		int num2 = b*10+c;
		
		if(num1 > num2){
			System.out.println(num1+" > "+num2);
		}
		if(num1 < num2){
			System.out.println(num1+" < "+num2);
		}
		if(num1 == num2){
			System.out.println(num1+" = "+num2);
		}
	}
}
