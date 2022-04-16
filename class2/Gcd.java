package class2;

import java.util.Scanner;

public class Gcd {
    static int a, b;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        int min = (a < b) ? a : b;
        // 참이면 a이고 아니면 b 인거지.
        int gcd = 0;
        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) gcd = i;
        }
        System.out.println(gcd);
        System.out.println(a * b / gcd);

    }
}
