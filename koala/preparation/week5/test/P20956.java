package koala.preparation.week5.test;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P20956 {
	static class Pair{
		int x,y; public Pair(int x, int y){this.x=x; this.y=y;}

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
	static int n,m;
	static int[] arr;
	static PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> {return o1.x==o2.x?o1.y-o2.y:o2.x-o1.x;});
	static PriorityQueue<Pair> reversepq = new PriorityQueue<>((o1, o2) -> {return o1.x==o2.x?o2.y-o1.y:o2.x-o1.x;});
	static HashSet<Integer> eat = new HashSet<>();
	static boolean isSeq = true;

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		est(); n=rstn(); m=rstn(); arr=ra();
		for(int i=0; i<n; ++i){
			pq.add(new Pair(arr[i],i+1));
			reversepq.add(new Pair(arr[i],i+1));
		}

		while(m-->0){
//			System.out.println(pq);
//			System.out.println(reversepq);
//			System.out.println();
			if(isSeq){
				while(eat.contains(pq.peek().y)) pq.poll();
				Pair p = pq.poll();
				eat.add(p.y);
				if(p.x%7==0) isSeq = false;
				System.out.println(p.y);
			}else{
				while(eat.contains(reversepq.peek().y)) reversepq.poll();
				Pair p = reversepq.poll();
				eat.add(p.y);
				if(p.x%7==0) isSeq = true;
				System.out.println(p.y);
			}
		}
	}

	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() {return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
}
