package koala.preparation.week6.bfsdfs;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class P9019 {
	static int t,a,b;
	static int[] parent = new int[10005];
	static char[] type = new char[10005];
	static Queue<Integer> q = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		t = rn();
		while(t-->0){
			q.clear();
			Arrays.fill(parent,-2);
			a=rstn(); b=rstn();
			q.add(a);
			parent[a] = -1;
			while(!q.isEmpty()){
				int cur = q.poll();
				if(cur == b) break;

				int dnum = (cur*2)%10000;
				int snum = (9999+cur)%10000;
				int lnum = (cur*10+(cur/1000))%10000;
				int rnum = ((cur%10)*10000+cur)/10;

				if(parent[dnum] == -2){
					q.add(dnum);
					parent[dnum] = cur;
					type[dnum] = 'D';
				}

				if(parent[snum] == -2){
					q.add(snum);
					parent[snum] = cur;
					type[snum] = 'S';
				}

				if(parent[lnum] == -2){
					q.add(lnum);
					parent[lnum] = cur;
					type[lnum] = 'L';
				}

				if(parent[rnum] == -2){
					q.add(rnum);
					parent[rnum] = cur;
					type[rnum] = 'R';
				}

			}
			print(b);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static void print(int idx){
		if(parent[idx]==-1) return;
		print(parent[idx]);
		sb.append(type[idx]);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
}
