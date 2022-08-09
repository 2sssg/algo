package koala.preparation.week6;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import library.UsefulForAlgo;

public class P1194 {
	static class Pair{
		int x,y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pair{" +
				"x=" + x +
				", y=" + y +
				'}';
		}
	}
	static int n,m;
	static char[][] arr;
	static HashMap<Character, List<Pair>> key;
	static Queue<Pair> q = new ArrayDeque<>();
	static int[][] dist;
	static final int translate = 32;

	static void init() throws IOException {
		key = new HashMap<>();
		q.clear();
		est(); n=rstn(); m=rstn();
		arr = new char[n][m];
		dist = new int[n][m];
		for(int i='a'; i<='z'; ++i) key.put((char)i,new ArrayList<>());
		for(int i=0; i<n; ++i) Arrays.fill(dist[i],-1);
		for(int i=0; i<n; ++i) arr[i] = br.readLine().toCharArray();
		for(int i=0; i<n; ++i) for(int j=0; j<m; ++j) if(arr[i][j]=='0') q.add(new Pair(i,j));
		dist[q.peek().x][q.peek().y] = 0;
	}

	static int bfs(){
		while(!q.isEmpty()){
			Pair p = q.poll();
			for(int i=0; i<4; ++i){
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				if(chk(nx,ny,n,m)) continue;
				if(dist[nx][ny] != -1)continue;
				if(arr[nx][ny]=='#') continue;
				if('A'<=arr[nx][ny] && arr[nx][ny]<='Z'){
					char curkey = (char)(arr[nx][ny]+translate);
					if(key.get(curkey).size()>0) bfs2(curkey);
				}
				else if('a'<=arr[nx][ny] && arr[nx][ny]<='z'){
					key.get(arr[nx][ny]).add(new Pair(nx,ny));
					dist[nx][ny] = dist[p.x][p.y]+1;
					q.add(new Pair(nx,ny));
					char curkey = arr[nx][ny];
					arr[nx][ny] = '.';
					bfs2(curkey);
				}
				else if(arr[nx][ny] == '1') {
					return dist[p.x][p.y]+1;
				}else{
					dist[nx][ny] = dist[p.x][p.y]+1;
					q.add(new Pair(nx,ny));
				}
			}
		}
		return -1;
	}

	static void bfs2(char curkey){
		Queue<Pair> tempQ = new ArrayDeque<>(key.get(curkey));
		int[][] tempdist = new int[n][m];
		for(int x=0; x<n; ++x) Arrays.fill(tempdist[x],-1);
		for(Pair np : key.get(curkey)) tempdist[np.x][np.y] = dist[np.x][np.y];
		while(!tempQ.isEmpty()){
			Pair tempP = tempQ.poll();
			if(arr[tempP.x][tempP.y]==curkey-translate) {
				arr[tempP.x][tempP.y] = '.';
				dist[tempP.x][tempP.y] = tempdist[tempP.x][tempP.y];
				q.add(new Pair(tempP.x,tempP.y));
			}
			for(int j=0; j<4; ++j) {
				int tempnx = tempP.x+dx[j];
				int tempny = tempP.y+dy[j];
				if(chk(tempnx,tempny,n,m)) continue;
				if(dist[tempnx][tempny]== -1 && arr[tempnx][tempny]!=curkey-translate) continue;
				if(tempdist[tempnx][tempny] != -1 )continue;
				if(arr[tempnx][tempny]=='#') continue;
				tempQ.add(new Pair(tempnx,tempny));
				tempdist[tempnx][tempny] = tempdist[tempP.x][tempP.y]+1;
				dist[tempnx][tempny] = tempdist[tempnx][tempny];
			}
		}
	}


	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		System.out.println(bfs());
		UsefulForAlgo.testPrint(dist);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() {return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
}
