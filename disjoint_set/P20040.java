package disjoint_set;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P20040 {
	static int n,m;
	static int[] parent;

	static void init() throws IOException {
		n = rstn(); m = rstn();
		parent = new int[n];
		for (int i = 0; i < n; ++i) parent[i] = i;
	}

	static int find(int a) {
		if (parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}

	static boolean merge(int a, int b) {
		if (find(a) == find(b)) return true;
		parent[find(a)] = find(b);
		return false;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		for (int i = 0; i < m; ++i) {
			if (merge(rstn(), rstn())) {
				System.out.println(i + 1);
				return;
			}
		}
		System.out.println(0);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
}
