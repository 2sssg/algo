package kakao.programmers.lv1.personality_type_test;

public class Main {

	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		int[] choices = {5, 3, 2, 7, 5};
		String answer = "TCMA";
		System.out.println(answer);
		System.out.println(solution.solution(survey, choices));

		survey = new String[]{"TR", "RT", "TR"};
		choices = new int[]{7, 1, 3};
		answer = "RCJA";
		System.out.println(answer);
		System.out.println(solution.solution(survey, choices));
	}
}
