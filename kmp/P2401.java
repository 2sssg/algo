package kmp;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2401 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String s;
	static String[] p;
	static int n;
	static int[] dp;
	static int[][] pi;
	static int[] memory;

	static void init() throws IOException {
		s = br.readLine();
		n = Integer.parseInt(br.readLine());
		dp = new int[s.length()];
		p = new String[n];
		for(int i=0; i<n; ++i) p[i] = br.readLine();
		pi = new int[n][10005];
		memory = new int[505];
	}



	static void makePi(){
		for(int i=0; i<n; ++i){
			int idx = 0;
			for(int j=1; j<p[i].length(); ++j){
				while(idx>0 && p[i].charAt(j)!= p[i].charAt(idx)) idx = pi[i][idx-1];
				if(p[i].charAt(j) == p[i].charAt(idx)) pi[i][j] = ++idx;
			}
		}
	}

	static void kmp(){
		int n1 = s.length();

		for(int i=0; i<n1; ++i){
			if(i>0) dp[i] = dp[i-1];
			for(int j=0; j<n; ++j){
				while (memory[j] > 0 && s.charAt(i) != p[j].charAt(memory[j])) memory[j] = pi[j][memory[j] - 1];
				if(s.charAt(i) == p[j].charAt(memory[j])) {
					if(memory[j] == p[j].length()-1){
						int temp = i - p[j].length() >= 0 ? dp[i - p[j].length()] : 0;
						temp += p[j].length(); // 이번에 들어가는 단어
						dp[i] = Math.max(dp[i], temp); // dp 값 최신화
						memory[j] = pi[j][memory[j]];
					}else{
						memory[j]++;
					}
				}
			}
		}
	}


	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		makePi();
		kmp();
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[s.length()-1]);
	}
}
