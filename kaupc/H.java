package kaupc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class H {
	static int n,k;
	static int myloc;
	static TreeMap<Integer, Integer> map;
	static void init() throws IOException {
		n = rstn(); k =rstn();
		map = new TreeMap<>();
		while(k-->0){
			int row = rstn();
			int col = rstn();
			map.put(col, n-row);
		}
		myloc = rn();
	}

	static int dfs(int loc, int depth, int islr) {
		System.out.println(loc);
		if (loc > n || loc < 1) return -1;
		Entry<Integer, Integer> l,r,cur;
		l = map.lowerEntry(loc);
		r = map.higherEntry(loc);
		cur = map.containsKey(loc)?map.ceilingEntry(loc):null;
		if(cur != null){
			if (cur.getValue() - depth > 0)
			{
				int time = cur.getValue();
				map.remove(loc);
				if (map.size() == 0) return depth + 1;
				if (l != null){
					if (l.getValue() > depth + 2){
						int temp = dfs(loc - 1, depth + 2, -1);
						if (temp > 0) return temp;
					}else{
						map.put(loc, time);
						return -1;
					}
				}
				if (r != null){
					if(r.getValue() > depth + 2){
						int temp = dfs(loc + 1, depth + 2, 1);
						if (temp > 0) return temp;
					}else{
						map.put(loc, time);
						return -1;
					}
				}
				map.put(loc, time);
			}else{
				return -1;
			}
		}
		else{
			if (l != null){
				if (l.getValue() > depth + 1 && islr <= 0){
					int temp = dfs(loc - 1, depth + 1, -1);
					if (temp > 0) return temp;
				}else{
					return -1;
				}
			}
			if (r != null){
				if(r.getValue() > depth + 1 && islr >= 0){
					int temp = dfs(loc + 1, depth + 1, 1);
					if (temp > 0)
						return temp;
				}else{
					return -1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		init();
		int temp = dfs(myloc, 0, -1);
		System.out.println(temp);
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
