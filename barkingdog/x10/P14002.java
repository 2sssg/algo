package barkingdog.x10;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P14002 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static int[] arr;
	static int[] path;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		N = Integer.parseInt(br.readLine());
		path = new int[N];
		dp = new int[N];
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.fill(path,-1);
		int maxValue = 0;
		int idx = 0;
		for(int i=0; i<N; ++i){
			for(int j=0; j<i; ++j){
				if(arr[j]<arr[i] && dp[j]+1>dp[i]){
					dp[i] = dp[j]+1;
					path[i] = j;
				}
			}
			if(maxValue<dp[i]){
				maxValue = dp[i];
				idx = i;
			}
		}
		bw.write(String.valueOf(maxValue+1));
		bw.write("\n");
		LinkedList<Integer> l = new LinkedList<>();
		while(path[idx]!=-1){
			l.addFirst(idx);
			idx = path[idx];
		}
		l.addFirst(idx);
		for(int i: l){
			bw.write(String.valueOf(arr[i]));
			bw.write(" ");
		}
		bw.flush();
		bw.close();
	}
}
