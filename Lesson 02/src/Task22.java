import java.util.Scanner;

public class Task22 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input number 1 - 999");
		
		int num;
		
		do{
			num = sc.nextInt();
		}while(num < 0 && num > 1000);
		int cnt = 1;
		
		while(cnt <= 10){
			num++;
			if(num % 2 == 0 || num % 3 == 0 || num % 5 == 0){
				System.out.print(cnt+": "+num);
				cnt++;				
				if(cnt < 11){
					System.out.print(", ");
				}else{
					System.out.print(";");
				}
			}
			
		}
	}
}
