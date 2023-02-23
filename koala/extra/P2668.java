package koala.extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P2668 {
	static int[] arr;
	static int n;
	static boolean[] visited;

	static HashSet<Integer> answer = new HashSet<>();

	static void dfs(int cur) {
		if (visited[cur]) {
			answer.add(cur);
			return ;
		}
		visited[cur] = true;
		dfs(arr[cur]);
	}

	public static void main(String[] args) throws IOException {
		n = rn();
		arr = new int[n + 1];
		for (int i = 1; i <= n; ++i) arr[i] = rn();


		for (int i = 1; i <= n; ++i) {
			visited = new boolean[n + 1];
			if (answer.contains(i)) continue ;
			dfs(i);
		}
		sb.append(answer.size()).append("\n");
		answer.stream().sorted().forEach(r->sb.append(r).append("\n"));
		System.out.println(sb);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int rn() throws IOException {return Integer.parseInt(br.readLine());}
}
