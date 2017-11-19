
public class Task11 {

	public static void main(String[] args) {
		int[] arr = {1,2,4,5,6,2,2};
		printArray(arr);
		
	}
	
	static void printArray(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			if(i == 0){
				System.out.print("["+arr[i]+", ");
			}
			if(i == arr.length-1){
				System.out.print(arr[i]+"]");
			}else{
				System.out.print(arr[i]+", ");
			}
		}
	}
}
