package kmp;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10266 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static String t,p;
	static int[] arr = new int[360000];
	static int[] pi;

	static void makepi(int n){
		pi = new int[n];

		int idx = 0;
		for(int i=1; i<n; ++i){
			while(idx>0 && p.charAt(i) != p.charAt(idx)) idx = pi[idx-1];
			if(p.charAt(i) == p.charAt(idx)) pi[i] = ++idx;
		}

	}

	static boolean kmp(){
		makepi(p.length());
		int idx = 0;

		for(int i=0; i<t.length(); ++i){
			while(idx>0 && t.charAt(i) != p.charAt(idx)) idx = pi[idx-1];
			if (t.charAt(i) == p.charAt(idx)) {
				if(idx == p.length()-1){
					return true;
				}else{
					idx++;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		Arrays.fill(arr,0);
		while(st.hasMoreTokens()) arr[Integer.parseInt(st.nextToken())] = 1;
		t = Arrays.toString(arr).replaceAll("[\\[\\], ]","");
		t += t;
		Arrays.fill(arr,0);
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) arr[Integer.parseInt(st.nextToken())] = 1;
		p = Arrays.toString(arr).replaceAll("[\\[\\], ]","");

		System.out.println(kmp()?"possible":"impossible");
	}
}
