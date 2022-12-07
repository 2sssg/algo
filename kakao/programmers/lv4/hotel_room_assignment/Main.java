package kakao.programmers.lv4.hotel_room_assignment;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		long k; long[] room_number; long[] result;

		k = 10;
		room_number = new long[]{1,3,4,1,3,1};
		result = new long[]{1,3,4,2,5,6};

		System.out.println("result : " + Arrays.toString(result));
		System.out.println("my result : " + Arrays.toString(new Solution().solution(k, room_number)));
		System.out.println("assert : " + Arrays.equals(result, new Solution().solution(k, room_number)));
	}
}
