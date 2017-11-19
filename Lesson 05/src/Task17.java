
public class Task17 {

	public static void main(String[] args) {
		int[] arr = {1, 3, 2, 2, 3, 7};
		boolean zigZag = true;
		for (int i = 1; i < arr.length-1; i+=2) {
			if(arr[i-1] >= arr[i] || arr[i] <= arr[i+1]){
				zigZag = false;
			}
		}
		System.out.println(zigZag);
		
	}
}
