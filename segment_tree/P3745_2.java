package segment_tree;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P3745_2 {
	static int n;
	static int[] arr,dp;


	static void init() throws IOException {
		n=rn();
		arr = new int[n];
		dp = new int[n];
		Arrays.fill(dp,Integer.MAX_VALUE);
		for(int i=0; i<n; ++i) arr[i] = rstn();
		dp[0] = arr[0];
	}

	static int ub(int num){
		int s = -1;
		int e = n-1;
		while(s+1<e){
			int mid = (s+e)/2;
//			System.out.println("s : " + s);
//			System.out.println("mid : " + mid);
//			System.out.println("e : " + e);
//			System.out.println("dp[mid] : " + dp[mid]);
//			System.out.println("num : " + num);
//			System.out.println();
			if(dp[mid]<=num) s=mid;
			else e=mid;
		}
		return e;
	}


	public static void main(String[] args) {
		br = Source.getBufferedReader();
		while(true){
			try{
				init();
				int idx = 0;
				for(int i=1; i<n; ++i){
					if(dp[idx]<arr[i]) {
						dp[++idx] = arr[i];
					}else{
						dp[ub(arr[i])] = arr[i];
					}
//					System.out.println(Arrays.toString(dp));
				}
//				System.out.println(Arrays.toString(dp));
				System.out.println(idx+1);
			}catch (Exception e){
				break;
			}
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
}
