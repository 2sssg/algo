package string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P5052 {
	static int t, n, root, unused;
	static final int MX = 10_000 * 10 + 5;
	static boolean[] chk;
	static int[][] nxt;


	static void init() throws IOException {
		n = rn();
		root = 1;
		unused = 2;
		chk = new boolean[MX];
		nxt = new int[MX][10];
		for (int i = 0; i < MX; ++i) Arrays.fill(nxt[i], -1);
	}

	static boolean trie(String s) {
		int cur = root;
		for (var ch : s.toCharArray()) {
			if (nxt[cur][c2i(ch)] == -1) nxt[cur][c2i(ch)] = unused++;
			if (chk[cur = nxt[cur][c2i(ch)]]) return false;
		}
		chk[cur] = true;
		for (int i = 0; i < 10; ++i) if (nxt[cur][i] != -1) return false;
		return true;
	}

	public static void main(String[] args) throws IOException {
		t = rn();
		while (t-- > 0) {
			init();
			while (n-- > 0) {
				if (!trie(br.readLine())) {
					sb.append("NO\n");
					while (n-- > 0) br.readLine();
				}
			}
			if (n == -1) sb.append("YES\n");
		}
		System.out.println(sb);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int c2i(char c) {return c - '0';}
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
}
