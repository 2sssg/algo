package koala.preparation.week4.binarysearch;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2343 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m;
	static int start,end;
	static int[] arr;

	static int calc(int minuate){
		int count = 1;
		int sum = 0;
		for(int i=0; i<n; ++i){
			if(sum+arr[i]>minuate){
				count++;
				if(arr[i]>minuate){
					return m+1;
				}
				sum = arr[i];
			}else{
				sum += arr[i];
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		start = 1;
		end = Arrays.stream(arr).sum();
		while(start<end){
			int mid = (start+end)/2;
			if(calc(mid)>m)start = mid+1;
			else end = mid;
		}
		System.out.println(end);
	}
}
