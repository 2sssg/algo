package segment_tree;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class P1376 {
	static class Node{
		List<Integer> adj = new ArrayList<>();
		int[] tree;
		int size,S;

		void makeAdj(){
			Collections.sort(adj);
			int pre = 0, size = adj.size();
			for(int i=0; i<size; i++) {
				int cur = adj.get(i);
				if(pre == cur) {
					adj.remove(i);
					i--;
					size--;
				}else pre = cur;
			}
			this.size = adj.size();

		}

		void makeTree(){
//			int h = (int) Math.ceil(Math.log(this.size)/ Math.log(2));
//			this.tree = new int[(int) Math.pow(2,h+1)];
//			for(int i=1; i<=this.size; ++i){
//				update(1,this.size,1,i,1);
//			}
//
			for(S=1; S<=size; S*=2);
			tree = new int[S*2];

			for(int i=0; i<size; i++)
				tree[i+S]++;

			for(int i=S-1; i>0; i--)
				tree[i] = tree[i*2] + tree[i*2+1];
		}
//
//		void up(int s, int e, int node, int idx, int diff){
//			if(idx<s || e<idx) return;
//			tree[node] += diff;
//			if(s==e) return;
//			int mid = (s+e)/2;
//			update(s,mid,node*2,idx,diff);
//			update(mid+1, e, node*2+1, idx, diff);
//		}

//		void erase(int s, int e, int node, int idx){
//			if(idx<s || e<idx) return;
//			tree[node]--;
//			if(s==e) return;
//			int mid = (s+e)/2;
//			erase(s,mid,node*2,idx);
//			erase(mid+1, e, node*2+1, idx);
//		}


		void update(int n) {
			for(n+=S; n>0; n/=2) tree[n]--;
		}

//		int odd(int s, int e, int node, int k){
//			if(s==e) return s;
//			int left = tree[node*2];
//			int mid = (s+e)/2;
//			if(left>=k){
//				return odd(s,mid,node*2, k);
//			}else{
//				return odd(mid+1,e,node*2, k/2);
//			}
//		}
//
//		int even(int s, int e, int node){
//			if(s==e) return s;
//			int left = tree[node*2];
//			int mid = (s+e)/2;
//			if(left!=0){
//				return even(s,mid,node*2);
//			}else{
//				return even(mid+1,e,node*2);
//			}
//		}
//
//		int nextNode(){
//			if(this.tree[1]==0) return -1;
//			else if((this.tree[1]&1) == 1){
//				return this.adj.get(odd(1,this.size,1,(this.tree[1]+1)/2)-1);
//			}else{
//				return this.adj.get(even(1,this.size,1)-1);
//			}
//		}

		int nextNode() {
			int idx = 1, k = tree[1]%2 == 0 ? 1 : tree[1]/2+1;
			while(idx < S) {
				idx *= 2;
				if(tree[idx] < k)
					k -= tree[idx++];
			}
			return adj.get(idx-S);
		}

		@Override
		public String toString() {
			return "Node{" +
				"adj=" + adj +
				", tree=" + Arrays.toString(tree) +
				'}';
		}
	}
	static int n,m;
	static Node[] nodes;

	static void init() throws IOException {
		n=rstn(); m=rstn();
		nodes = new Node[n+1];
		for(int i=1; i<=n; ++i) nodes[i] = new Node();
		for(int i=0; i<m; ++i){
			int v1=rstn(),v2=rstn();
			nodes[v1].adj.add(v2);
			nodes[v2].adj.add(v1);
		}
		for(int i=1; i<=n; ++i) {
			nodes[i].makeAdj();
			nodes[i].makeTree();
		}
	}

	static void dfs(int node) throws IOException {
		bw.append(Integer.toString(node)).append(" ");

		for(int next : nodes[node].adj)
			nodes[next].update(Collections.binarySearch(nodes[next].adj, node));

		while(nodes[node].tree[1]>0) {
			dfs(nodes[node].nextNode());
		}
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
//		for(int i=0; i<=n; ++i){
//			System.out.println(nodes[i]);
//		}
//		return;
//		for(int i=1; i<=n; ++i){
//			if(Collections.binarySearch(nodes[i].adj,1) != -1){
//				nodes[i].erase(1,nodes[i].size,1,nodes[i].getIdx(1));
//			}
//		}
		dfs(1);
		bw.flush();
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
}
