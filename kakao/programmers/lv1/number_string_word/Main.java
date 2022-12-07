package kakao.programmers.lv1.number_string_word;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "one4seveneight";
		int result = 1478;
		System.out.println(solution.solution(s) == result);

		s = "23four5six7";
		result = 234567;
		System.out.println(solution.solution(s) == result);

		s = "2three45sixseven";
		System.out.println(solution.solution(s) == result);

		s = "123";
		result = 123;
		System.out.println(solution.solution(s) == result);
	}
}
