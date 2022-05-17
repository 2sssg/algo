package barkingdog.x11;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1744 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int rn() throws IOException {return Integer.parseInt(br.readLine());}

    static int N,iszero;
    static long ans;
    static int[] minusarr = new int[51];
    static int[] plusarr = new int[51];

    public static void main(String[] args) throws IOException {
        N = rn();
        int minusidx = 0;
        int plusidx = 0;
        int curnum;
        for(int i=0; i<N; ++i){
            curnum = rn();
            if(curnum==0){
                iszero = 1;
            }else if(curnum>0){
                plusarr[plusidx++] = curnum;
            }else{
                minusarr[minusidx++] = curnum;
            }
        }
        Arrays.sort(plusarr);
        Arrays.sort(minusarr);
        if((minusidx&1) == 1 && iszero!=1){
            minusarr[minusidx] = 1;
        }
//        System.out.println(Arrays.toString(plusarr));
//        System.out.println(Arrays.toString(minusarr));

        for(int i=0; i<minusidx; i=i+2){
            ans += (long) minusarr[i]*minusarr[i+1];
        }
        for(int i=50; i>50-plusidx; i=i-2){
            if(plusarr[i-1]<=1){
                ans += plusarr[i];
                i++;
            }else{
                ans += (long)plusarr[i]*plusarr[i-1];
            }
        }
        System.out.println(ans);
    }
}
