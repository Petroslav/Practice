import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		int[] arr = {654,2,5,62,3,67,544,26,34,1,95,44,6};
		System.out.println(Arrays.toString(arr));
		bubblekSort(arr);
	}
	
	static int[] bubblekSort(int[] arr){
		int temp = 0;
		for (int i = arr.length-1; i >= 0; i--) {
			System.out.println(Arrays.toString(arr));
			for (int j = 0; j <= i; j++) {
				if(arr[i] > arr[j]){
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			
		}
		return arr;
	}
}
