package bfs;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P13913 {
	static class Pair{
		int x; int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,K;
	static int[] dist = new int[200001];
	static int[] path = new int[200001];
	static Queue<Integer> q = new ArrayDeque<>();
	static LinkedList<Integer> l = new LinkedList<>();


	static void f(int num){
		l.addFirst(num);
		if(path[num] == num) return;
		f(path[num]);
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Arrays.fill(dist,Integer.MAX_VALUE);
		q.add(N);
		dist[N] = 0;
		path[N] = N;
		while(true){
			int cur = q.poll();
			if(cur == K) {
				System.out.println(dist[cur]);
				f(cur);
				break;
			}
			if(cur*2<200001 && dist[cur*2]>dist[cur]+1){
				q.add(cur*2);
				dist[cur*2] = dist[cur]+1;
				path[cur*2] = cur;
			}
			if(cur+1<200001 && dist[cur+1]>dist[cur]+1){
				q.add(cur+1);
				dist[cur+1] = dist[cur]+1;
				path[cur+1] = cur;
			}
			if(cur-1>=0 && dist[cur-1]>dist[cur]+1){
				q.add(cur-1);
				dist[cur-1] = dist[cur]+1;
				path[cur-1] = cur;
			}
		}

		for (Integer integer : l) {
			bw.write(String.valueOf(integer));
			bw.write(" ");
		}
		bw.flush();
		bw.close();



	}
}
