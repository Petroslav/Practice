import java.util.Scanner;

public class Task19 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input a number between 10 and 99");
		int num = sc.nextInt();
		if(num < 10 || num > 99){
			System.out.println("No.");
			return;
		}
		
		while(num != 1){
			if(num%2 == 0){
				num = num/2;
			}else{
				num = (num*3)+1;
			}
			System.out.print(num+" ");
		}
	}
}
