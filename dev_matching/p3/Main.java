package dev_matching.p3;

public class Main {

	public static void main(String[] args) {
		String[] subway = {"1 2 3 4 5 6 7 8", "2 11", "0 11 10", "3 17 19 12 13 9 14 15 10", "20 2 21"};
		int start = 1;
		int end = 9;
		new Solution().solution(subway, start, end);
	}
}
