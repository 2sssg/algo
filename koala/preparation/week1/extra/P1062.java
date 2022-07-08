package koala.preparation.week1.extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1062 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] w;
	static int n,k,answer;
	static int antatica = 532741;



	static void f(int depth,int cur){
		if(depth == k-5){
			int tempcount = 0;
			for(int wi : w){
//				System.out.println(wi);
//				System.out.println(antatica);
//				System.out.println(wi|antatica);
//				System.out.println();
				if((wi|antatica) == antatica){

					tempcount++;
				}
			}
//			System.out.println("===================");
			answer = Math.max(tempcount,answer);
			return;
		}
		for(int i=cur; i<26; ++i){
			if(((antatica>>i)&1)==1) continue;
			int temp = antatica;
			antatica |= (1<<i);
			f(depth+1, i);
			antatica &= temp;
		}
	}



	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		answer = 0;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
		if(k<5){
			System.out.println(0);
			return;
		}
		if(k==26){
			System.out.println(n);
			return;
		}
		w = new int[n];
		for(int i=0; i<n; ++i){
			String temp = br.readLine();
			for(int j=0; j<temp.length(); ++j){
				w[i] |= (1<<(temp.charAt(j)-'a'));
			}
		}
		f(0,0);

		System.out.println(answer);



	}
}
