import java.util.Scanner;

public class Task10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int volume = sc.nextInt();
		int buckets = volume / 5;
		int extra = volume % 5;
		if(extra % 3 == 0){
			System.out.println(buckets+" times 2L buckets");
			System.out.println((buckets+(extra/3))+" times 3L buckets");
			return;
		}
		if( extra % 2 == 0){
			System.out.println((buckets+(extra/2))+" times 2L buckets");
			System.out.println(buckets+" times 3L buckets");
			return;
		}
		if(extra % 3 == 1 || extra % 2 == 1){
			System.out.println(buckets+" times 2L buckets");
			System.out.println(buckets+" times 3L buckets");
			System.out.println("1L remains");
			return;
		}
	}
}
