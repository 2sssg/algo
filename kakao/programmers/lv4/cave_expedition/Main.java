package kakao.programmers.lv4.cave_expedition;

public class Main {

	public static void main(String[] args) {
		int n;
		int[][] path, order;
		boolean result;

		n = 9;
		path = new int[][]{{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
		order = new int[][]{{8,5},{6,7},{4,1}};
		result = true;

//		path = new int[][]{{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
//		order = new int[][]{{4,1},{8,7},{6,5}};
//		result = true;

		path = new int[][]{{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
		order = new int[][]{{8,5},{6,7},{4,1}};
		result = true;

		System.out.println(result);
		System.out.println(new Solution().solution(n, path, order));
	}
}
