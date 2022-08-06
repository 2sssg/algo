package koala.preparation.week3.twopointer;

import static library.UsefulForAlgo.*;
import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14465 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,k,b;
	static int[] arr;
	static int[] err;
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		arr = new int[n+1];
		err = new int[b+1];
		for(int i=0; i<b; ++i) err[i] = Integer.parseInt(br.readLine());
		err[b] = Integer.MAX_VALUE;
		Arrays.sort(err);
		int idx = 0;
		for(int i=1; i<=n; ++i){
			if(i==err[idx]){
				idx++;
				arr[i] = arr[i-1];
			}else{
				arr[i] = arr[i-1]+1;
			}
		}
		int answer = n;
		int en = k;
		for(int i=0; en<=n; ++i){
			answer = Math.min(k-(arr[en]-arr[i]),answer);
			en++;
		}
		System.out.println(answer);
	}
}
