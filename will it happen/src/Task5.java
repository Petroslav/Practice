import java.util.Scanner;

public class Task5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		if(a > b && a > c){
			System.out.println(a);
			if(b > c){
				System.out.println(b);
				System.out.println(c);
			}else{
				System.out.println(c);
				System.out.println(b);
			}
		}
		if(b > a && b > c){
			System.out.println(b);
			if(a > c){
				System.out.println(a);
				System.out.println(c);
			}else{
				System.out.println(c);
				System.out.println(a);
			}
		}
		if(c > a && c > b){
			System.out.println(c);
			if(a > b){
				System.out.println(a);
				System.out.println(b);
			}else{
				System.out.println(b);
				System.out.println(a);
			}
		}
	}
}
