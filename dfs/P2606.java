package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2606 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean[] ismarked;
	static StringTokenizer st;
	static List<Integer>[] G;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		ismarked = new boolean[n + 1];
		G = new ArrayList[n + 1];
		for (int i = 0; i <= n; ++i) G[i] = new ArrayList<>();

		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			G[u].add(v);
			G[v].add(u);
		}

		Queue<Integer> q = new ArrayDeque<>();
		q.add(1);
		ismarked[1] = true;

		int ans = 0;
		while (!q.isEmpty()) {
			int current = q.poll();
			ans++;
			for (int next : G[current]) {
				if (ismarked[next]) continue;
				ismarked[next] = true;
				q.add(next);
			}
		}

		System.out.println(ans - 1);

	}
}
