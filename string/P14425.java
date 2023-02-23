package string;

import java.io.*;
import java.util.*;

public class P14425 {
	static int n, m, root, unused, ans;
	static final int MX = 500 * 10_000 + 5;
	static boolean[] chk;
	static int[][] nxt;

	static void init() throws IOException {
		n = rstn();
		m =rstn();
		root = 1;
		unused = 2;
		ans = 0;
		chk = new boolean[MX];
		nxt = new int[MX][26];
		for (int i = 0; i < MX; ++i) Arrays.fill(nxt[i], -1);
	}

	static void insert(String s) {
		int cur = root;
		for (var ch : s.toCharArray()) {
			if (nxt[cur][c2i(ch)] == -1) nxt[cur][c2i(ch)] = unused++;
			cur = nxt[cur][c2i(ch)];
		}
		chk[cur] = true;
	}

	static boolean find(String s) {
		int cur = root;
		for (var ch : s.toCharArray()) {
			if (nxt[cur][c2i(ch)] == -1) return false;
			cur = nxt[cur][c2i(ch)];
		}
		return chk[cur];
	}

	public static void main(String[] args) throws IOException {
		init();
		while (n-- > 0) insert(br.readLine());
		while (m-- > 0) ans += find(br.readLine()) ? 1 : 0;
		System.out.println(ans);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static int c2i(char c) {return c - 'a';}
}
