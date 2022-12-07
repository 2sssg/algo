package extra;

import java.io.*;
import java.util.*;

public class AlgorithmHomework1 {
	static int n, m, answer = 1;
	public static void main(String[] args) throws IOException {
		m = rstn(); n = rstn();
		while(m != 1) {
			answer++;
			int nextN = (int) Math.ceil((double) n / m);
			int newlcm = lcm(n, nextN);
			int newM = (newlcm / n) * m - newlcm / nextN;
			int newgcd = gcd(newM, newlcm);

			n = newlcm/newgcd;
			m = newM/newgcd;
		}
		bw.write(Integer.toString(answer));
		bw.flush();
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int gcd(int a, int b) {if(a % b == 0) return b; return gcd(b, a % b);}
	static int lcm(int a, int b) {return a * b / gcd(a, b);}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
}
