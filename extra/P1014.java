package extra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1014 {
	static int c, n, m, visitcnt;
	static int[][] room;
	static boolean[][] nodes;
	static int[] visit, matched;
	static int[][] scopes = {{-1, 1}, {-1, 0}, {-1, -1}, {1, 1}, {1, 0}, {1, -1}};

	static int bipartite() {
		int size = 0;
		visit = new int[n * m];
		matched = new int[n * m];
		Arrays.fill(matched, -1);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j += 2) {
				visitcnt++;
				size += dfs(room[i][j] - 1);
			}
		}
		return size;
	}


	static int dfs(int num) {
		if (visit[num] != visitcnt) {
			visit[num] = visitcnt;
			for (int i = 0; i < n * m; i++) {
				if (nodes[num][i]) {
					if (matched[i] == -1 || dfs(matched[i]) == 1) {
						matched[i] = num;
						return 1;
					}
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		c = rn();
		while (c-- > 0) {
			n = rstn(); m = rstn();
			boolean[][] canSit = new boolean[n][m];
			int numbering = 1;
			int broken = 0;
			room = new int[n][m];
			nodes = new boolean[n * m][n * m];

			visitcnt = 1;
			for (int i = 0; i < n; i++) {
				String temp = br.readLine();
				for (int j = 0; j < m; j++) {
					room[i][j] = numbering++;
					if (temp.charAt(j) == '.') canSit[i][j] = true;
					else {
						canSit[i][j] = false;
						broken++;
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j += 2) {
					if (canSit[i][j]) {
						for (int[] scope : scopes) {
							int no = i + scope[1];
							int mo = j + scope[0];
							if (no > -1 && mo > -1 && no < n && mo < m && canSit[no][mo])
								nodes[room[i][j] - 1][room[no][mo] - 1] = true;
						}
					}
				}
			}
			int result = bipartite();
			sb.append(n * m - broken - result).append("\n");
		}
		System.out.println(sb);
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int swap(int localA, int localB) {return localA;}
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	static int dy[] = { -1,0,0,1,1,1,-1,-1 };
	static int dx[] = { 0,1,-1,0,-1,1,1,-1 };
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
	static final int IINF = Integer.MAX_VALUE;
	static final long LINF = Long.MAX_VALUE;
	static final int HIINF = Integer.MAX_VALUE / 2;
	static final long HLINF = Long.MAX_VALUE / 2;
	static int max(int... temp) {return Arrays.stream(temp).max().getAsInt();}
	static int min(int... temp) {return Arrays.stream(temp).min().getAsInt();}
}
