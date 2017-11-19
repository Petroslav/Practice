
public class Task8 {

	public static void main(String[] args) {
		int[] arr = {1,2,3,3,3,4,6,6,5,5};
		int count = 1;
		int maxI = 0;
		int maxCount = 0;
		
		for (int i = 0; i < arr.length-1; i++) {
			if(arr[i] == arr[i+1]){
				count++;
				if(maxCount < count){
					maxCount = count;
					maxI = i;
				}
			}else{
				count = 1;
			}
		}
		System.out.println(arr[maxI]+" "+maxCount);
	}
}
