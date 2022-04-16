package barkingdog.x02;

import java.io.*;
import java.util.StringTokenizer;

public class P10804 {
    static int[] card = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
    static int A,B;
    static StringTokenizer st;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int swap(int f, int s){
        return f;
    }

    public static void display() throws IOException {
        for(int i=0; i<20; i++){
            bw.write(String.valueOf(card[i]));
            bw.write(" ");
        }
    }

    public static void main(String[] args) throws IOException {
        while(true){
            for(int i=0; i<1; i++){
                st = new StringTokenizer(br.readLine());
                A = Integer.parseInt(st.nextToken())-2;
                B = Integer.parseInt(st.nextToken());
                while(B-->A++) {
                    card[B] = swap(card[A],card[A]=card[B]);
                }
            }
            display();
            bw.flush();
        }
//        bw.close();
    }
}
