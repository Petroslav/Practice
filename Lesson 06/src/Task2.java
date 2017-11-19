
public class Task2 {

	public static void main(String[] args) {
		int[][] arr = {
					{1,4,6,3},
					{5,9,7,2},
					{4,8,1,9},
					{2,3,4,5},
					};
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i][i]+" ");
		}
		System.out.println();
		for (int j = 0; j < arr.length; j++) {
			for (int i = arr.length-1; i >= 0; i--) {
				System.out.print(arr[j][i]+" ");
				j++;
			}			
		}
	}
}
