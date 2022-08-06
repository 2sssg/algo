package extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class P14003 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int n;
	static int[] arr;
	static int[] l;
	static int[] dp;
	static int upperBound(int num,int idx){
		int low=-1, high = idx;
		while(low+1<high){
			int mid = (low+high)/2;
			if(l[mid]<=num) low = mid;
			else high = mid;
		}
		return high;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		l = new int[n];
		dp = new int[n];
		l[0] = arr[0];
		int idx = 0;
		dp[0] = 1;
		for(int i=1; i<n; ++i){
			if(l[idx]<arr[i]){
				l[++idx] = arr[i];
				dp[i] = idx+1;
			}else{
				int temp = upperBound(arr[i],idx);
				l[temp] = arr[i];
				dp[i] = temp+1;
			}
		}
		bw.write(String.valueOf(idx+1));
		bw.write("\n");
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack();
		int findId = idx ;
		for(int i = n-1; findId>=0 && i > 0; i--){
			if(dp[i] == findId){
				findId--;
				stack.push(arr[dp[i]]);
			}
		}
		while (!stack.isEmpty()){
			sb.append(stack.pop() + " ");
		}
		bw.write(sb.toString());

		bw.flush();
//		Arrays.fill(temp,Integer.MAX_VALUE);
//		for(int i=n-1; i>=0; --i){
//			if(dp[i]==0&&temp[dp[i]+1]>arr[i]){
//				temp[dp[i]] = arr[i];
//			}else if(temp[dp[i]+1]>arr[i]&&(temp[dp[i]-1]<arr[i]||temp[dp[i]-1]==Integer.MAX_VALUE)){
//				temp[dp[i]] = arr[i];
//			}
//		}
//		for(int i=0; i<idx+1; ++i){
//			bw.write(String.valueOf(temp[i]));
//			bw.write(" ");
//		}
		bw.flush();
	}
}