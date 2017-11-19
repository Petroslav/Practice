import java.util.Scanner;

public class Task15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int time = sc.nextInt();
		if(time >= 0 && time <= 24){
			if(time > 4 && time <= 9){
				System.out.println("GOOD MORNING, VIETNAM");
			}
			if(time > 9 && time <= 18){
				System.out.println("WELL MET");
			}
			if(time > 18 && time <= 24){
				System.out.println("GOOD NIGHT");
			}
		}else{
			System.out.println("Outside of the clock");
		}
	}
}
