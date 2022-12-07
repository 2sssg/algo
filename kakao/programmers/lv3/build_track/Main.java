package kakao.programmers.lv3.build_track;

public class Main {


	public static void main(String[] args) {
		int[][] board = {
				{0,0,0,0,0,0,0,1},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,1,0,0},
				{0,0,0,0,1,0,0,0},
				{0,0,0,1,0,0,0,1},
				{0,0,1,0,0,0,1,0},
				{0,1,0,0,0,1,0,0},
				{1,0,0,0,0,0,0,0}
		};
		board = new int[][]{
				{0,0,1,0},
				{0,0,0,0},
				{0,1,0,1},
				{1,0,0,0}
		};


		board = new int[][]{
				{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}
		};
//
//		board = new int[][]{
//				{0,1,1},
//				{1,1,1},
//				{1,1,0}
//		};
		System.out.println(new Solution().solution(board));
	}
}
