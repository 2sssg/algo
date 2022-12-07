package kakao.programmers.lv3.coding_test_study;

public class Main {

	public static void main(String[] args) {
		int alp, cop;
		int[][] problems;

		alp = 10;
		cop = 10;
		problems = new int[][]{{10,15,2,1,2},{20,20,3,3,4}};
		alp = 0;
		cop = 0;
		problems = new int[][]{{0,0,2,1,2},{4,5,3,1,2},{4,11,4,0,2},{10,4,0,4,2}};
		alp = 12;
		cop = 1;
		problems = new int[][]{{0,0,2,1,2},{4,5,3,1,2},{4,11,4,0,2},{10,4,0,4,2}};
		System.out.println(new Solution().solution(alp, cop, problems));
	}
}
