package extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P5639 {
	static class Node {
		int v;
		Node left;
		Node right;

		public Node(int v) {
			this.v = v;
		}
	}
	static Node head;

	static void post(Node cur) {
		if (cur == null) return;
		post(cur.left);
		post(cur.right);
		System.out.println(cur.v);
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		head = new Node(Integer.parseInt(br.readLine()));
		String value ;
		while((value = (br.readLine())) != null) {
			int intValue = Integer.parseInt(value);
			Node cur = head;
			Node pre = head;
			while (cur != null) {
				pre = cur;
				cur = cur.v < intValue ? cur.right : cur.left;
			}
			if (pre.v < intValue) {
				pre.right = new Node(intValue);
			} else {
				pre.left = new Node(intValue);
			}
		}
		post(head);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
}
