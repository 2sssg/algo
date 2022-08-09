package segment_tree;

import Constant.Source;
import java.io.*;
import java.util.*;

public class P1376_answer {
	static class Node {
		TreeSet<Integer> treeSet;
		List<Integer> nodes;
		int[] tree;
		int nodeSize, treeSize;

		void removeNode(int n) {
			int idx = Collections.binarySearch(nodes, n);
			nodeSize--;
			update(idx + 1, -1);
		}

		int getNextNode() {
			int idx = (nodeSize % 2 == 0) ? 1 : nodeSize / 2 + 1;
			int left = 0;
			int right = treeSize - 1;
			while (left < right) {
				int mid = (left + right) / 2;
				int s = find(mid);
				if (s < idx) left = mid + 1;
				else right = mid;
			}
			return nodes.get(right - 1);
		}

		int find(int idx) {
			int ret = 0;
			while (idx > 0) {
				ret += tree[idx];
				idx = idx - (idx & - idx);
			}
			return ret;
		}

		void update(int n, int value) {
			int idx = n;
			while (idx < treeSize) {
				tree[idx] += value;
				idx = idx + (idx & -idx);
			}
		}

		void init() {
			nodes = new ArrayList<>(treeSet);
			nodeSize = nodes.size();
			treeSize = nodeSize + 1;
			tree = new int[treeSize];
			for (int i = 1; i < nodeSize; i++) {
				System.out.printf("update(%d,1)\n",i);
				update(i, 1);
			}
		}

		public Node() {
			treeSet = new TreeSet<>();
		}

		@Override
		public String toString() {
			return "Node{" +
				"treeSet=" + treeSet +
				", nodes=" + nodes +
				", tree=" + Arrays.toString(tree) +
				", nodeSize=" + nodeSize +
				", treeSize=" + treeSize +
				'}';
		}
	}

	static List<Node> graph = new ArrayList<>();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = Source.getBufferedReader();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= n; i++) graph.add(new Node());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(a).treeSet.add(b);
			graph.get(b).treeSet.add(a);
		}
		System.out.println(graph);

		for (int i = 1; i <= n; i++) {
			graph.get(i).init();
			System.out.println(graph.get(i));
		}

		mfs(1);
		bw.flush();
		bw.close();
	}

	static void mfs(int n) throws IOException {
		bw.write(n + " ");
		for (Integer node : graph.get(n).nodes) {
			graph.get(node).removeNode(n);
		}
		while (graph.get(n).nodeSize != 0) {
			mfs(graph.get(n).getNextNode());
		}
	}
}
