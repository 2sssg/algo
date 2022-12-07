package extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class baek_1090 {
	static int[] dx = new int[51];
	static int[] dy = new int[51];
	static int N;
	static ArrayList<Node> arr = new ArrayList<>();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			int x =Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr.add(new Node(x, y));
			dx[i] = x;
			dy[i] = y;
		}
		for(int i=0;i<N;i++){
			long ans = Integer.MAX_VALUE;
			for(int j=0;j<arr.size(); j++){
				ans = Math.min(ans, solve(i, arr.get(j)));
				System.out.print(ans + " ");
			}
		}
	}
	public static long solve(int N, Node cur){
		ArrayList<Long> t = new ArrayList<>();
		for(int i=0;i<N;i++){
			t.add((long) (Math.abs(dx[i] - cur.x) + Math.abs(dy[i] - cur.y)));
		}
		Collections.sort(t);
		long res = 0;
		for(int i=0;i<N+1; i++){
			res += t.get(i);
		}
		return res;
	}
	public static class Node{
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}