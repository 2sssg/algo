package koala.preparation.week1.extra;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class P1977 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<Integer> l = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		for(int i=1; i<=100; ++i) l.add(i*i);
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<100 && l.get(i)<=m; ++i){
			if(l.get(i)>=n){
				sum += l.get(i);
				min = Math.min(l.get(i),min);
			}
		}
		if(sum == 0){
			System.out.println("-1");
		}else{
			System.out.println(sum);
			System.out.println(min);
		}

	}
}
