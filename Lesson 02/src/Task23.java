
public class Task23 {

	public static void main(String[] args) {
		int i = 1;
		int j = 1;
		
		while(i < 10){
			do{
				System.out.print(i+"x"+j+";");
				j++;
			}while(j < 10);
			System.out.println();
			i++;
			j = i;
		}
		System.out.println((1000/1000)%10);
	}
}
