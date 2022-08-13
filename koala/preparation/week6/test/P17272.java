package koala.preparation.week6.test;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P17272 {
	static long n;
	static int m;
	static long[][] arr,answer;
	static final long mod = 1000000007;

	static long[][] mult(long[][] a, long[][] b){
		long[][] ans = new long[m+1][m+1];
		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= m; j++)
				for (int k = 1; k <= m; k++)
					ans[i][j] = (ans[i][j] + (a[i][k] * b[k][j] % mod)) % mod;
		return ans;
	}

	static long[][] getAnswer(long N) {
		if (N == 1) return arr;
		long[][] tmpMatrix = getAnswer(N / 2);
		long[][] ans = mult(tmpMatrix, tmpMatrix);
		if ((N & 1)==1) ans = mult(ans, arr);
		return ans;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n=rstn(); m=(int)rstn();
		arr = new long[m+1][m+1];
		arr[1][1] = arr[1][m] = 1;
		for (int i = 1; i < m; i++) arr[i + 1][i] = 1;
		answer = getAnswer(n);
		System.out.println(answer[1][1]);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static long rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Long.parseLong(st.nextToken());}
}
