import java.io.*;
import java.util.Scanner;

public class CharacterStreams {

	public static void main(String[] args) throws IOException {
		File jojo = new File("neiskam.txt");
		jojo.createNewFile();
		Scanner sc = new Scanner(System.in);
		FileWriter writes = new FileWriter(jojo);
		int cnt = 0;
		while(true){
			String one = sc.nextLine();
			writes.write(one);
			cnt++;
			if(cnt == 2) break;
		}
		sc.close();
		writes.close();
			
	}
}
