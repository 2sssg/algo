package koala.preparation.week2.test;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P21753 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] arr;
	static int n,m,answer;

	static void f(int s, int idx, int t){
		if(t==m || idx==n){
			answer = Math.max(s,answer);
			return;
		}
		if(idx<n)
			f(s+arr[idx+1],idx+1, t+1);
		if(idx<n-1)
			f(s/2 +arr[idx+2],idx+2,t+1);

	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		answer = 0;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[n+1];
		for(int i=1; i<=n; ++i) arr[i] = Integer.parseInt(st.nextToken());
		f(1,0,0);
		System.out.println(answer);
	}
}
