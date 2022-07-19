package koala.preparation.week3.simulation;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P23291 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,k;
	static int[][] arr;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};

	static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[101][101];
		st = new StringTokenizer(br.readLine());
		for(int i=0; st.hasMoreTokens(); ++i){
			arr[0][i] = Integer.parseInt(st.nextToken());
		}
	}

	static void fill1(){
		List<Integer> idxs = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		for(int i=0; i<n; ++i){
			if(arr[0][i]==min){
				idxs.add(i);
			}else if(arr[0][i]<min){
				idxs.clear();
				idxs.add(i);
				min = arr[0][i];
			}
		}
		for(int idx: idxs) arr[0][idx]++;
	}

	static void move1(){
		boolean flag = false;
		int r = 1;
		int c = 1;
		while(true){
			int[][] temparr = new int[c][r];
			for(int i=0; i<r; ++i){
				for(int j=0; j<c; ++j){
					temparr[j][r-i-1] = arr[i][j];
				}
			}
			for(int i=0; i<c; ++i){
				for(int j=0; j<r; ++j){
					arr[i][j] = temparr[i][j];
				}
			}
			for(int j = c; j<n; ++j){
				arr[c][j-c] = arr[r-1][j];
			}
			for(int i = r; i<101; ++i){
				for(int j=0; j<c; ++j){
					arr[j][i] = 0;
				}
			}

			if(!flag) r++;
			else c++;
			flag = !flag;
			if(r>n-(r*c)){
				break;
			}
		}
	}

	static void makeup(){
		int[][] temparr = new int[n][n];
		for(int x=0; x<n; ++x){
			for(int y=0; y<n; ++y){
				if(arr[x][y]==0) continue;
				for(int k=0; k<4; ++k){
					int nx = x+dx[k];
					int ny = y+dy[k];
					if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
					if(arr[nx][ny]>=arr[x][y]) continue;
					if(arr[nx][ny]==0) continue;
					int d = (arr[x][y]-arr[nx][ny])/5;
					if(d>0){
						temparr[nx][ny] += d;
						temparr[x][y] -= d;
					}
				}
			}
		}

		for(int i=0; i<n; ++i){
			for(int j=0; j<n; ++j){
				arr[i][j] += temparr[i][j];
			}
		}
	}

	static void makeOneLine(){
		int[] temparr = new int[101];
		int idx = 0;
		for(int j=0; j<n; ++j){
			for(int i=n; i>=0; --i){
				if(arr[i][j]==0) continue;
				temparr[idx++] = arr[i][j];
				arr[i][j] = 0;
			}
		}
		arr[0] = temparr.clone();
	}

	static void move2(){
		int r = 1;
		int c = n/2;
		for(int count=0; count<2; ++count){
			int[][] temparr = new int[r][c];
			for(int i=0; i<r; ++i){
				for(int j=0; j<c; ++j){
					temparr[r-i-1][c-j-1] = arr[i][j];
				}
			}
			for(int i=0; i<r; ++i){
				for(int j=0; j<c; ++j){
					arr[i+r][j] = arr[i][j+c];
					arr[i][j+c] = 0;
				}
			}
			for(int i=0; i<r; ++i){
				for(int j=0; j<c; ++j){
					arr[i][j] = temparr[i][j];
				}
			}
			r++;
			c /= 2;

		}
	}

	static int max_min(){
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int y=0; y<n; ++y){
			int cur = arr[0][y];
			max = Math.max(cur,max);
			min = Math.min(cur,min);
		}
		return max-min;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		int answer = 0;
		init();
		while(max_min()>k){
			answer++;
			fill1();
			move1();
			makeup();
			makeOneLine();
			move2();
			makeup();
			makeOneLine();
		}
		System.out.println(answer);
	}


	static void testPrintArr(){
		for(int i=0; i<n; ++i){
			for(int j=0; j<n; ++j){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
