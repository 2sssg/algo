package dev_matching.p2;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		String[] record = {"jack:9,10,13,9,15", "jerry:7,7,14,10,17", "jean:0,0,11,20,0", "alex:21,2,7,11,4", "kevin:8,4,5,0,0", "brown:3,5,16,3,18", "ted:0,8,0,0,8", "lala:0,12,0,7,9", "hue:17,16,8,6,10", "elsa:11,13,10,4,13"};
		System.out.println(Arrays.toString(new Solution().solution(record)));
	}
}
