package koala.preparation.week4.binarysearch;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14627 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m;
	static long start,end=1000000000,result;
	static long[] arr;

	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() {return Integer.parseInt(st.nextToken());}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		est(); n = rstn(); m = rstn();
		arr = new long[n];
		for(int i=0; i<n; ++i) arr[i] = Integer.parseInt(br.readLine());
		while(start<end){
			long mid = (start+end+1)/2;
			if(Arrays.stream(arr).map(p->p/mid).sum()>=m){
				start = mid;
			}else{
				end = mid-1;
			}

		}
		System.out.println(Arrays.stream(arr).sum()-end*m);
	}
}
