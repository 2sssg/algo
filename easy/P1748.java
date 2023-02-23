package easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1748 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n, r;
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; i *= 10) r += n - i + 1;
		System.out.println(r);
	}
}
