package koala.preparation.week1.backtracking;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2529 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<String> l = new ArrayList<>();
	static StringTokenizer st;
	static char[] sign;
	static boolean[] visit = new boolean[10];
	static int[] temparr;
	static int n;



	static void f(int depth,int num,char c){
		if(depth == n){
			l.add(Arrays.toString(temparr).replaceAll("[\\[\\], ]",""));
			return;
		}
		if(c=='<'){
			for(int i=num+1; i<10; ++i){
				if(visit[i]) continue;
				visit[i] = true;
				temparr[depth+1] = i;
				f(depth+1, i, sign[depth+1]);
				visit[i] = false;
			}
		}else{
			for(int i=0; i<num; ++i){
				if(visit[i]) continue;
				visit[i] = true;
				temparr[depth+1] = i;
				f(depth+1, i, sign[depth+1]);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		l.clear();
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		sign = new char[n+1];
		temparr = new int[n+1];
		for(int i=0; i<n; ++i){
			sign[i] = st.nextToken().charAt(0);
		}
		for(int i=0; i<10; ++i){
			temparr[0] = i;
			visit[i] = true;
			f(0,i,sign[0]);
			visit[i] = false;
		}
		System.out.println(l.get(l.size()-1));
		System.out.println(l.get(0));
	}
}
