package barkingdog.x03;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class P1919 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr = new int[26];
    public static void main(String[] args) throws IOException {
        for(char c: br.readLine().toCharArray()) ++arr[c-'a'];
        for(char c: br.readLine().toCharArray()) --arr[c-'a'];
        System.out.println(Arrays.stream(arr).map(Math::abs).sum());
    }
}
