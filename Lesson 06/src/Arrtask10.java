
public class Arrtask10 {

	public static void main(String[] args) {
		int[] arr = {4, 1, 1, 4, 2, 3, 4, 4, 1, 2, 4, 9, 3};
		
		int maxCnt = 0;
		int cnt = 0;
		int mostFrequentNum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[j] == arr[i]){
					cnt++;
				}
				if(cnt > maxCnt){
					maxCnt = cnt;
					mostFrequentNum = arr[j];
				}
			}
			cnt = 0;
		}
		
		System.out.println(mostFrequentNum+" ("+maxCnt+" times)");
		
	}
}
