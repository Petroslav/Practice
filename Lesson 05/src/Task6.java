import java.util.Scanner;

public class Task6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input the size for Array 1");
		int size1 = sc.nextInt();
		System.out.println("Input the size for Array 2");
		int size2 = sc.nextInt();
		
		int[] arr1 = new int[size1];
		int[] arr2 = new int[size2];
		
		boolean areSame = true;
		
		if(size1 != size2){
			areSame = false;
		}else{
			for (int i = 0; i < arr1.length; i++) {
				System.out.print("Input value for Cell #"+i+" of Array 1: ");
				arr1[i] = sc.nextInt();
			}
			for (int i = 0; i < arr2.length; i++) {
				System.out.print("Input value for Cell #"+i+" of Array 2: ");
				arr2[i] = sc.nextInt();
			}			
			for (int i = 0; i < arr2.length; i++) {
				if(arr1[i] != arr2[i]){
					areSame = false;
					break;
				}
			}
		}
		
		System.out.print(areSame ? "ya, " : "noo, ");
		System.out.print(size1 == size2 ? "same size" : "diff size");
	}
}
