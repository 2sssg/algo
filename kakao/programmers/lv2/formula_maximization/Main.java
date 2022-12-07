package kakao.programmers.lv2.formula_maximization;

public class Main {

	public static void main(String[] args) {
		String expression = "177-661*999*99-133+221+334+555-166-144-551-166*166-166*166-133*88*55-11*4+55*888*454*12+11-66+444*99";
		int result = 300;
		System.out.println(result);
		System.out.println(new Solution().solution(expression));
	}
}
