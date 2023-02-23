package koala.base.week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;

public class P3181 {
	static String replace = "'i', 'pa', 'te', 'ni', 'niti', 'a', 'ali', 'nego', 'no', 'ili'";

	public static void main(String[] args) throws IOException {
		String s = br.readLine();
		String[] replaceArr = replace
				.replace("'", "").replace(",", "")
				.split(" ");
		for (String word: s.split(" ")) sb.append(word.charAt(0));
		for (int i = 0; i < replaceArr.length; ++i) {
			int idx = sb.toString().indexOf(replaceArr[i]);
			int len = sb.length();
			while (idx > 0) {
				sb.delete(idx, idx + replaceArr[i].length());
				idx = sb.toString().indexOf(replaceArr[i]);
			}
			if (len != sb.length()) i = -1;
		}
		System.out.println(sb.toString().toUpperCase(Locale.ROOT));

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
