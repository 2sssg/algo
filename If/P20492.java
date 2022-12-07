package If;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P20492 {

	public static void main(String[] args) throws IOException {
		int n = rn();
		sb.append(n / 100 * 78).append(" ").append(n / 1000 * 956);
		System.out.println(sb);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
}
