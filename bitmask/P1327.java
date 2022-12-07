package bitmask;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1327 {

	static int n, k, ans, cur;
	static boolean[] visit;
	static int[] arr;

	static Queue<Pair> q = new ArrayDeque<>();

	static void print(int num) {
		for (int i = 7; num != 0; --i) {
			int bit = (7 << (i * 3));
			int temp = bit & num;
//			System.out.println(Integer.toBinaryString(num));
			num = num & (~bit);
			temp = temp >> (i * 3);
//			System.out.print(Integer.toBinaryString(temp));
//			System.out.print(" ");
			System.out.print(temp);
			System.out.print(" ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		q.clear();
		ans = 0;
		cur = 0;
		n = rstn(); k = rstn(); arr = ra();
		visit = new boolean[(1 << 25) - 1];

		for (int i = 0; i < n; ++i) {
			ans += (i << ((n - i - 1) * 3));
			cur += ((arr[n - i - 1] - 1) << (i * 3));
		}

		q.add(new Pair(cur, 0));
		visit[cur] = true;

		while (!q.isEmpty()) {
			Pair p = q.poll();

			if (p.x == ans) {
				System.out.println(p.y);
				return ;
			}

			for (int i = n - 1; i >= k - 1; --i) {
				int tempk = k;
				int nx = p.x;
				int index = i;
				while (tempk > 1) {
					int first = p.x & (7 << (index * 3));
					int second = p.x & (7 << ((index - (tempk - 1)) * 3));
					nx = nx & (~first);
					nx = nx & (~second);
					first = first >> ((tempk - 1) * 3);
					second = second << ((tempk - 1) * 3);
					nx = nx | first | second;
					tempk -= 2;
					index--;
				}
				if (visit[nx]) continue;
				visit[nx] = true;
				q.add(new Pair(nx, p.y + 1));
			}
		}

		System.out.println(-1);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
}
