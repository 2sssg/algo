package segment_tree;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1517 {
	static class Pair implements Comparable<Pair>{
		long x,y;
		public Pair(long x, long y) {this.x = x;this.y = y;}

		@Override
		public int compareTo(Pair o) {
			if(o.x>this.x){
				return 1;
			}else if(o.x==this.x){
				if(this.y<o.y){
					return 1;
				}else{
					return -1;
				}
			}
			return -1;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static long[] tree;
	static Pair[] arr;

	static long query(int start, int end, int node, int left, int right){
		if(end<left || start>right) return 0;
		if(left<=start && right>=end) return tree[node];
		int mid = (start+end)/2;
		return query(start,mid,node*2,left,right) + query(mid+1, end, node*2+1, left, right);
	}

	static void update(int start, int end, int node, int idx){
		if(idx<start || idx>end) return;
		tree[node]++;
		if(start == end) return;
		int mid = (start+end)/2;
		update(start,mid,node*2, idx);
		update(mid+1,end,node*2+1, idx);
	}



	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n = Integer.parseInt(br.readLine());
		arr = new Pair[n+1];
		tree = new long[4*n];
		st = new StringTokenizer(br.readLine());
		arr[0] = new Pair(-1000000001,0);
		for(int i=1; i<=n; ++i) arr[i] = new Pair(Long.parseLong(st.nextToken()),i);
		Arrays.sort(arr);

		long sum = 0;
//		System.out.println(Arrays.toString(arr));
		for(int i=0; i<n; ++i){
//			System.out.println(arr[i]);
//			System.out.println(Arrays.toString(tree));
			sum += query(1,n,1,1,(int)arr[i].y);
			update(1,n,1,(int)arr[i].y);
		}
		System.out.println(sum);



	}
}
