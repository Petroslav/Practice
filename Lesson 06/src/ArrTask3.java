import java.util.Scanner;

public class ArrTask3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] arr = {'a', 'b', 'x', 'c', '*', '#', 's', '5'};
		char a = sc.nextLine().charAt(0);
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == a){
				System.out.println(i);
				break;
			}else{
				System.out.println("swg");
			}
			
		}
		
		
	}
}
