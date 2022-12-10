package kmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P16900 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static String p;
	static int n;

	static int[] pi;

	static void makePi(String pattern, int length) {
		pi = new int[length];
		int idx = 0;
		for (int i = 1; i < length; ++i) {
			while (idx > 0 && pattern.charAt(i) != pattern.charAt(idx)) idx = pi[idx - 1];
			if (pattern.charAt(i) == pattern.charAt(idx)) pi[i] = ++idx;
		}
	}


	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		p = st.nextToken();
		n = Integer.parseInt(st.nextToken());
		makePi(p, p.length());
		int temp = p.length() - pi[p.length() - 1];
		System.out.println((long)p.length() + (long)temp * (n - 1));

	}
}
