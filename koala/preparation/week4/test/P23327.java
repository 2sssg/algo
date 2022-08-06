package koala.preparation.week4.test;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P23327 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,q;
	static long[] sum;
	static long[] fun;

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		sum = new long[n+1];
		fun = new long[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; ++i){
			long temp = Long.parseLong(st.nextToken());
			sum[i] = sum[i-1]+temp;
			fun[i] = fun[i-1] + temp*sum[i-1];
		}
		for(int i=0; i<q; i++){
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			System.out.println(fun[r]-(sum[r]-sum[l-1])*sum[l-1]-fun[l-1]);
		}
	}
}
