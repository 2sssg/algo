package easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10156 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());
		System.out.println(answer < 0 ? 0 : answer);

	}
}
