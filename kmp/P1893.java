package kmp;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P1893 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int t;
	static char[] a,p,s;
	static HashMap<Character,Integer> ahm;
	static int[] pi;
	static List<Integer> answer;

	static void init() throws IOException {
		t = Integer.parseInt(br.readLine());
		while(t-->0){
			answer = new ArrayList<>();
			a = br.readLine().toCharArray();
			p = br.readLine().toCharArray();
			s = br.readLine().toCharArray();
			ahm = new HashMap<>();
			for(int i=0; i<a.length; ++i) ahm.put(a[i],i);
			onecycle();
			printAnswer(answer.size());
		}
	}

	static void onecycle(){
		if(kmp()) answer.add(0);
		for(int i=1; i<a.length; ++i){
			shiftonetime();
			if(kmp()) answer.add(i);
		}
	}

	static void shiftonetime(){
		for(int i=0; i<p.length; ++i){
			int idx = ahm.get(p[i] );
			if(idx==a.length-1) idx = -1;
			p[i] = a[idx+1];
		}
	}

	static void makepi(){
		pi = new int[p.length];
		int idx = 0;
		for(int i=1; i<p.length; ++i){
			while(idx>0 && p[i] != p[idx]) idx = pi[idx-1];
			if(p[i] == p[idx]) pi[i] = ++idx;
		}
	}

	static boolean kmp(){
		makepi();
		int count = 0;
		int idx = 0;
		int n1 = s.length;
		int n2 = p.length;
		for(int i=0; i<n1; ++i){
			while(idx>0 && s[i] != p[idx]) idx = pi[idx-1];
			if(s[i] == p[idx]){
				if(idx == n2-1) {
					idx = pi[idx];
					count++;
				}
				else idx++;
			}
		}
		return count==1;
	}

	static void printAnswer(int len) throws IOException {
		if(len == 0){
			bw.write("no solution\n");
		}else if(len == 1){
			bw.write("unique: ");
			bw.write(String.valueOf(answer.get(0)));
			bw.write("\n");
		}else{
			bw.write("ambiguous: ");
			for(int i: answer){
				bw.write(String.valueOf(i));
				bw.write(" ");
			}
			bw.write("\n");
		}
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		bw.flush();
		bw.close();
	}
}
