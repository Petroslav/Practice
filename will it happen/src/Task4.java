import java.util.Scanner;

public class Task4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		if(b > a){
			System.out.println(a+", "+b);
		}else{
			System.out.println(b+", "+a);
		}
	}
}
