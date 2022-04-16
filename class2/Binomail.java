package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Binomail {
    static int[] facArr = new int[100];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N,K;
        StringTokenizer st = new StringTokenizer(br.readLine());

        facArr[0] = 1;
        facArr[1] = 1;
        facArr[2] = 2;

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        System.out.println(fac(N)/(fac(K)*fac(N-K)));

    }

    public static int fac(int num){
        if(facArr[num]!=0){
            return facArr[num];
        }
        facArr[num] = num *fac(num-1);
        return facArr[num];
    }
}
