package korea_univ_matkor_cup;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_A {
	static int t;

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		t = rstn();
		System.out.println(rstn() == 1 || t < 12 || t > 16 ? 280 : 320);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
}
