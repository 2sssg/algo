package koala.preparation.week4.test;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P17245 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static long low,high;
	static long[][] arr;

	static long solve(long mid){
		long result = 0;
		for(int i=0; i<n; ++i){
			for(int j=0; j<n; ++j){
				if(arr[i][j]<mid){
					result += arr[i][j];
				}else{
					result += mid;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n = Integer.parseInt(br.readLine());
		arr = new long[n][n];
		high = Integer.MIN_VALUE;
		BigInteger com = new BigInteger("0");
		for(int i=0; i<n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; ++j){
				arr[i][j] = Integer.parseInt(st.nextToken());
				com = com.add(BigInteger.valueOf(arr[i][j]));
				low = Math.min(low,arr[i][j]);
				high = Math.max(high,arr[i][j]);
			}
		}

		//underbound
		long v;
		low = 0;
		if(BigInteger.ONE.equals(com.remainder(BigInteger.valueOf(2)))){
			v = com.divide(BigInteger.TWO).add(BigInteger.ONE).longValue();
		}else{
			v = com.divide(BigInteger.TWO).longValue();
		}
		while(low+1<high){
			long mid = (low+high)/2;
//			System.out.println("low : " + low);
//			System.out.println("mid : " + mid);
//			System.out.println("high : " + high);
//			System.out.println("solve(mid) : " + solve(mid));
//			System.out.println();
			if(solve(mid)<v) low = mid;
			else high = mid;
		}

		System.out.println(high);



	}
}
