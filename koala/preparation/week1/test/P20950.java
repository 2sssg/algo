package koala.preparation.week1.test;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P20950 {
	static class RGB{
		int r,g,b;
		public RGB(int r, int g, int b) {
			this.r = r;
			this.g = g;
			this.b = b;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,limit,answer;
	static boolean[] use;
	static RGB[] c;
	static RGB moon;
	static RGB gom;

	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() {return Integer.parseInt(st.nextToken());}
	static void init() throws IOException {
		answer = Integer.MAX_VALUE;
		n = Integer.parseInt(br.readLine());
		c = new RGB[n];
		moon = new RGB(0,0,0);
		for(int i=0; i<n; ++i){
			est();
			c[i] = new RGB(rstn(),rstn(),rstn());
		}
		est(); gom = new RGB(rstn(),rstn(),rstn());
	}


	static void f(int depth, int cur){
		if(depth == limit){
			answer = Math.min(answer, Math.abs(moon.r/limit- gom.r)+Math.abs(moon.g/limit-gom.g)+Math.abs(moon.b/limit-gom.b));
			return;
		}
		for(int i=cur; i<n; ++i){
			if(use[i]) continue;
			use[i] = true;
			moon.r += c[i].r;
			moon.g += c[i].g;
			moon.b += c[i].b;
			f(depth+1, cur+1);
			moon.r -= c[i].r;
			moon.g -= c[i].g;
			moon.b -= c[i].b;
			use[i] = false;
		}

	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		for(int i=2; i<=7; ++i){
			limit = i;
			use = new boolean[n];
			f(0,0);
		}
		System.out.println(answer);

	}
}
