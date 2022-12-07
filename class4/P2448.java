package class4;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2448 {
	static int n;
	private static void makeBigStar(int k, StringBuilder map[]) {
		StringBuilder space = new StringBuilder();
		int bottom = 3 * (int)Math.pow(2, k);
		int middle = bottom / 2;
		for (int i = middle; i < bottom; ++i) map[i] = new StringBuilder(map[i - middle]).append(" ").append(map[i - middle]);
		while (space.length() < middle) space.append(" ");
		for (int i = 0; i < middle; ++i) map[i].insert(0, space).append(space);

	}

	public static void main(String[] args) throws IOException {
		n = rn();

		StringBuilder map[] = new StringBuilder[n];
		map[0] = new StringBuilder("  *  ");
		map[1] = new StringBuilder(" * * ");
		map[2] = new StringBuilder("*****");

		for (int k = 1; 3 * (int)Math.pow(2, k) <= n; ++k) makeBigStar(k, map);
		for (int i = 0; i < n; ++i) bw.append(map[i]).append("\n");

		bw.flush();
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
}
