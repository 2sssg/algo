package koala.preparation.week1.test;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1189 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int r,c,k,answer;
	static int[][] arr;
	static boolean[][] visit;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};

	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() {return Integer.parseInt(st.nextToken());}

	static void f(int depth, int x, int y){
		if(depth == k){
			if(x==0 && y==c-1){
				answer++;
			}
			return;
		}
		for(int i=0; i<4; ++i){
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0 || ny<0 || nx>=r || ny>=c) continue;
			if(visit[nx][ny] || arr[nx][ny]==1) continue;
			visit[nx][ny] = true;
			f(depth+1,nx,ny);
			visit[nx][ny] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		est(); r = rstn(); c = rstn(); k = rstn();
		arr = new int[r][c];
		visit = new boolean[r][c];
		for(int i=0; i<r; ++i) arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(p->p.equals("T")?1:0).toArray();
		visit[r-1][0] = true;
		f(1,r-1,0);
		System.out.println(answer);
	}
}
