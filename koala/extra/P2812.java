package koala.extra;

import java.io.*;
import java.util.*;

public class P2812 {
	static int n, k;
	public static void main(String[] args) throws Exception {
		n = rstn(); k = rstn();

		char[] arr = br.readLine().toCharArray();
		Deque<Character> dq = new ArrayDeque<>();
		for (int i = 0; i < arr.length; i++) {
			while (k > 0 && !dq.isEmpty() && dq.getLast() < arr[i] && k-- > -9999) dq.removeLast();
			dq.addLast(arr[i]);
		}

		while (dq.size() > k) sb.append(dq.removeFirst());
		System.out.println(sb);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
}