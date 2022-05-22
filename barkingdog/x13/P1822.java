package barkingdog.x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1822 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Integer> ans = new ArrayList<>();
    static int[] A,B;
    static int Alen,Blen;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        Alen = Integer.parseInt(st.nextToken());
        Blen = Integer.parseInt(st.nextToken());
        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(B);
        Arrays.sort(A);
        for(int a: A){
            if(Arrays.binarySearch(B,a)<0){
                ans.add(a);
            }
        }
        System.out.println(ans.size());
        System.out.println(ans.toString().replaceAll("[\\[\\],]",""));
    }
}
