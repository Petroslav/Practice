import java.util.Scanner;

public class Task5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		int temp = start;
		if(end < start){
			start = end;
			end = temp;
		}
		
		for (int i = start; i < (end+1); i++) {
			System.out.println(i);
		}
	}
}
