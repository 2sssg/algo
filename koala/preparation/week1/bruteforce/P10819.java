package koala.preparation.week1.bruteforce;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10819 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] arr,temparr;
	static boolean[] visit;
	static int n,answer;

	static int sum(){
		int sum = 0;
		for(int i=0; i<n-1; ++i){
			sum += Math.abs(temparr[i]-temparr[i+1]);
		}
		return sum;
	}

	static void f(int depth){
		if(depth==n){
			answer = Math.max(answer,sum());
			return;
		}
		for(int i=0; i<n; ++i){
			if(visit[i]) continue;
			visit[i] = true;
			temparr[depth] = arr[i];
			f(depth+1);
			visit[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		answer = 0;
		n = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		visit = new boolean[n];
		temparr = new int[n];
		f(0);
		System.out.println(answer);
	}
}
