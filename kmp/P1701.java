package kmp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1701 {

	static String p;
	static int answer;
	static int[] pi;
	static int makepi(String subp, int length){
		pi = new int[length];
		int idx = 0;
		for(int i=1; i<length; ++i){
			while(idx>0 && subp.charAt(i) != subp.charAt(idx)) idx = pi[idx - 1];
			if(subp.charAt(i) == subp.charAt(idx)) pi[i] = ++idx;
		}
		return Arrays.stream(pi).max().getAsInt();
	}

	public static void main(String[] args) throws IOException {
		p = br.readLine();
		int len = p.length();
		for (int i = 0; i < len - 1; ++i)
			answer = Math.max(answer, makepi(p.substring(i), len - i));
		System.out.println(answer);

	}

	////////////////////////// 입출력 //////////////////////////
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
	///////////////////////// 입출력 ////////////////////////////
}
