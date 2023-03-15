package dfs;
import java.util.Scanner;

public class Temp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); // number of test cases
		while (t-- > 0) {
			int n = sc.nextInt(); // number of points
			int[] x = new int[n]; // array to store the coordinates of the points
			for (int i = 0; i < n; i++) {
				x[i] = sc.nextInt();
			}
			boolean flag = true; // flag to check if the points can be moved to form a consecutive segment
			for (int i = 0; i < n - 1; i++) {
				int diff = Math.abs(x[i] - x[i+1]); // calculate the difference between two adjacent points
				if (diff > 1) { // if the difference is greater than 1, the points cannot be moved to form a consecutive segment
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}


