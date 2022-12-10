package extra;

import java.io.*;
import java.util.*;

public class P1269 {
	public static void main(String[] args) throws IOException {
		int cnt = rstn() + rstn();
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 0; i < cnt; ++i) hs.add(rstn());
		System.out.println(2 * hs.size() - cnt);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
}
