package segment_tree;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P1376 {
	static int n,m;
	static HashSet<Integer>[] adjList;

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		est(); n=rstn(); m=rstn();
		adjList = new HashSet[n+1];
		for(int i=1; i<=n; ++i) adjList[i] = new HashSet<>();
		for(int i=0; i<m; ++i){
			est(); int v1=rstn(), v2 = rstn();
			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}


	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() {return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
}
