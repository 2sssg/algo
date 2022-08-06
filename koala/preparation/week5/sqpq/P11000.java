package koala.preparation.week5.sqpq;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P11000 {
	static class Pair implements Comparable<Pair>{
		int x,y;
		public Pair() throws IOException {
			st = new StringTokenizer(br.readLine());
			this.x = Integer.parseInt(st.nextToken());
			this.y = Integer.parseInt(st.nextToken());
		}

		@Override
		public int compareTo(Pair o) {
			return this.x==o.x?this.y-o.y:this.x-o.x;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static Pair[] ps;

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n = Integer.parseInt(br.readLine());
		ps = new Pair[n];
		for(int i=0; i<n; ++i)ps[i] = new Pair();
		Arrays.sort(ps);
		pq.add(ps[0].y);
		for(int i=1; i<n; ++i){
			if(pq.peek()<=ps[i].x) pq.poll();
			pq.add(ps[i].y);
		}
		System.out.println(pq.size());
	}
}
