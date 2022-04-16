package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Hashing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += ((str.charAt(i) - 96) * Math.pow(31, i)) % 1234567891;
        }
        System.out.println(sum);
    }
}
