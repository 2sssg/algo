package kakao.programmers.lv2.deli;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
	class Pair {
		// index, cnt
		int x,y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pair{" +
					"x=" + x +
					", y=" + y +
					'}';
		}
	}

	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		Deque<Pair> deliq = new ArrayDeque<>();
		Deque<Pair> pickq = new ArrayDeque<>();
		long answer = 0;

		int delsum = Arrays.stream(deliveries).sum();
		int picksum = Arrays.stream(pickups).sum();

		for (int i = deliveries.length - 1; i >= 0; --i) {
			if (deliveries[i] == 0) continue;
			deliq.add(new Pair(i, deliveries[i]));
		}

		for (int i = pickups.length - 1; i >= 0; --i) {
			if (pickups[i] == 0) continue;
			pickq.add(new Pair(i, pickups[i]));
		}

		while (delsum != 0 || picksum != 0) {
			System.out.println(deliq);
			System.out.println(pickq);
			int delamount = Math.min(cap, delsum);
			delsum -= delamount;
			int distance = 0;

			while (delamount != 0) {
				Pair house = deliq.pollFirst();
				distance = Math.max(distance, house.x);
				if (house.y > delamount) {
					house.y -= delamount;
					deliq.addFirst(house);
					delamount = 0;
				} else {
					delamount -= house.y;
				}
			}

			int pickamount = Math.min(cap, picksum);
			picksum -= pickamount;
			while (pickamount != 0) {
				Pair house = pickq.pollFirst();
				distance = Math.max(distance, house.x);
				if (house.y > pickamount) {
					house.y -= pickamount;
					pickq.addFirst(house);
					pickamount = 0;
				} else {
					pickamount -= house.y;
				}
			}
			answer += ((distance + 1) * 2);
			System.out.println(deliq);
			System.out.println(pickq);
			System.out.println(answer);
			System.out.println();
		}
		return answer;
	}
}