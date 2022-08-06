package koala.preparation.week5.test;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15810 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m;
	static int[] arr;

	static long solve(long mid){
		long ret = 0;
		for(int m: arr) ret += mid/m;
		return ret;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		est(); n=rstn(); m=rstn(); arr = ra();
		long s = 0;
		long e = 1000000000005L;
		while(s+1<e){
			long mid = (s+e)/2;
			if(solve(mid)<m) s = mid;
			else e = mid;
		}
		System.out.println(e);
	}

	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() {return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
}
