import java.util.Scanner;

public class FirstApp {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Input A:" );
		double a = sc.nextDouble();
		System.out.print("Input B:" );
		double b = sc.nextDouble();
		System.out.print("Input C:" );
		double c = sc.nextDouble();
		
		if(a < b){
			double f = a;
			a = b;
			b = f;
		}
		
		if(c<a && c>b){
			System.out.println(c+" is between "+a+" and "+b);
		}else{
			System.out.println(c+" is not between "+a+" and "+b);
		}
	}
	
	
}
