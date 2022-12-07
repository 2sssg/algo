package dev_matching.p1;

import Constant.Source;

public class Main {

	public static void main(String[] args) {
		int low = 25, high = 50;
		String[] img = {".########......", ".####...#......", ".#.####.#.#####", ".#.#..#.#.#..##", ".#.##.#.#.#...#", ".#.####.#.#...#", ".#....###.#####", ".########......"};


		new Solution().solution(low, high, img);
	}
}
