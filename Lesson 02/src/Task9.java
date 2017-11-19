import java.util.Scanner;

public class Task9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input A:");
		int a = sc.nextInt();
		System.out.println("Input B:");
		int b = sc.nextInt();
		int sum = 0;
		
		for (int i = a; i < b; i++) {
			if(i%3 == 0){
				System.out.print("skip 3");
				i++;
			}else{
				System.out.print(i*i);
				sum+=i*i;
			}
			if(sum >= 200){
				System.out.print(";");
				break;
			}else{
				System.out.print(", ");
			}
			
		}
	}
}
