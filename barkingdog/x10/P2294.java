package barkingdog.x10;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2294 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,k;
	static int[] a = new int[10005],d = new int[10005];
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(br.readLine());

		Arrays.fill(d, 100005);
		d[0] = 0;
		for (int i = 0; i < n; i++) {
			for (int j = a[i]; j <= k; j++)
				d[j] = Math.min(d[j], d[j - a[i]] + 1);
		}
		System.out.println(d[k] == 100005 ? -1 : d[k]);
	}

}
