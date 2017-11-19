import java.util.Scanner;

public class Task3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String w1 = sc.next();
		String w2 = sc.next();
		
		posCheck(w1, w2);
		
	}
	
	static void posCheck(String s1, String s2){
		int max = s1.length() > s2.length()? s1.length() : s2.length();
		for (int i = 0; i < max; i++) {
			if(s1.charAt(i) != s2.charAt(i)){
				System.out.println((i+1)+" "+s1.charAt(i)+"-"+s2.charAt(i));
			}
		}
	}
}
