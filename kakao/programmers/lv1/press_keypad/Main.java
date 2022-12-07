package kakao.programmers.lv1.press_keypad;

public class Main {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		String answer = "LRLLLRLLRRL";
		System.out.println("myanswer : " + solution.solution(numbers, hand));
		System.out.println("answer : " + answer);
		System.out.println(answer.equals(solution.solution(numbers, hand)));

		numbers = new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		hand = "left";
		answer = "LRLLRRLLLRR";
		System.out.println("myanswer : " + solution.solution(numbers, hand));
		System.out.println("answer : " + answer);
		System.out.println(answer.equals(solution.solution(numbers, hand)));

		numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		hand = "right";
		answer = "LLRLLRLLRL";
		System.out.println("myanswer : " + solution.solution(numbers, hand));
		System.out.println("answer : " + answer);
		System.out.println(answer.equals(solution.solution(numbers, hand)));

	}
}
