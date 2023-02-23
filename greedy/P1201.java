package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1201 {
	public static void main(String[] args) throws IOException {
		int n = rstn(), m = rstn(), k = rstn();
		if (n >= m + k - 1 && n <= m * k) {
			int[] result = new int[m + 1];
			result[1] = k;
			n = n - k;
			if (m - 1 > 0) {
				int minLength = n / (m - 1);
				int rest = n % (m - 1);
				for(int i = 2; i <= m; i++) {
					result[i] = result[i-1] + minLength;
					if(rest > 0 && rest-- > -IINF) result[i]++;
				}
			}
			for (int i = 1; i < result.length; i++)
				for(int j = result[i]; j > result[i - 1]; j--)
					sb.append(j).append(" ");
			System.out.println(sb);
		} else System.out.println(-1);
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static final int IINF = Integer.MAX_VALUE;
}
