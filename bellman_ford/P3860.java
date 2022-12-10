package bellman_ford;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P3860 {
	static int n, m;
	static int g, e;
	static HashMap<Integer, Triple> hole;
	static int[][] arr;
	static long[][] dist;

	static boolean init() throws IOException {
		hole = new HashMap<>();

		n = rstn(); m = rstn();
		if (n == 0 && m == 0) return false;

		arr = new int[n][m];

		g = rn();
		for (int i = 0; i < g; ++i) arr[rstn()][rstn()] = -1;


		e = rn();
		for (int i = 1; i <= e; ++i) {
			arr[rstn()][rstn()] = i;
			hole.put(i, new Triple(rstn(), rstn(), rstn()));
		}
		return true;
	}

	static boolean bf() {
		dist = new long[n][m];
		for (int i = 0; i < n; ++i) Arrays.fill(dist[i], HLINF);
		dist[0][0] = 0;
		boolean update = false;
		for (int i = 1; i < n * m; ++i) {
			update = false;
			for (int j = 0; j < n * m; ++j) {
				if (arr[j / m][j % m] < 0) continue;
				if (dist[j / m][j % m] == HLINF) continue;
				if (j / m == n - 1 && j % m == m - 1) continue;
				if (arr[j / m][j % m] > 0) {
					Triple cur = hole.get(arr[j / m][j % m]);
					if (dist[cur.x][cur.y] > dist[j / m][j % m] + cur.z) {
						update = true;
						dist[cur.x][cur.y] = dist[j / m][j % m] + cur.z;
					}
				} else {
					for (int k = 0; k < 4; ++k) {
						if (chk(j / m + dx[k], j % m + dy[k], n, m) || arr[j / m + dx[k]][j % m + dy[k]] < 0) continue;
						if (dist[j / m + dx[k]][j % m + dy[k]] > dist[j / m][j % m] + 1) {
							update = true;
							dist[j / m + dx[k]][j % m + dy[k]] = dist[j / m][j % m] + 1;
						}
					}
				}
			}
			if (!update) break;
		}

		if (update) {
			for (int j = 0; j < n * m; ++j) {
				if (arr[j / m][j % m] < 0) continue;
				if (dist[j / m][j % m] == HLINF) continue;
				if (j / m == n - 1 && j % m == m - 1) continue;
				if (arr[j / m][j % m] > 0) {
					Triple cur = hole.get(arr[j / m][j % m]);
					if (dist[cur.x][cur.y] > dist[j / m][j % m] + cur.z) {
						return false;
					}
				} else {
					for (int k = 0; k < 4; ++k) {
						if (chk(j / m + dx[k], j % m + dy[k], n, m) || arr[j / m + dx[k]][j % m + dy[k]] < 0) continue;
						if (dist[j / m + dx[k]][j % m + dy[k]] > dist[j / m][j % m] + 1) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}



	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		while (init()) {
			if (!bf()) {
				bw.write("Never\n");
			} else if (dist[n - 1][m - 1] == HLINF) {
				bw.write("Impossible\n");
			} else {
				bw.write(Long.toString(dist[n - 1][m - 1]));
				bw.write("\n");
			}
			bw.flush();
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	private static int swap(int localA, int localB) {return localA;}
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
	static final int IINF = Integer.MAX_VALUE;
	static final long LINF = Long.MAX_VALUE;
	static final int HIINF = Integer.MAX_VALUE / 2;
	static final long HLINF = Long.MAX_VALUE / 2;

}
