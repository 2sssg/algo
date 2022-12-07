package extra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P2083 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		while (true) {
			st = new StringTokenizer(br.readLine());
			String name;
			int age, weight;
			name = st.nextToken();
			age = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());

			if (name.equals("#") && age == 0 && weight == 0) break;
			bw.append(name).append(" ");
			if (age > 17 || weight >= 80) {
				bw.append("Senior");
			} else {
				bw.append("Junior");
			}
			bw.append("\n");
		}
		bw.flush();
	}
}
