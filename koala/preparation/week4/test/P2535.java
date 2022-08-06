package koala.preparation.week4.test;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P2535 {
	static class Pair implements Comparable<Pair>{
		int con,num,score;

		public Pair(int con, int num, int score) {
			this.con = con;
			this.num = num;
			this.score = score;
		}

		@Override
		public int compareTo(Pair o) {
			return o.score-this.score;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(this.con).append(" ").append(this.num).append("\n");
			return sb.toString();
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static PriorityQueue<Pair> pq = new PriorityQueue<>();
	static int rstn() {return Integer.parseInt(st.nextToken());}
	static int[] contry = new int[101];

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		int n = Integer.parseInt(br.readLine());
		while(n-->0){
			st = new StringTokenizer(br.readLine());
			pq.add(new Pair(rstn(),rstn(),rstn()));
		}
		int count = 0;
		while(count<3){
			Pair p = pq.poll();
			if(contry[p.con]==2) continue;
			contry[p.con]++;
			count++;
			bw.write(p.toString());
		}
		bw.flush();

	}
}
