package dev_matching.p2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
	class Pair{
		int x,y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	class Rec{
		int t1,t2,t3,t4,t5, cnt, hard, g, s, b, sum;
		String name;

		@Override
		public String toString() {
			return "Rec{" +
					"t1=" + t1 +
					", t2=" + t2 +
					", t3=" + t3 +
					", t4=" + t4 +
					", t5=" + t5 +
					", cnt=" + cnt +
					", hard=" + hard +
					", g=" + g +
					", s=" + s +
					", b=" + b +
					", sum=" + sum +
					", name='" + name + '\'' +
					'}';
		}

		public Rec(String name, int t1, int t2, int t3, int t4, int t5) {
			this.name = name;
			cnt = 0;
			hard = -1;
			g = s = b = 0;
			this.t1 = t1;
			this.t2 = t2;
			this.t3 = t3;
			this.t4 = t4;
			this.t5 = t5;
			sum = t1 + t2 + t3 + t4 + t5;
			if (t1 != 0) {
				hard = 1;
				cnt++;
			}
			if (t2 != 0) {
				hard = 2;
				cnt++;
			}
			if (t3 != 0) {
				hard = 3;
				cnt++;
			}
			if (t4 != 0) {
				hard = 4;
				cnt++;
			}
			if (t5 != 0) {
				hard = 5;
				cnt++;
			}
		}
	}

	public String[] solution(String[] record) {
		List<Rec> ptp = new ArrayList<>();
		List<Pair> re1 = new ArrayList<>();
		List<Pair> re2 = new ArrayList<>();
		List<Pair> re3 = new ArrayList<>();
		List<Pair> re4 = new ArrayList<>();
		List<Pair> re5 = new ArrayList<>();

		for (int i = 0; i < record.length; ++i) {
			String name = record[i].split(":")[0];
			int[] temp = Arrays.stream(record[i].split(":")[1].split(",")).mapToInt(Integer::parseInt).toArray();
			ptp.add(new Rec(name, temp[0], temp[1], temp[2], temp[3], temp[4]));
			if (temp[0] != 0) {
				re1.add(new Pair(temp[0], i));
			}
			if (temp[1] != 0) {
				re2.add(new Pair(temp[1], i));
			}if (temp[2] != 0) {
				re3.add(new Pair(temp[2], i));
			}if (temp[3] != 0) {
				re4.add(new Pair(temp[3], i));
			}if (temp[4] != 0) {
				re5.add(new Pair(temp[4], i));
			}
		}

		re1.sort(new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.x - o2.x;
			}
		});
		re2.sort(new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.x - o2.x;
			}
		});
		re3.sort(new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.x - o2.x;
			}
		});
		re4.sort(new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.x - o2.x;
			}
		});
		re5.sort(new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.x - o2.x;
			}
		});
		int gold = Integer.parseInt(String.format("%.0f", ((double)re1.size() / 12)));
		int silver = Integer.parseInt(String.format("%.0f", ((double)re1.size() / 4)));
		int bronze = Integer.parseInt(String.format("%.0f", ((double)re1.size() / 2)));
		for (int i = 0; i < gold; ++i) {
			ptp.get(re1.get(i).y).g++;
		}
		for (int i = gold; i < silver; ++i){
			ptp.get(re1.get(i).y).s++;
		}
		for (int i = silver; i < bronze; ++i){
			ptp.get(re1.get(i).y).b++;
		}

		gold = Integer.parseInt(String.format("%.0f", ((double)re2.size() / 12)));
		silver = Integer.parseInt(String.format("%.0f", ((double)re2.size() / 4)));
		bronze = Integer.parseInt(String.format("%.0f", ((double)re2.size() / 2)));
		for (int i = 0; i < gold; ++i) {
			ptp.get(re2.get(i).y).g++;
		}
		for (int i = gold; i < silver; ++i){
			ptp.get(re2.get(i).y).s++;
		}
		for (int i = silver; i < bronze; ++i){
			ptp.get(re2.get(i).y).b++;
		}

		gold = Integer.parseInt(String.format("%.0f", ((double)re3.size() / 12)));
		silver = Integer.parseInt(String.format("%.0f", ((double)re3.size() / 4)));
		bronze = Integer.parseInt(String.format("%.0f", ((double)re3.size() / 2)));
		for (int i = 0; i < gold; ++i) {
			ptp.get(re3.get(i).y).g++;
		}
		for (int i = gold; i < silver; ++i){
			ptp.get(re3.get(i).y).s++;
		}
		for (int i = silver; i < bronze; ++i){
			ptp.get(re3.get(i).y).b++;
		}

		gold = Integer.parseInt(String.format("%.0f", ((double)re4.size() / 12)));
		silver = Integer.parseInt(String.format("%.0f", ((double)re4.size() / 4)));
		bronze = Integer.parseInt(String.format("%.0f", ((double)re4.size() / 2)));
		for (int i = 0; i < gold; ++i) {
			ptp.get(re4.get(i).y).g++;
		}
		for (int i = gold; i < silver; ++i){
			ptp.get(re4.get(i).y).s++;
		}
		for (int i = silver; i < bronze; ++i){
			ptp.get(re4.get(i).y).b++;
		}

		gold = Integer.parseInt(String.format("%.0f", ((double)re5.size() / 12)));
		silver = Integer.parseInt(String.format("%.0f", ((double)re5.size() / 4)));
		bronze = Integer.parseInt(String.format("%.0f", ((double)re5.size() / 2)));
		for (int i = 0; i < gold; ++i) {
			ptp.get(re5.get(i).y).g++;
		}
		for (int i = gold; i < silver; ++i){
			ptp.get(re5.get(i).y).s++;
		}
		for (int i = silver; i < bronze; ++i){
			ptp.get(re5.get(i).y).b++;
		}
		ptp.sort((o1, o2) -> {
			if (o1.cnt == o2.cnt) {
				if (o1.hard == o2.hard) {
					if (o1.g == o2.g) {
						if (o1.s == o2.s) {
							if (o1.b == o2.b) {
								if (o1.sum == o2.sum) {
									return o1.name.compareTo(o2.name);
								}
								return o1.sum - o2.sum;
							}
							return o2.b - o1.b;
						}
						return o2.s - o1.s;
					}
					return o2.g - o1.g;
				}
				return o2.hard - o1.hard;
			}
			return o2.cnt - o1.cnt;
		});
		System.out.println(ptp);

		String[] answer = new String[ptp.size()];
		for (int i = 0; i < ptp.size(); ++i) {
			answer[i] = ptp.get(i).name;
		}
		return answer;
	}
}
