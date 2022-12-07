package kakao.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.StringTokenizer;

public class P1283 {
	static int n;
	static HashSet<Character> shortKey = new HashSet<>();
	public static void main(String[] args) throws IOException {
		n = rn();
		l: while (n-->0) {
			String command = br.readLine();
			String commandUpperCase = command.toUpperCase(Locale.ROOT);
			int length = command.length();
			int candidate = -1;
			boolean set = false;
			for (int i = 0; i < length; ++i) {
				if (commandUpperCase.charAt(i) == ' ') continue;
				if (!shortKey.contains(commandUpperCase.charAt(i))) {
					if (i == 0 || commandUpperCase.charAt(i - 1) == ' ') {
						shortKey.add(commandUpperCase.charAt(i));
						sb = new StringBuilder(command);
						sb.insert(i, '[');
						sb.insert(i + 2, ']');
						bw.append(sb.toString()).append('\n');
						continue l;
					} else if (!set){
						candidate = i;
						set = true;
					}
				}
			}
			if (set) {
				sb = new StringBuilder(command);
				shortKey.add(commandUpperCase.charAt(candidate));
				sb.insert(candidate, '[');
				sb.insert(candidate + 2, ']');
				bw.append(sb.toString()).append('\n');
			} else {
				bw.append(command).append('\n');
			}
		}
		bw.flush();
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
