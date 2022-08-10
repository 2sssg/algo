package koala.preparation.week6;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class P8111 {
	static int t;
	static Queue<Integer> q = new ArrayDeque<>();
	static HashMap<Integer,Character> hm ;
	static int[] parent = new int[1000005];
	static int[] answer = new int[1000005];
	static int[] visited = new int[1000005];



	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		t=rn();
		while(t-->0){
			Arrays.fill(visited, 0);
			int x = rn();
			if(x==1) sb.append("1\n");
			else{
				Queue<Integer> q = new ArrayDeque<>();
				answer[1] = 1;
				q.add(1);
				while(!q.isEmpty()){
					int r = q.poll();
					if (r == 0) {
						List<Integer> l = new ArrayList<>();
						int temp = 0;
						while (temp != 1) {
							l.add(answer[temp]);
							temp = parent[temp];
						}
						l.add(1);
						for(int i=l.size()-1; i>=0; --i){
							sb.append(l.get(i));
						}
						sb.append("\n");
						break;
					}
					int rr = r * 10 % x;
					if (visited[rr] == 0) {
						visited[rr] = 1;
						answer[rr] = 0;
						parent[rr] = r;
						q.add(rr);
					}
					rr = (r * 10 + 1) % x;
					if (visited[rr]==0) {
						visited[rr] = 1;
						answer[rr] = 1;
						parent[rr] = r;
						q.add(rr);
					}
				}
			}
		}

		System.out.println(sb);
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
}
