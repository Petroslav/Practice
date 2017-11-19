import java.util.Scanner;

public class Task10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 String w1 = sc.next();
		 char[] duma = w1.toCharArray();
		 
		 for (int i = 0; i < duma.length; i++){
		   duma[i]+=5;
		   System.out.print(duma[i]);
		 }
	}
}
