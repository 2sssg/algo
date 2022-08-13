package koala.preparation.week6.bfsdfs;

import java.util.*;

public class P14266 {
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static Queue<Pair> q = new ArrayDeque<>();
	static int[][] d = new int[1001][1001];

	static int n;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n=s.nextInt();
		q.add(new Pair(1,0));
		for(int i=0; i<1001; ++i) Arrays.fill(d[i],-1);
		d[1][0] = 0;
		while(!q.isEmpty()){
			Pair p = q.poll();
			if(p.x==n) {
				System.out.println(d[p.x][p.y]);
				return;
			}
			if(p.x + p.y <= 1000 && d[p.x+p.y][p.y]==-1){
				q.add(new Pair(p.x+p.y, p.y));
				d[p.x+p.y][p.y] = d[p.x][p.y]+1;
			}

			if(d[p.x][p.x] == -1){
				q.add(new Pair(p.x,p.x));
				d[p.x][p.x] = d[p.x][p.y]+1;
			}

			if(p.x-1>=0 && d[p.x-1][p.y] == -1){
				q.add(new Pair(p.x-1, p.y));
				d[p.x-1][p.y] = d[p.x][p.y]+1;
			}

		}


	}
	////////////////////////////////bfs/////////////////////////////////////////////
	////////////////////////////////bfs/////////////////////////////////////////////
}
