package koala.preparation.week1.extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P17135 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m,k,answer;
	static int[][] arr,gamearr;

	static int game(){
		int killCount = 0;
		while (true) {
			for(int i=0; i<m; ++i){
				if(arr[n][i]==1){
					int dist = Integer.MAX_VALUE;
					int x=-1;
					int y=-1;
					for(int j=0; j<m; ++j){
						for(int k=0; k<n; ++k){
							if(Math.abs(arr[k][j]) == 1){
								if(Math.abs(k-n)+Math.abs(i-j)<dist){
									dist = Math.abs(k-n)+Math.abs(i-j);
									x = k; y = j;
								}
							}
						}
					}
					arr[x][y] = -1;
				}
			}
			for(int i=0; i<m; ++i){
				if(arr[n-1][i]==-1){
					killCount++;
				}
			}
			int enemyCount = 0;
			for(int i=n-2; i>=0; --i){
				for(int j=m-1; j>=0; --j){
					if(arr[i][j] == 1){
						enemyCount++;
					}
					if(arr[i][j]==-1){
						killCount++;
						arr[i][j] = 0;
					}
					arr[i-1][j] = arr[i][j];
				}
			}
			for(int i=0; i<m; ++i){
				arr[0][i] = 0;
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
		int enemyCount = 0;
		answer = 0;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
		arr = new int[n+1][m];
		for(int i=0; i<n; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; ++j){
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1){
					enemyCount++;
				}
			}
		}
		System.out.println(answer);

	}
}
