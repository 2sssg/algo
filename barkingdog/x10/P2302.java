package barkingdog.x10;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2302 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N,M;
	static int[] arr;
	static boolean[] seat;
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		N = Integer.parseInt(br.readLine());

		arr = new int[N+1];
		seat = new boolean[N+1];
		M = Integer.parseInt(br.readLine());
		if(N==1){
			System.out.println(1);
			return;
		}else if(N==2){
			if(M>0){
				System.out.println(1);
			}else{
				System.out.println(2);
			}
			return;
		}

		while(M-->0){
			int vip = Integer.parseInt(br.readLine());
			seat[vip] = true;
		}
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 2;
		for (int i = 3; i <= N; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}

		int cnt = 0;
		int answer = 1;
		for(int i=1; i<N+1; ++i){
			if(!seat[i]){
				cnt++;
			}else{
				answer *= arr[cnt];
				cnt = 0;
			}
		}
		answer *= arr[cnt];
		System.out.println(answer);


	}
}
