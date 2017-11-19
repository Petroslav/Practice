import java.util.Scanner;

public class Task11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if(num < 100 || num > 999 || (num / 100) == 0 || ((num%100)/10) == 0 || (num%10) == 0){
			System.out.println("The number must be between 100 and 999 and cannot contain any zeros");
			return;
		}
		int a = num / 100;
		int b = (num%100) / 10;
		int c = num % 10;
		
		System.out.println(a+"\n"+b+"\n"+c);
		
		if(num%a == 0 && num%b == 0 && num%c == 0){
			System.out.println("NYEEEEEEEEEEEEEEESssss");
		}else{
			System.out.println("no");
		}
	}
}
