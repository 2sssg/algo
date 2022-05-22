package barkingdog;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(Arrays.binarySearch(arr,0,6,1));
        System.out.println(Arrays.binarySearch(arr,0,6,2));
        System.out.println(Arrays.binarySearch(arr,2,6,3));
        System.out.println(Arrays.binarySearch(arr,0,6,4));
        System.out.println(Arrays.binarySearch(arr,0,6,5));
        System.out.println(Arrays.binarySearch(arr,0,5,6));
    }
}
