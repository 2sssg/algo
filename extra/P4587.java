package extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P4587 {

	static final int MAX = 1_000_000;

	static long p,q;

	static boolean init() throws IOException {
		q=rstn(); p=rstn();
		return p != 0 || q != 0;
	}

	public static void main(String[] args) throws IOException {
		while(init()) {
			while (q != 1) {
				long candidateP = (long)Math.ceil((double)p / q); // 2

				while (true) {
					long lcm = LCM(candidateP, p);
					long newP, newQ;

					newQ = q * (lcm / p) - lcm / candidateP;
					newP = lcm;
					long gcd = GCD(newQ, newP);
					newQ /= gcd;
					newP /= gcd;
					if (newP < MAX) {
						q = newQ;
						p = newP;
						break;
					}
					candidateP++;
				}
				bw.append(Long.toString(candidateP)).append(' ');
			}
			bw.append(Long.toString(p)).append('\n');
		}
		bw.flush();
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static long GCD(long a, long b){if (a % b == 0) return b; return GCD(b, a % b);}
	static long LCM(long a, long b){return a * b / GCD(a, b);}
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
