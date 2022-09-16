package extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P11723 {
	static int n;
	static Set<Integer> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n = rn();
		while(n-->0){
			st = new StringTokenizer(br.readLine());
			switch(st.nextToken()){
				case "add":
					set.add(rstn());
					break;
				case "remove":
					set.remove(rstn());
					break;
				case "check":
					bw.append(set.contains(rstn())?"1\n":"0\n");
					break;
				case "toggle":
					int temp = rstn();
					if(set.contains(temp)){
						set.remove(temp);
					}else{
						set.add(temp);
					}
					break;
				case "all":
					for(int i=0; i<21; ++i){
						set.add(i);
					}
					break;
				case "empty":
					set.clear();
					break;
			}
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
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean chk(int x, int y, int n, int m){return x<0 || y<0 || x>=n || y>=m;}
	static class Pair{int x,y;public Pair(int x, int y) {this.x = x;this.y = y;}}
	static class Triple{ int x,y,z;public Triple(int x, int y,int z) {this.x = x;this.y = y;this.z = z;}}
	static class Quad{ int w,x,y,z;public Quad(int w, int x, int y,int z) {this.w = w; this.x = x;this.y = y;this.z = z;}}
}
