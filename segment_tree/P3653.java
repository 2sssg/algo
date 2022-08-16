package segment_tree;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P3653 {
	static int t,n,m,size;
	static int[] seg,arr;

	static void init() throws IOException {
		n=rstn(); m=rstn(); size = n+m;
		seg = new int[size*4];
		arr = new int[n+1];
		for(int i=n; i>0; --i) arr[n-i+1] = i;
		seginit(1, size, 1);
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(seg));
//		System.out.println();
//		System.out.println(query(1,size,1, 3,size));
	}

	static int seginit(int s, int e, int node){
		if(s>n) return 0;
		if(s==e) return seg[node] = 1;
		int mid = (s+e)/2;
		return seg[node] = seginit(s, mid, node*2) + seginit(mid+1, e, node*2+1);
	}

	static int query(int s, int e, int node, int l, int r){
		if(s>r || e<l) return 0;
		if(s>=l && e<=r) return seg[node];
		int mid = (s+e)/2;
		return query(s, mid, node*2, l, r) + query(mid+1, e, node*2+1, l, r);
	}

	static void update(int s, int e, int node, int idx, int diff){
		if(s>idx || idx>e) return;
		seg[node] += diff;
		if(s==e) return;
		int mid = (s+e)/2;
		update(s, mid, node*2, idx, diff);
		update(mid+1, e, node*2+1, idx, diff);
	}



	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		t=rn();
		while(t-->0){
			init();
//			System.out.println(Arrays.toString(seg));
			for(int i=0; i<m; ++i){
				int cur = rstn();
//				System.out.println(Arrays.toString(seg));
				bw.append(Integer.toString(query(1,size,1,arr[cur]+1,size))).append(" ");

				update(1,size,1,arr[cur],-1);
//				System.out.println(Arrays.toString(seg));

				update(1,size,1,n+i+1,1);
//				System.out.println(Arrays.toString(seg));

//				System.out.println();
				arr[cur] = n+i+1;
			}
			bw.append("\n");
		}
		bw.flush();
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
}


// 10 8 6 5 3 7 4 2 9 1