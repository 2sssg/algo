package koala.preparation.week5.sqpq;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1826 {
	static class Pair{
		int x,y;

		public Pair() throws IOException {
			st = new StringTokenizer(br.readLine());
			this.x = Integer.parseInt(st.nextToken());
			this.y = Integer.parseInt(st.nextToken());
		}

		@Override
		public String toString() {
			return "Pair{" +
				"x=" + x +
				", y=" + y +
				'}';
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,oil,dest,answer;
	static PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o2.y-o1.y);
	static Pair[] os;

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n = Integer.parseInt(br.readLine());
		os = new Pair[n];
		for(int i=0; i<n; ++i) os[i] = new Pair();

		st = new StringTokenizer(br.readLine());
		dest = Integer.parseInt(st.nextToken());
		oil = Integer.parseInt(st.nextToken());

		Arrays.sort(os,Comparator.comparingInt(o -> o.x));

		int idx = 0;

		while(oil<dest){
			while(idx!=n&&oil>=os[idx].x) pq.add(os[idx++]);
			if(pq.isEmpty()) break;
			oil += pq.poll().y;
			answer++;
		}
		System.out.println(oil>=dest?answer:-1);
	}
}
