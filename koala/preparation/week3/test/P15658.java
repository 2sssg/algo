package koala.preparation.week3.test;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P15658 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n,min,max;
	static int[] arr,sign,use;

	static void f(int depth){
		if(depth==n-1){
			calc();
			return;
		}
		for(int i=0; i<4; ++i){
			if(sign[i]>0){
				use[depth] = i;
				sign[i]--;
				f(depth+1);
				sign[i]++;
			}
		}
	}

	static void calc(){
		int num = arr[0];
		for(int i=1; i<n; ++i){
			switch(use[i-1]){
				case 0:
					num += arr[i];
					break;
				case 1:
					num -= arr[i];
					break;
				case 2:
					num *= arr[i];
					break;
				case 3:
					num /= arr[i];
					break;
			}
		}
		min = Math.min(min,num);
		max = Math.max(max,num);
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		n = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		sign = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		use = new int[n-1];
		f(0);
		System.out.println(max);
		System.out.println(min);
	}
}
