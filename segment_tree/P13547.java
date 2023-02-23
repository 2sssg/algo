package segment_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P13547 {
	static int sq;
	static int[] numbers;
	static int[] count;
	static int[] result;
	static int cnt = 0;
	static int n, m;
	static class query implements Comparable<query>{
		int start, end, idx;
		query(int s, int e, int i){
			start = s;
			end = e;
			idx = i;
		}

		@Override
		public int compareTo(query o) {
			if((start - 1)/sq != (o.start - 1)/sq)
				return (start - 1)/sq - (o.start - 1)/sq;
			return end - o.end;
		}
	}
	static void go_query(query prev, query cur){
		int s = prev.start;
		int left =  cur.start;
		int e = prev.end;
		int right = cur.end;
		for(int i = s; i<left; i++) erase(numbers[i]);
		for(int i = s-1; i>=left; i--) add(numbers[i]);
		for(int i = e+1; i<=right; i++) add(numbers[i]);
		for(int i = e; i>right; i--) erase(numbers[i]);
	}
	static void add(int index){
		if(++count[index] == 1) cnt++;
	}

	static void erase(int index){
		if(--count[index] == 0) cnt--;
	}

	public static void main(String[] args) throws IOException {
		n = rn();
		numbers = new int[n + 1];
		count = new int[1000001];
		for(int i = 1; i <= n; i++) numbers[i] = rstn();

		m = rstn();
		result = new int[m + 1];
		query[] queries = new query[m + 1];
		sq = (int)Math.sqrt(n);
		for(int i = 1; i <= m; i++) queries[i] = new query(rstn(), rstn(), i);
		queries[0] = new query(0,0,0);
		Arrays.sort(queries);
		for(int i = 1; i <= m; i++){
			go_query(queries[i-1], queries[i]);
			result[queries[i].idx] = cnt;
		}
		for(int i = 1; i <= m; i++) sb.append(result[i]).append("\n");
		System.out.println(sb);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
}