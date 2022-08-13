package koala.preparation.week6.bfsdfs;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2251 {
	static class Tri{
		int a,b,c;
		public Tri(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

	static boolean[][][] visit;
	static Queue<Tri> q ;
	static int a,b,c;
	static int[] answer;
	static void init() throws IOException {
		visit = new boolean[201][201][201];
		q = new ArrayDeque<>();
		est(); a=rstn(); b=rstn(); c=rstn();
		answer = new int[201];
	}

	static void bfs(){
		q.add(new Tri(0,0,c));
		while(!q.isEmpty()){
			Tri t = q.poll();
			if(visit[t.a][t.b][t.c]) continue;
			visit[t.a][t.b][t.c] = true;
			if(t.a==0)answer[t.c]++;
			//a->b
			if(t.a+t.b<=b) q.add(new Tri(0,t.a+t.b,t.c));
			else q.add(new Tri(t.a-(b-t.b),b,t.c));

			//a->c
			if(t.a+t.c<=c) q.add(new Tri(0,t.b,t.a+t.c));
			else q.add(new Tri(t.a-(c-t.c),t.b,c));

			// b->a
			if(t.a+t.b<=a) q.add(new Tri(t.a+t.b,0,t.c));
			else q.add(new Tri(a,t.b-(a-t.a),t.c));

			//b->c
			if(t.b+t.c<=c) q.add(new Tri(t.a,0,t.b+t.c));
			else q.add(new Tri(t.a,t.b-(c-t.c),c));

			//c->a
			if(t.c+t.a<=a) q.add(new Tri(t.a+t.c,t.b,0));
			else q.add(new Tri(a,t.b,t.c-(a-t.a)));

			//c->b
			if(t.c+t.b<=b) q.add(new Tri(t.a,t.c+t.b,0));
			else q.add(new Tri(t.a,b,t.c-(b-t.b)));
		}
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		bfs();
		for(int i=0; i<201; ++i) sb.append(answer[i]>0?i:"").append(answer[i]>0?" ":"");
		System.out.println(sb.toString());
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() {return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
}
