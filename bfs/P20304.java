package bfs;

import Constant.Source;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P20304 {
	static int n,m,answer;
	static int[] keys;
	static Queue<Integer> q = new ArrayDeque<>();
	static int[] arr = new int[1000005];

	static void init() throws IOException {
		n = rstn(); m = rstn(); keys = ra();
		Arrays.fill(arr,-1);

		for(int key : keys){
			arr[key] = 0;
			q.add(key);
		}
	}

	static int bfs(){
		while(!q.isEmpty()){
			int cur = q.poll();
			answer = Math.max(arr[cur],answer);
			for(int i=0; i<20; ++i){
				int nx = (1<<i)^cur;
				if(nx>n || arr[nx]!=-1) continue;
				arr[nx] = arr[cur]+1;
				q.add(nx);
			}
		}
		return answer;
	}


	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		init();
		System.out.println(bfs());
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static void est() throws IOException {st = new StringTokenizer(br.readLine());}
	static int rstn() throws IOException {if(st==null||!st.hasMoreTokens()) est(); return Integer.parseInt(st.nextToken());}
	static int[] ra() throws IOException {return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();}
}


// 0011
// 0100
// 0010

// 0000  1
// 0001  1
// 0010  1
// 0011  0
// 0100  0
// 0101  1
// 0110  1
// 0111  1
// 1000  2
// 1001
// 1010
// 1011
// 1100
// 1101
// 1110
// 1111 2

// 1 2 1 0
// 4 3 1 0

// 2 1 2 3
// 8 7 5 3

// 1 0 1 1
// 1 1 1 1

// 1000
// 1111
// 1001

// 안전도 1

