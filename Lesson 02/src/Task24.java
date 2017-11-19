import java.util.Scanner;

public class Task24 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		do{
			System.out.println("enter a number between 10 and 30000");
			num = sc.nextInt();
		}while(num < 10 || num > 30000);
		
		int i = 100000;
		int pwr = 1;
		int revNum = 0;
		
		do{
			i = i/10;
			if(num/i != 0){
				revNum+= ((num/i)%10)*pwr;
				pwr*=10;
			}
		}while(i > 1);
		
		if(num == revNum){
			System.out.println("Palindrome");
		}else{
			System.out.println("Nolindrome");
		}
	}
}
