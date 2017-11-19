import java.util.Scanner;

public class Task9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		if(a < 10 && b < 10 && a > 99 && b > 99){
			System.out.println("The numbers must be between 10 and 99");
			return;
		}
		if((((a*b)%10)%2)==0){
			System.out.println((a*b)+", "+((a*b)%10)+" - even");
		}else{
			System.out.println((a*b)+", "+((a*b)%10)+" - odd");
		}
	}
}
