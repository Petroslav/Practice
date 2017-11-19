
public class Task12 {

	public static void main(String[] args) {
		for (int i = 102; i < 988; i++) {
			if((i/100 != i%10) && (i%10 != (i/10)%10)){
				System.out.println(i);
			}
		}
	}
}
