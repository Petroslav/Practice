import java.io.*;
import java.util.Scanner;

public class CharacterStreams {

	public static void main(String[] args) throws IOException {
		File jojo = new File("neiskam.txt");
		jojo.createNewFile();
		Scanner sc = new Scanner(System.in);
		BufferedWriter writes = new BufferedWriter(new FileWriter(jojo, true));
		int cnt = 0;
		while(true){
			String one = sc.nextLine();
			writes.append(one);
			writes.newLine();
			cnt++;
			if(cnt == 2) break;
		}
		sc.close();
		writes.close();
			
	}
}
