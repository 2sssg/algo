package extra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1064 {
	static double M1 = 1987654321;
	static double M2 = 1987654321;
	static double a1, b1, a2, b2, a3, b3;


	static double dist(double A1, double B1, double A2, double B2){
		return Math.sqrt((A1-A2)*(A1-A2)+(B1-B2)*(B1-B2));
	}

	public static void main(String[] args) throws IOException {
		a1 = rstn(); b1 = rstn(); a2 = rstn(); b2 = rstn(); a3 = rstn(); b3 = rstn();
		if(a1!=a2) M1 = Math.abs(b2-b1) / Math.abs(a2-a1);
		if(a2!=a3) M2 = Math.abs(b3-b2)/ Math.abs(a3-a2);
		if(M1==M2) {
			System.out.println(-1);
			return;
		}
		double a = dist(a1,b1,a2,b2);
		double b = dist(a1,b1,a3,b3);
		double c = dist(a2,b2,a3,b3);
		double len1 = 2 * (a + b);
		double len2 = 2 * (b + c);
		double len3 = 2 * (c + a);

		System.out.println(Math.max(len1, Math.max(len2,len3)) - Math.min(len1, Math.min(len2,len3)));
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
