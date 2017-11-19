import java.util.Scanner;

public class Task4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input array size: ");
		int size = sc.nextInt();
		int[] arr = new int[size];
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Input cell "+(i+1)+" value:");
			arr[i] = sc.nextInt();
		}
		boolean isMirror = true;
		if(size > 1){
			for (int i = 0; i < arr.length/2; i++) {
				for (int j = arr.length-1; j > (arr.length/2)-1; j--) {
					if(arr[i] != arr[j]){
						isMirror = false;
						break;
					}
					i++;
				}
			}
		}
		
		System.out.println(isMirror ? "yes" : "no");
	}
}
