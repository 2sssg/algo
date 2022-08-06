package koala.preparation.week5.sqpq;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P22252 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static long answer;
	static HashMap<String, PriorityQueue<Integer>> g = new HashMap<>();
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n = Integer.parseInt(br.readLine());
		while(n-->0){
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			if(type==1){
				g.putIfAbsent(name,new PriorityQueue<>(Collections.reverseOrder()));
				st.nextToken();
				while(st.hasMoreTokens()) g.get(name).add(Integer.parseInt(st.nextToken()));
			}else{
				int len = Integer.parseInt(st.nextToken());
				if(g.containsKey(name))while(len-->0 && !g.get(name).isEmpty()) answer += g.get(name).poll();
			}
		}
		System.out.println(answer);
	}
}
