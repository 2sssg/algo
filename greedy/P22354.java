package greedy;

import java.io.*;
import java.util.*;

public class P22354 {
	static int n;
	static String color;
	static List<Integer> weight = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		n = rn();
		if (n == 1) {
			System.out.println(0);
			return ;
		}
		color = br.readLine();
		char c = color.charAt(0);
		int maxW = 0;
		for (int i = 0; i < n; ++i) {
			int w = rstn();
			if (c == color.charAt(i)) {
				maxW = Math.max(w, maxW);
			} else {
				weight.add(maxW);
				maxW = w;
				c = color.charAt(i);
			}
		}
		if (weight.size() == 0) {
			System.out.println(0);
			return ;
		}
		weight.remove(0);
		weight.sort(Comparator.reverseOrder());
		if (weight.size() == 0) {
			System.out.println(0);
			return ;
		}
		long ans = 0;
		for (int i = 0; i < weight.size() / 2.0; ++i) ans += weight.get(i);
		System.out.println(ans);

	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
}
