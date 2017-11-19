import java.util.Scanner;

public class Task14 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Numbers must be between 1 and 8");
		System.out.println("Input x1: ");
		int x1 = sc.nextInt();
		if(x1 > 8 || x1 < 1){
			System.out.println("Incorrect number");
			return;
		}
		System.out.println("Input y1: ");
		int y1 = sc.nextInt();
		if(y1 > 8 || y1 < 1){
			System.out.println("Incorrect number");
			return;
		}
		System.out.println("Input x2: ");
		int x2 = sc.nextInt();
		if(x2 > 8 || x2 < 1){
			System.out.println("Incorrect number");
			return;
		}
		System.out.println("Input y2: ");
		int y2 = sc.nextInt();
		if(y2 > 8 || y2 < 1){
			System.out.println("Incorrect number");
			return;
		}
		
		if( (x1%2 == 0 && x2%2 == 0) || (x1%2 != 0 && x2%2 != 0) ){
			if(y1%2 == 0 && y2%2 == 0){
				System.out.println("Same colors");
			}else{
				System.out.println("Different colors");
			}
		}else{
			if((y1%2 != 0 && y2%2 == 0) || (y1%2 == 0 && y2%2 != 0)){
				System.out.println("Same colors");
			}else{
				System.out.println("Different colors");
			}
		}
	}
}
