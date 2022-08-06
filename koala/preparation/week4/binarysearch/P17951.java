package koala.preparation.week4.binarysearch;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class P17951 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] arr;
	static int n,k;
	static int low,high;
	static TreeSet<Integer> ts;

	static void init() throws IOException {
		ts = new TreeSet<>();
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		arr[0] = Integer.parseInt(st.nextToken());
		for(int i=1; i<n; ++i){
			arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<n; ++i) ts.add(arr[i]);

	}

	static boolean solve(int mid){
//		System.out.println("mid : " + mid);
		int sum = 0;
		int count = 0;
		while(ts.ceiling(sum+mid) != null){
			sum = ts.ceiling(sum+mid);
			count++;
		}
//		System.out.println("count : " + count);
//		System.out.println();
		return count>=k;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
//		System.out.println(Arrays.toString(arr));
		low = 0;
		high = arr[n-1];
		while(low<high){
			int mid = (low+high+1)/2;
			System.out.println("low : " +low);
			System.out.println("mid : " + mid);
			System.out.println("high : " + high);
			if(solve(mid)){
				low = mid;
			}else{
				high = mid-1;
			}
		}
		System.out.println(low);
	}
}
