public class ArrTask2 {

	public static void main(String[] args) {
		int[] arr = {4,6,5,7,6};
		boolean zigZag = true;
		for (int i = 1; i < arr.length-1; i++) {
			if(
				!(
						(arr[i] > arr[i-1] && arr[i] > arr[i+1]) || 
						(arr[i] < arr[i-1] && arr[i] < arr[i+1])
				)				
				){
				zigZag = false;
				break;
			}
		}
		System.out.println(zigZag);
	}
}
