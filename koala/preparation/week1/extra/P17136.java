package koala.preparation.week1.extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P17136 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int answer;
	static int[][] arr = new int[10][10];
	static int[] use = new int[5];

	static boolean chk(int x, int y, int size){
		return x+size>10 || y+size>10;
	}

	static boolean isMatch(int size,int x, int y){
		for(int i=x; i<x+size; ++i){
			for(int j=y; j<y+size; ++j){
				if(arr[i][j]==0){
					return false;
				}
			}
		}
		return true;
	}

	static void cover(int size, int x, int y){
		for(int i=x; i<x+size; ++i){
			for(int j=y; j<y+size; ++j){
				arr[i][j] = 0;
			}
		}
	}
	static void cut(int size, int x, int y){
		for(int i=x; i<x+size; ++i){
			for(int j=y; j<y+size; ++j){
				arr[i][j] = 1;
			}
		}
	}

	static void f(int x, int y,int count){
		if(answer<count) return;
		if(x>=9 && y>9){
			answer = Math.min(answer,count);
			return;
		}
		if(y>9){
			f(x+1,0,count);
			return;
		}
		if(arr[x][y]==1){
			for(int k=5; k>=1; --k){
				if(chk(x,y,k)) continue;
				if(use[k-1]>0 &&isMatch(k,x,y)){
					cover(k,x,y);
					use[k-1]--;
					f(x,y+1,count+1);
					use[k-1]++;
					cut(k,x,y);
				}
			}
		}else{
			f(x,y+1,count);
		}
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		answer = Integer.MAX_VALUE;
		for(int i=0; i<10; ++i){
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		Arrays.fill(use,5);
		f(0,0,0);
		System.out.println(answer==Integer.MAX_VALUE?-1:answer);



	}
}

