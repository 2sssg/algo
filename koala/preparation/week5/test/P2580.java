package koala.preparation.week5.test;

import library.UsefulForAlgo;
import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2580 {
	static class Pair{
		int x,y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[][] arr = new int[9][9];

	static int[] usable(int x, int y){
		int[] ret = new int[10];
		for(int j=0; j<9; ++j) ret[arr[x][j]]++;
		for(int i=0; i<9; ++i) ret[arr[i][y]]++;
		int sx = (x/3)*3;
		int sy = (y/3)*3;
		for(int i=0; i<3; ++i){
			for(int j=0; j<3; ++j){
				ret[arr[sx+i][sy+j]]++;
			}
		}
		return ret;
	}

	static boolean chk(){
		for(int i=0; i<9; ++i){
			for(int j=0; j<9; ++j){
				if(arr[i][j] == 0) return false;
			}
		}
		return true;
	}

	static void f(int x, int y){

		for(int i=x; i<9; ++i){
			for(int j=y; j<9; ++j){
				if(arr[i][j]==0){
					int[] use = usable(i,j);
					for(int k=1; k<10; ++k){
						if(use[k]==0){
							arr[i][j] = k;
							if(chk()) {
								for(int idx=0; idx<9; ++idx){
									System.out.println(Arrays.toString(arr[idx]).replaceAll("[\\[\\],]",""));
								}
								System.exit(0);
							}
							f(i,j+1);
							arr[i][j] = 0;
						}
					}
					return;
				}
			}
			y=0;
		}
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		for(int i=0; i<9; ++i) arr[i] = ra();
		f(0,0);

	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() {return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
}
