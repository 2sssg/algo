package extra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class P9250 {
	static final int MX = 26;

	static class Trie {
		Trie child[];
		Trie fail;
		boolean output;

		public Trie() {
			child = new Trie[MX];
			Arrays.fill(child, null);
		}

		void insert(String str) {
			Trie tmp = this;
			for (int i = 0; i < str.length(); i++) {
				int cur = str.charAt(i) - 'a';
				if (tmp.child[cur] == null) tmp.child[cur] = new Trie();
				tmp = tmp.child[cur];
			}
			tmp.output = true;
		}

		boolean check(String str) {
			Trie tmp = this;
			for (int i = 0; i < str.length(); i++) {
				int next = str.charAt(i) - 'a';
				while(tmp!= this && tmp.child[next] == null) tmp = tmp.fail;
				if(tmp.child[next]!=null) tmp = tmp.child[next];
				if(tmp.output) return true;
			}
			return false;
		}

		void computeFailFunc(){
			Queue<Trie> q = new LinkedList<>();
			Trie root = this;
			root.fail = this;
			q.add(root);

			while(!q.isEmpty()){
				Trie here = q.poll();

				for(int edge = 0; edge<MX; edge++){
					Trie child = here.child[edge];
					if(child == null) continue;
					if(here == root) child.fail = root;
					else{
						Trie t = here.fail;
						while(t!=root && t.child[edge] == null) t = t.fail;
						if(t.child[edge] != null) t = t.child[edge];
						child.fail = t;
					}
					if(child.fail.output) child.output = true;
					q.add(child);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		Trie root = new Trie();

		int N = rn();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			root.insert(str);
		}
		root.computeFailFunc();

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if (root.check(str)) sb.append("YES\n");
			else sb.append("NO\n");
		}
		System.out.println(sb);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int swap(int localA, int localB) {return localA;}
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	static int dy[] = { -1,0,0,1,1,1,-1,-1 };
	static int dx[] = { 0,1,-1,0,-1,1,1,-1 };
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
	static final int IINF = Integer.MAX_VALUE;
	static final long LINF = Long.MAX_VALUE;
	static final int HIINF = Integer.MAX_VALUE / 2;
	static final long HLINF = Long.MAX_VALUE / 2;
	static int max(int... temp) {return Arrays.stream(temp).max().getAsInt();}
	static int min(int... temp) {return Arrays.stream(temp).min().getAsInt();}
}
