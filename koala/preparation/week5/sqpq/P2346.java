package koala.preparation.week5.sqpq;

import Constant.Source;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class P2346 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] arr;
	static Deque<int[]> dq = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		br = Source.getBufferedReader();
		n = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		sb.append("1 ");
		int in = arr[0];

		for(int i=1; i<n; i++){
			dq.add(new int[] {(i+1), arr[i]});
		}

		while(!dq.isEmpty()) {
			if(in >0) {
				// 순서 뒤로 돌리기
				for(int i=1; i<in; i++) {
					dq.add(dq.poll());
				}

				int[] nxt = dq.poll();
				in = nxt[1];
				sb.append(nxt[0]+" ");
			}
			// 음수인 경우
			else {
				for(int i=1; i<-in; i++	) {
					dq.addFirst(dq.pollLast());
				}

				int[] nxt = dq.pollLast();
				in = nxt[1];
				sb.append(nxt[0]+" ");
			}
		}
		System.out.println(sb.toString());

	}
}
