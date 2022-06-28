package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P13549 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N,K;
	static int[] dist;

	static int bfs(){
		Queue<Integer> q = new ArrayDeque<>();
		q.add(N);
		dist[N] = 0;
		while(true){
			int cur = q.poll();
			if(cur == K) {
				return dist[cur];
			}
			if(2*cur<=200001&&dist[2*cur] > dist[cur]){
				q.add(2*cur);
				dist[2*cur] = dist[cur];
			}
			if(cur-1>=0 && dist[cur-1]> dist[cur]+1 ){
				q.add(cur-1);
				dist[cur-1] = dist[cur]+1;
			}
			if(cur+1<200001 && dist[cur+1]> dist[cur]+1){
				q.add(cur+1);
				dist[cur+1] = dist[cur]+1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dist = new int[200001];
		Arrays.fill(dist,Integer.MAX_VALUE);
		System.out.println(bfs());

	}
}
