package easy;

import java.io.*;
import java.util.*;

public class P3985 {
	static int l, n, ans, realans, ansidx, realansidx;
	static boolean[] arr;
	public static void main(String[] args) throws IOException {
		arr = new boolean[(l = rn()) + 1];
		n = rn();
		for (int i = 1; i <= n; ++i) {
			int low = rstn(), high = rstn();
			if (realans < high - low + 1) {
				realans = high - low + 1;
				realansidx = i;
			}
			int cnt = 0;
			for (;low <= high; ++low) {
				if (arr[low]) continue;
				arr[low] = true;
				cnt++;
			}
			if (ans < cnt) {
				ans = cnt;
				ansidx = i;
			}
		}

		System.out.printf("%d\n%d", realansidx, ansidx);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
}
