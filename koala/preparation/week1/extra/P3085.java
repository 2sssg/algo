package koala.preparation.week1.extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map.Entry;

public class P3085 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int[][] arr;

	static int maxEat(){
		int maxV = 0;
		for(int i=0; i<n; ++i){
			int tempmax = 1;
			int num = arr[i][0];
			for(int j=1; j<n; ++j){
				if(num==arr[i][j]){
					tempmax++;
				}else{
					maxV = Math.max(tempmax,maxV);
					tempmax = 1;
					num = arr[i][j];
				}
			}
			maxV = Math.max(tempmax,maxV);
		}
		for(int i=0; i<n; ++i){
			int tempmax = 1;
			int num = arr[0][i];
			for(int j=1; j<n; ++j){
				if(num==arr[j][i]){
					tempmax++;
				}else{
					maxV = Math.max(tempmax,maxV);
					tempmax = 1;
					num = arr[j][i];
				}
			}
			maxV = Math.max(tempmax,maxV);
		}
		return maxV;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i=0; i<n; ++i)
			arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(p->(int)p.charAt(0)).toArray();

		int answer = 0;
		for(int i=0; i<n; ++i){
			for(int j=0; j<n-1; ++j){
				arr[i][j] = arr[i][j]^arr[i][j+1];
				arr[i][j+1] = arr[i][j]^arr[i][j+1];
				arr[i][j] = arr[i][j]^arr[i][j+1];
				for(int[] a: arr){
					System.out.println(Arrays.toString(a));
				}
				System.out.println();
//				answer = Math.max(answer, maxEat());
				if(answer<maxEat()){
					answer = maxEat();
					System.out.println("answer : " + answer);
					System.out.println("maxEat : " + maxEat());
				}
				arr[i][j] = arr[i][j]^arr[i][j+1];
				arr[i][j+1] = arr[i][j]^arr[i][j+1];
				arr[i][j] = arr[i][j]^arr[i][j+1];
			}
		}
		System.out.println("=============");
		for(int i=0; i<n; ++i){
			for(int j=0; j<n-1; ++j){
				arr[j][i] = arr[j][i]^arr[j+1][i];
				arr[j+1][i] = arr[j][i]^arr[j+1][i];
				arr[j][i] = arr[j][i]^arr[j+1][i];
				for(int[] a: arr){
					System.out.println(Arrays.toString(a));
				}
				System.out.println();
				if(answer<maxEat()){
					answer = maxEat();
				}
				arr[j][i] = arr[j][i]^arr[j+1][i];
				arr[j+1][i] = arr[j][i]^arr[j+1][i];
				arr[j][i] = arr[j][i]^arr[j+1][i];
			}
		}

		System.out.println(answer);
	}
}
