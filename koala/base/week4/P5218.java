package koala.base.week4;

import java.io.*;

public class P5218 {

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
	 	while (n-- > 0) {
			String[] s = br.readLine().split(" ");
			sb.append("Distances: ");
			for (int i = 0; i < s[0].length(); ++i)
				sb
					.append(
						s[1].charAt(i) - s[0].charAt(i) >= 0 ?
						s[1].charAt(i) - s[0].charAt(i) :
						s[1].charAt(i) - s[0].charAt(i) + 26
					)
					.append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
}
