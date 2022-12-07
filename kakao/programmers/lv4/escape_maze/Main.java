package kakao.programmers.lv4.escape_maze;

public class Main {

	public static void main(String[] args) {
		int n,start,end, result;
		int[][] roads;
		int[] traps;

		n = 4;
		start = 1;
		end = 4;
		roads = new int[][]{{1, 2, 1}, {3, 2, 1}, {2,4,1}};
		traps = new int[]{2,3};
		result = 5;


		System.out.println(new Solution().solution(n, start, end, roads, traps));
	}

}
