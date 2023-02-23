package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1126 {
	static int n;
	static int[] arr;
	static int[][] cache = new int[50][500000 / 2 + 1];

	static int maxHeight(int idx, int heightDiff)  {
		if (heightDiff > 500000 / 2) return -HIINF;
		if (idx == n && heightDiff > 0) return -HIINF;
		if (idx == n && heightDiff == 0) return 0;

		if (cache[idx][heightDiff] != -1) return cache[idx][heightDiff];
		cache[idx][heightDiff] = -HIINF;
		cache[idx][heightDiff] = Math.max(cache[idx][heightDiff], maxHeight(idx + 1, heightDiff));
		cache[idx][heightDiff] = Math.max(cache[idx][heightDiff], maxHeight(idx + 1, heightDiff + arr[idx]));
		if (arr[idx] > heightDiff)
			cache[idx][heightDiff] = Math.max(cache[idx][heightDiff], heightDiff + maxHeight(idx + 1, arr[idx] - heightDiff));
		else
			cache[idx][heightDiff] = Math.max(cache[idx][heightDiff], arr[idx] + maxHeight(idx + 1, heightDiff - arr[idx]));
		return cache[idx][heightDiff];
	}

	public static void main(String[] args) throws IOException {
		n = rn(); arr = ra();
		for (int i = 0; i < 50; ++i) Arrays.fill(cache[i], -1);
		int result = maxHeight(0, 0);
		if (result != 0)  System.out.println(result);
		else System.out.println(-1);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	static final int HIINF = Integer.MAX_VALUE / 2;
}
