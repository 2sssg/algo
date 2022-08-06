package koala.preparation.week3.test;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15565 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,k;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int lion = arr[0]==1?1:0;
		int answer = Integer.MAX_VALUE;
		int en = 1;
		for(int be=0; be<n; ++be){
			while(en<n && lion<k){
				lion += arr[en]==1?1:0;
				en++;
			}

			if(lion>=k){
				answer = Math.min(answer,en-be);
			}
			lion -= arr[be]==1?1:0;
		}
		System.out.println(answer==Integer.MAX_VALUE?-1:answer);
	}
}
