package barkingdog.x12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2004 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int func(int num){
        if(d[num]!=0){
            return d[num];
        }

        d[num] = num*func(num-1);
        five[num] =0;
        return d[num];
    }
    static int findfive(int n){
        int ret=0;
        while(n%5==0){
            n /= 5;
            ret++;
        }
        return ret;
    }
    static int findtwo(int n){
        int ret=0;
        while(n%2==0){
            n /= 2;
            ret++;
        }
        return ret;
    }
    static int[] five,two,d;
    static int N,K;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        d = new int[N+10];
        five = new int[N+10];
        two = new int[N+10];


    }
}

//N! / N!(N-K)!