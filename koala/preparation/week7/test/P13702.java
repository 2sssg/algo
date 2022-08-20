package koala.preparation.week7.test;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P13702 {
	static int n,k;
	static int[] arr;

	static void init() throws IOException {
		arr = new int[n=rstn()]; k=rstn();
		for(int i=0; i<n; ++i) arr[i] = rn();
	}

	static long solve(long mid){
		long ret = 0;
		for(int i=0; i<n; ++i){
			ret += arr[i]/mid;
		}
		return ret;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		long s = 0;
		long e = Long.MAX_VALUE/2;
		while(s+1<e){
			long mid = (s+e)/2;
			if(solve(mid)<k) e=mid;
			else s = mid;
		}
		System.out.println(s);
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
}
