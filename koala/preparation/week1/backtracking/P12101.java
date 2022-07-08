package koala.preparation.week1.backtracking;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P12101 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<String> l;
	static StringBuilder sb;
	static int n,k;

	static void init() throws IOException {
		br = Source.getBufferedReader();
		l = new ArrayList<>();
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
	}

	static void f(int num,int len){
		if(num == n){
			l.add(sb.toString());
			return;
		}
		for(int i=1; i<4; ++i){
			if(num+i<=n){
				sb.append(i);
				f(num+i,len+1);
				sb.setLength(len);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		init();
		f(0,0);
		System.out.println(k>l.size()?"-1":String.join("+", l.get(k-1).split("")));
	}
}
