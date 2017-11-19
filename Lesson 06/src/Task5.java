
public class Task5 {

	public static void main(String[] args) {
		int[][] arr = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		
		int maxRow = arr[0][0]+arr[0][1]+arr[0][2]+arr[0][3];
		int maxCol = arr[0][0]+arr[1][0]+arr[2][0]+arr[3][0];
		
		for (int i = 0; i < arr.length; i++) {
			int sum1 = 0;
			int sum2 = 0;
			for (int j = 0; j < arr[i].length; j++) {
				sum1+=arr[i][j];
				sum2+=arr[j][i];
			}
			if(sum1 > maxRow){
				maxRow = sum1;
			}
			if(sum2 > maxCol){
				maxCol = sum2;
			}
		}
		System.out.println("Row max: "+maxRow);
		System.out.println("Col max: "+maxCol);
		System.out.println("Max suma po redove e "+(maxRow > maxCol? ">" : "<")+" Max suma po koloni");
	}
}
