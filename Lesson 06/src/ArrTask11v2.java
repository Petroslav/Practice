
public class ArrTask11v2 {

	public static void main(String[] args) {
		int[][] arr = new int[7][4];
		int cnt = 1;
		int cnt2 = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j <= cnt2; j++) {
				arr[cnt2-j][j] = cnt;
				cnt++;
				cnt2++;
			}
			if(cnt2==arr.length-1){
				cnt2=0;
			}
		}
		System.out.println(cnt);
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+", ");
			}
			System.out.println();
		}		
		
	}
}
