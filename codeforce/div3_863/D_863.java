package codeforce.div3_863;
import java.util.*;

public class D_863 {
	static long[] fibonacci;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int t = scanner.nextInt();
		fibonacci = new long[45];
		fibonacci[0] = 1;
		fibonacci[1] = 1;
		for (int i = 2; i <= 44; i++) {
			fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
		}

		while (t-- > 0) {
			int n = scanner.nextInt();
			int x = scanner.nextInt();
			int y = scanner.nextInt();

			if ((x == 1 || x == fibonacci[n]) && (y == 1 || y == fibonacci[n+1])) {
				System.out.println("YES");
			} else {
				boolean ans = false;
				for (int i = 1; i <= n; i++) {
					if (x == fibonacci[i] && y == 1) {
						ans = true;
						break;
					} else if (y == fibonacci[i] && x == 1) {
						ans = true;
						break;
					}
				}
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= n; j++) {
						if (i == j) continue;
						if (x >= fibonacci[i] && y >= fibonacci[j] && x-fibonacci[i] <= fibonacci[n-i+1] && y-fibonacci[j] <= fibonacci[n-j+1]) {
							if ((x-fibonacci[i] == 0 || x-fibonacci[i] == fibonacci[n-i+1]) && (y-fibonacci[j] == 0 || y-fibonacci[j] == fibonacci[n-j+1])) {
								ans = true;
								break;
							}
							if ((y-fibonacci[j] == 0 || y-fibonacci[j] == fibonacci[n-j+1]) && (x-fibonacci[i] == 0 || x-fibonacci[i] == fibonacci[n-i+1])) {
								ans = true;
								break;
							}
						}
					}
				}
				System.out.println(ans ? "YES" : "NO");
			}
		}

		scanner.close();
	}
}