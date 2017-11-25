import java.io.*;

public class TestWriting {

	public static void main(String[] args) throws IOException {
		File f = new File("wtf.txt");
		f.createNewFile();
		FileWriter wat = new FileWriter(f, true);
		BufferedWriter bw = new BufferedWriter(wat);
		PrintWriter out = new PrintWriter(bw);
		for (int i = 0; i < 10; i++) {
			out.println("OMG ZASHTO?");
		}
	}
}
