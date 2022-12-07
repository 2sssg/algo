package extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1516 {
	static int n;
	static int[] time, point, answer;
	static List<Integer>[] adjList;
	static PriorityQueue<Pair> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.y));

	static void init() throws IOException {
		n = rn();
		time = new int[n + 1];
		point = new int[n + 1];
		answer = new int[n + 1];
		adjList = new ArrayList[n + 1];
		for (int i = 1; i <= n; ++i) adjList[i] = new ArrayList<>();
		for (int i = 1; i <= n; ++i) {
			int[] temp = ra();
			time[i] = temp[0];
			point[i] = temp.length - 2;
			for (int j = 1; j < point[i] + 1; ++j)
				adjList[temp[j]].add(i);
		}
		for (int i = 1; i <= n; ++i) {
			if (point[i] == 0) {
				q.add(new Pair(i, time[i]));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		init();
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			answer[cur.x] = cur.y;
			for (int nxt : adjList[cur.x]) {
				point[nxt]--;
				if (point[nxt] == 0) {
					q.add(new Pair(nxt, cur.y + time[nxt]));
				}
			}
		}
		for (int i = 1; i <= n; ++i)
			bw.append(Integer.toString(answer[i])).append("\n");
		bw.flush();
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
}


//4
//1 4 3 2 -1
//2 4 -1
//1 4 -1
//1 -1

//5
//10 -1
//20 1 -1
//30 2 -1
//40 3 5 -1
//100 -1