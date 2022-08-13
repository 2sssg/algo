package koala.preparation.week6.bfsdfs;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P17458 {
	static int n,m,v1,v2;
	static int[][] arr;
	static int[][][] d;


	static void init() throws IOException {
		arr = new int[n=rstn()][m=rstn()];
		d = new int[n][m][3];
		for(int i=0; i<n; ++i) arr[i] = ra();
		for(int j=0; j<m; ++j) d[0][j][0] = d[0][j][1] =d[0][j][2] = arr[0][j];
	}

	static void dp(){
		for(int i=1; i<n; ++i){
			d[i][0][1] = d[i-1][0][2] + arr[i][0];
			d[i][0][2] = Math.min(d[i-1][1][0],d[i-1][1][1]) + arr[i][0];
			d[i][m-1][0] = Math.min(d[i-1][m-2][1],d[i-1][m-2][2])+arr[i][m-1];
			d[i][m-1][1] = d[i-1][m-1][0] + arr[i][m-1];
			for(int j=1; j<m-1; ++j){
				for(int k=0; k<3; ++k){
					tn(k);
					d[i][j][k] = Math.min(d[i-1][j+(k-1)][v1],d[i-1][j+(k-1)][v2])+arr[i][j];
				}
			}
		}
	}

	static void tn(int k){
		if(k==0) {v1=1;v2=2;}
		else if(k==1) {v1=0; v2=2;}
		else {v1=0;v2=1;}
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		dp();
		int answer = Integer.MAX_VALUE;
		for(int i=0; i<n; ++i){
			for(int j=0; j<m; ++j){
				System.out.print(d[i][j][0] + " ");
				System.out.print(d[i][j][1] + " ");
				System.out.print(d[i][j][2] + "   ");
//				answer = Math.min(d[n-1][j][0],answer);
//				answer = Math.min(d[n-1][j][1],answer);
//				answer = Math.min(d[n-1][j][2],answer);
			}
			System.out.println();
		}

//		System.out.println();
//		System.out.println(answer);

	}
	////////////////////////////////bfs/////////////////////////////////////////////
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	////////////////////////////////bfs/////////////////////////////////////////////
}
