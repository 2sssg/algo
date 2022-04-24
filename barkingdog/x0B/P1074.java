package barkingdog.x0B;

import java.io.*;
import java.util.StringTokenizer;

public class P1074 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;


    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn() throws IOException{return Integer.parseInt(st.nextToken());}

    static int func(int n, int r, int c){
        if(r==0 && c==0){
            return 0;
        }else if(r==0 && c==1){
            return 1;
        }else if(r==1 && c==0){
            return 2;
        }else if(r==1 && c==1){
            return 3;
        }

        if(1<<(n-1) > r){
            if(1<<(n-1) > c){
                return func(n-1,r,c);
            }else if(1<<(n-1) <= c){
                return (1<<(2*(n-1))) + func(n-1, r, c-(1<<(n-1)));
            }
        }else if(1<<(n-1) <= r){
            if(1<<(n-1) > c){
                return (1<<(2*(n-1)))*2 + func(n-1,r-(1<<(n-1)),c);
            }else if(1<<(n-1) <= c){
                return (1<<(2*(n-1)))*3 + func(n-1, r-(1<<(n-1)), c-(1<<(n-1)));
            }
        }
        return 1;
    }

    static int N,r,c;



    public static void main(String[] args) throws IOException {
        est(); N = rstn(); r = rstn(); c = rstn();

        System.out.println(func(N,r,c));
    }
}
