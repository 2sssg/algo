package koala.preparation.week4.prefixsum;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P16713 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,q,answer;
	static int[] arr;

	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() {return Integer.parseInt(st.nextToken());}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		answer = 0;
		est(); n = rstn(); q = rstn();
		arr = new int[n+1];
		est();
		for(int i=1; i<=n; ++i) arr[i] = arr[i-1]^rstn();
		while(q-->0){
			est();
			answer ^= arr[rstn()-1]^arr[rstn()];
		}
		System.out.println(answer);
	}
}
