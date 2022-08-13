package koala.preparation.week6.bfsdfs;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class P12886 {
	static class Triple{ int x,y,z;
		public Triple(int x, int y,int z) {
			this.x = Math.min(x,Math.min(y,z));
			this.z = Math.max(x,Math.max(y,z));
			this.y = x+y+z-this.x-this.z;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			Triple triple = (Triple) o;
			return x == triple.x && y == triple.y && z == triple.z;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y, z);
		}
	}

	static HashSet<Triple> visit = new HashSet<>();
	static Queue<Triple> q = new ArrayDeque<>();

	static int bfs(Triple t){
		q.clear();
		q.add(t);
		visit.add(t);
		while(!q.isEmpty()){
			t = q.poll();
			if(t.x == t.y && t.x==t.z) return 1;

			Triple n1 = new Triple(t.x+t.x,t.y-t.x,t.z);
			Triple n2 = new Triple(t.x+t.x,t.y,t.z-t.x);
			Triple n3 = new Triple(t.x,t.y+t.y,t.z-t.y);

			if(!visit.contains(n1)){
				q.add(n1);
				visit.add(n1);
			}
			if(!visit.contains(n2)){
				q.add(n2);
				visit.add(n2);
			}
			if(!visit.contains(n3)){
				q.add(n3);
				visit.add(n3);
			}
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		br= Source.getBufferedReader();
		System.out.println(bfs(new Triple(rstn(),rstn(),rstn())));


	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}

}
