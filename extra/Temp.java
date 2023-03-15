package extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Temp {
	static List<Pair> list = new ArrayList<>();

	static class Pair {

		public Pair(String name, String type) {
			this.name = name;
			this.type = type;
		}

		String name;
		String type;
	}

	static void init() {
		list.add(new Pair("추상 팩토리","생성"));
		list.add(new Pair("빌더","생성"));
		list.add(new Pair("팩토리 메소드","생성"));
		list.add(new Pair("프로토타입","생성"));
		list.add(new Pair("싱글톤","생성"));

		list.add(new Pair("어댑터","구조"));
		list.add(new Pair("브리지","구조"));
		list.add(new Pair("컴포지트","구조"));
		list.add(new Pair("데코레이터","구조"));
		list.add(new Pair("퍼싸드","구조"));
		list.add(new Pair("플라이웨이트","구조"));
		list.add(new Pair("프록시","구조"));

		list.add(new Pair("책임 연쇄","행위"));
		list.add(new Pair("커맨드","행위"));
		list.add(new Pair("인터프리터","행위"));
		list.add(new Pair("반복자","행위"));
		list.add(new Pair("중재자","행위"));
		list.add(new Pair("메멘토","행위"));
		list.add(new Pair("옵서버","행위"));
		list.add(new Pair("상태","행위"));
		list.add(new Pair("전략","행위"));
		list.add(new Pair("템플릿","행위"));
		list.add(new Pair("방문자","행위"));
	}

	static void problem(int num) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Pair prob = list.get(num);
		System.out.println(prob.name);
		if (br.readLine().equals(prob.type)) {
			list.remove(prob);
			System.out.println("YES");
		} else {
			System.out.println("correct answer : " + prob.type);
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {

		for (int i = 0; i < 3; ++i) init();

		while (!list.isEmpty()) {
			Random random = new Random();
			problem(random.nextInt(list.size()));
		}
	}
}
