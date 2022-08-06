package koala.preparation.week4.prefixsum;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P19951 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m;
	static int[] arr;
	static int[] sum;

	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() {return Integer.parseInt(st.nextToken());}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		est();
		n=rstn(); m=rstn();

		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		sum = new int[n+2];
		while(m-->0){
			int[] q = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			sum[q[0]] += q[2];
			sum[q[1]+1] -= q[2];
		}
		for(int i=0; i<n; ++i){
			sum[i+1]=sum[i]+sum[i+1];
			arr[i] += sum[i+1];
		}
		System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]",""));

	}
}
