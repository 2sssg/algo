package koala.preparation.week4.test;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P5212 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m;
	static int[][] arr;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for(int i=0; i<n; ++i) arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(p->p.equals(".")?0:1).toArray();

		int[][] temparr = new int[n][m];

		for(int i=0; i<n; ++i){
			for(int j=0; j<m; ++j){
				int count = 0;
				for(int k=0; k<4; ++k){
					int nx = i+dx[k];
					int ny = j+dy[k];
					if(nx<0 || ny<0 || nx>=n || ny>=m) {
						count++;
						continue;
					}
					if(arr[nx][ny]==0) count++;
				}
				temparr[i][j] = count>=3?arr[i][j]-1:arr[i][j];
			}
		}
		int minx=Integer.MAX_VALUE, miny = Integer.MAX_VALUE, maxx=Integer.MIN_VALUE, maxy=Integer.MIN_VALUE;
		for(int i=0; i<n; ++i){
			for(int j=0; j<m; ++j){
				if(temparr[i][j]==1){
					minx = Math.min(minx,i);
					miny = Math.min(miny,j);
					maxx = Math.max(maxx,i);
					maxy = Math.max(maxy,j);
				}
			}
		}
		for(int i=minx; i<=maxx; ++i){
			for(int j=miny; j<=maxy; ++j){
				System.out.print(temparr[i][j]==1?"X":".");
			}
			System.out.println();
		}
	}
}
