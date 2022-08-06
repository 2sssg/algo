package koala.preparation.week5.sqpq;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class P12789 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static Queue<Integer> q = new ArrayDeque<>();
	static Stack<Integer> s = new Stack<>();
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) q.add(Integer.parseInt(st.nextToken()));
		int cur = 0;
		while(!s.isEmpty() || !q.isEmpty()){
			System.out.println(q);
			System.out.println(s);
			System.out.println();
			if(!q.isEmpty() && cur+1==q.peek()){
				cur = q.poll();
			}else if(!s.isEmpty() && cur+1 == s.peek()){
				cur = s.pop();
			}else if(!q.isEmpty() && (s.isEmpty() || s.peek()>q.peek())){
				s.push(q.poll());
			}else{
				System.out.println("Sad");
				return;
			}
		}
		System.out.println("Nice");
	}
}
