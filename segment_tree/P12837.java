package segment_tree;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P12837 {
	static int n,q;
	static long[] seg;

	static void init() throws IOException {
		n=rstn(); q=rstn();
		seg = new long[4*n];
	}

	static void update(int s, int e, int node, int idx, int diff){
		if(idx<s || idx>e) return;
		seg[node] += diff;
		if(s==e) return;
		int mid = (s+e)/2;
		update(s, mid, node*2, idx, diff);
		update(mid+1, e, node*2+1, idx, diff);
	}

	static long query(int s, int e, int node, int l, int r){
		if(s>r || e<l) return 0;
		if(l<=s && e<=r) return seg[node];
		int mid = (s+e)/2;
		return query(s, mid, node*2, l, r)+query(mid+1, e, node*2+1, l, r);
	}


	public static void main(String[] args) throws IOException{
		br = Source.getBufferedReader();
		init();
		while(q-->0){
			if(rstn()==1) update(1, n, 1, rstn(), rstn());
			else bw.append(Long.toString(query(1, n, 1, rstn(), rstn()))).append("\n");
		}
		bw.flush();
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
}
