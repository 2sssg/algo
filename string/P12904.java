package string;
import java.io.*;

public class P12904 {
	public static void main(String[] args) throws IOException {
		StringBuilder s = new StringBuilder(br.readLine()), t = new StringBuilder(br.readLine());
		while (true) {
			if (s.length() == t.length()) {
				System.out.println(s.toString().equals(t.toString()) ? 1 : 0);
				return ;
			}

			if (t.charAt(t.length() - 1) != 'A') {
				t.setLength(t.length() - 1);
				t.reverse();
			} else t.setLength(t.length() - 1);

		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
}
