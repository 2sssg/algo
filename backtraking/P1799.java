package backtraking;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P1799 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,answer;
	static int[][] arr;
	static int[][] no;
	static int[] dx = {-1,1,-1,1};
	static int[] dy = {-1,-1,1,1};

	static void addQueen(int x, int y){
		no[x][y]++;
		for(int i=0; i<4; ++i){
			for(int j=1; ;++j){
				if(x+dx[i]*j<0 || y+dy[i]*j<0 || x+dx[i]*j>=N || y+dy[i]*j>=N) break;
				no[x+dx[i]*j][y+dy[i]*j]++;
			}
		}

	}
	static void removeQueen(int x, int y){
		no[x][y]--;
		for(int i=0; i<4; ++i){
			for(int j=1; ;++j){
				if(x+dx[i]*j<0 || y+dy[i]*j<0 || x+dx[i]*j>=N || y+dy[i]*j>=N) break;
				no[x+dx[i]*j][y+dy[i]*j]--;
			}
		}
	}

	static void fir(){
		for(int i=0; i<N; ++i){
			if(arr[i][i] == 1 && no[i][i]==0){
				addQueen(i,i);
				f(1,1);
				removeQueen(i,i);
			}
		}
		f(1,0);
	}
//	static void sec(){
//		for(int i=N-1; i>=0; --i){
//			if(arr[N-1-i][i] == 1 && no[N-1-i][i]==0){
//				addQueen(N-1-i,i);
//				f3(1,1);
//				removeQueen(N-1-i,i);
//			}
//		}
//		f3(1,0);
//	}


	static void f(int cur,int count){
		if(cur==N){
			f2(1,count);
			return;
		}
		for(int i=cur; i<N; ++i){
			int curX = 0;
			int curY = i;
			while(curX<N && curY<N){
				if(arr[curX][curY] == 1 && no[curX][curY]==0){
					addQueen(curX,curY);
					f(cur+1,count+1);
					removeQueen(curX,curY);
				}
				curX++;
				curY++;
			}
			if(8-cur+count>answer){
				f(cur+1,count);
			}
		}
	}

//	static void f3(int cur,int count){
////		for(int i=0; i<N; ++i){
////			System.out.println(Arrays.toString(no[i]));
////		}
////		System.out.println();
//		if(cur==N){
//			f4(1,count);
//			return;
//		}
//		for(int i=cur; i<N; ++i){
//			int curX = 0;
//			int curY = N-1-i;
//			while(curX<N && curY>=0){
//				if(arr[curX][curY] == 1 && no[curX][curY]==0){
//					addQueen(curX,curY);
//					f3(cur+1,count+1);
//					removeQueen(curX,curY);
//				}
//				curX++;
//				curY--;
//			}
//			if(8-cur+count>answer){
//				f3(cur+1,count);
//			}
//		}
//	}

	static void f2(int cur,int count){
		if(cur==N){
			answer = Math.max(answer,count);
			return;
		}
		for(int i=cur; i<N; ++i){
			int curX = i;
			int curY = 0;
			while(curX<N && curY<N){
				if(arr[curX][curY] == 1 && no[curX][curY]==0){
					addQueen(curX,curY);
					f2(cur+1,count+1);
					removeQueen(curX,curY);
				}
				curX++;
				curY++;
			}
			if(4-cur+count>answer){
				f2(cur+1,count);
			}
		}
	}

//	static void f4(int cur,int count){
//		if(cur==N){
////			System.out.println("answer2 : "+ answer + "count2 : "+ count);
//			answer = Math.max(answer,count);
//			return;
//		}
//		for(int i=cur; i<N; ++i){
//			int curX = i;
//			int curY = N-1;
//			while(curX<N && curY>=0){
//				if(arr[curX][curY] == 1 && no[curX][curY]==0){
//					addQueen(curX,curY);
//					f4(cur+1,count+1);
//					removeQueen(curX,curY);
//				}
//				curX++;
//				curY--;
//			}
//			if(4-cur+count>answer){
//				f4(cur+1,count);
//			}
//		}
//	}


	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		answer = 0;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		no = new int[N][N];
		for(int i=0; i<N; ++i){
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		fir();
		for(int i=0; i<3; ++i){
			int[][] temp = new int[N][N];
			for(int j=0; j<N; ++j){
				temp[j] = arr[j].clone();
			}
			for(int n=0; n<N; ++n){
				for(int m=0; m<N; ++m){
					arr[n][m] = temp[m][N-1-n];
				}
			}
			fir();
		}
		System.out.println(answer);



	}
}
