package koala.preparation.week4.binarysearch;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class P17179 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m,l;
	static int start,end;
	static TreeSet<Integer> ts;

	static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		ts = new TreeSet<>();
		for(int i=0; i<m; ++i) ts.add(Integer.parseInt(br.readLine()));
		ts.add(l);
	}

	static boolean calc(int mid, int cutcnt){
		int cut = 0;
		int count = 0;
		while(ts.ceiling(cut+mid)!=null){
			cut = ts.ceiling(cut+mid);
			count++;
		}

		return count>cutcnt;
	}


	static int func(int cutcnt){
		start = 1;
		end = l+10;
		int answer = 0;
		while(start<=end){
			int mid = (start+end)/2;
//			System.out.println("start : " + start);
//			System.out.println("mid : " + mid);
//			System.out.println("end : " + end);
//			System.out.println();
			if(calc(mid,cutcnt)){
				answer = Math.max(answer,mid);
				start = mid+1;
			}else{
				end = mid-1;
			}
		}
//		System.out.println("start : " + start);
//		System.out.println("end : " + end);
//		System.out.println();
		return answer;
	}

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		for(int i=0; i<n; ++i){
			System.out.println(func(Integer.parseInt(br.readLine())));
		}

	}
}
