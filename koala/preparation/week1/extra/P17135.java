package koala.preparation.week1.extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P17135 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m,d,answer;
	static int[][] arr,gamearr;

	static int game(){
		int killCount = 0;
		while (true) {
			for(int i=0; i<m; ++i){
				if(gamearr[n][i]==1){
					int dist = Integer.MAX_VALUE;
					int x=-1;
					int y=-1;
					for(int j=0; j<m; ++j){
						for(int k=0; k<n; ++k){
							if(Math.abs(gamearr[k][j]) == 1){
								if(Math.abs(k-n)+Math.abs(i-j)<dist && Math.abs(k-n)+Math.abs(i-j)<=d){
									dist = Math.abs(k-n)+Math.abs(i-j);
									x = k; y = j;
								}
							}
						}
					}
					if(x!=-1 && y!=-1){
						gamearr[x][y] = -1;
					}
				}
			}
//			for(int[] t: gamearr){
//				System.out.println(Arrays.toString(t));
//			}
//			System.out.println();
			for(int i=0; i<m; ++i){
				if(gamearr[n-1][i]==-1){
					killCount++;
				}
			}
			int enemyCount = 0;
			for(int i=n-2; i>=0; --i){
				for(int j=m-1; j>=0; --j){
					if(gamearr[i][j] == 1){
						enemyCount++;
					}
					if(gamearr[i][j]==-1){
						killCount++;
						gamearr[i][j] = 0;
					}
					gamearr[i+1][j] = gamearr[i][j];
				}
			}
			for(int i=0; i<m; ++i){
				gamearr[0][i] = 0;
			}
			if(enemyCount==0) break;
		}
		return killCount;

	}

	static void arch(int depth, int cur){
		if(depth==3){
			for(int i=0; i<=n; ++i){
				gamearr[i] = arr[i].clone();
			}
			answer = Math.max(game(),answer);
			return;
		}
		for(int i=cur; i<m; ++i){
			arr[n][i] = 1;
			arch(depth+1, i+1);
			arr[n][i] = 0;
		}
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		answer = 0;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken()); d = Integer.parseInt(st.nextToken());
		arr = new int[n+1][m];
		gamearr = new int[n+1][m];
		for(int i=0; i<n; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; ++j){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		arch(0,0);
		System.out.println(answer);

	}
}
