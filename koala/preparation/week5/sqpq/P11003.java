package koala.preparation.week5.sqpq;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P11003 {
	static class Pair{
		int x,y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n,l;
	static Deque<Pair> dq = new ArrayDeque<>();

	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() {return Integer.parseInt(st.nextToken());}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		est(); n=rstn(); l =rstn(); est();
		for(int i=0; i<n; ++i){
			int num = rstn();
			while(!dq.isEmpty()&&dq.peekLast().x>num) dq.pollLast();
			while(!dq.isEmpty()&&dq.peekFirst().y<=i-l) dq.pollFirst();
			dq.add(new Pair(num,i));
			sb.append(dq.peekFirst().x).append(" ");
		}
		System.out.println(sb.toString());
	}
}