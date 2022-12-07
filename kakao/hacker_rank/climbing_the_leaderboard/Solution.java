package kakao.hacker_rank.climbing_the_leaderboard;

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
	 * Complete the 'climbingLeaderboard' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY.
	 * The function accepts following parameters:
	 *  1. INTEGER_ARRAY ranked
	 *  2. INTEGER_ARRAY player
	 */

	public static List<Integer> climbingLeaderboard(int n, int m, List<Integer> ranked, List<Integer> player) {
		List<Integer> answer = new ArrayList<>();
		Collections.sort(ranked);
		ranked = ranked.parallelStream().distinct().collect(Collectors.toList());
		n = ranked.size();
		int[] rank = ranked.stream().mapToInt(Integer::intValue).toArray();
		for (int p : player) {
			int index = Arrays.binarySearch(rank, p);
			if (index >= 0) {
				answer.add(n - index);
			} else {
				answer.add(n + index + 2);
			}
		}
		return answer;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt)
				.collect(toList());

		int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt)
				.collect(toList());

		List<Integer> result = Result.climbingLeaderboard(rankedCount, playerCount, ranked, player);

		bufferedWriter.write(
				result.stream()
						.map(Object::toString)
						.collect(joining("\n"))
						+ "\n"
		);

		bufferedReader.close();
		bufferedWriter.close();
	}
}
