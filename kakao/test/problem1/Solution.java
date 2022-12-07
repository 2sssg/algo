package kakao.test.problem1;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

	/*
	 * Complete the 'solution' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts following parameters:
	 *  1. INTEGER x
	 *  2. INTEGER y
	 *  3. INTEGER z
	 */

	public static int solution(int x, int y, int z) {
		if (Math.abs(x - y) > z) return -1;
		int low = x - 1;
		int high = 300_000_000;
		while (low + 1 < high) {
			int mid = (low + high) / 2;
			if (f(mid, x, y, z)) low = mid;
			else high = mid;
		}
		return high - 1;
	}

	static boolean f(int mid,int x, int y, int z) {
		int go = Math.abs(mid - x);
		int ret = Math.abs(mid - y);
		if (go + ret <= z) return true;
		return false;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int x = Integer.parseInt(bufferedReader.readLine().trim());

		int y = Integer.parseInt(bufferedReader.readLine().trim());

		int z = Integer.parseInt(bufferedReader.readLine().trim());

		int result = Result.solution(x, y, z);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
