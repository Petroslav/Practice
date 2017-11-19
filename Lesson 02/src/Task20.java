
public class Task20 {

	public static void main(String[] args) {
		int count = 1;
		
		for(int i=1; i<=10; i++){
			for(int j=1; j<=10; j++){
				if(count==10){
					count = 0;
				}
				System.out.print(count + " ");
				count++;
			}
			System.out.println();
			count = i+1;
			
		}
	}
}
