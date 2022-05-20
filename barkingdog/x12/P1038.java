package barkingdog.x12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P1038 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static boolean isDown(int n){
        tempchar = 1000;
        for(char c: String.valueOf(n).toCharArray()){
            if(tempchar<=c){
                return false;
            }
            tempchar = c;
        }
        return true;
    }

    static int N,idx;
    static char[] arr;
    static char tempchar = 1000;
    static Queue<Integer> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        String temp = br.readLine();
        N = Integer.parseInt(temp);
        arr = temp.toCharArray();

        for(int i=0; i<Integer.MAX_VALUE; ++i){
            if(isDown(i)){
//                System.out.println("i : " + i);
//                System.out.println("idx : " + idx);
//                System.out.println();
                if(N==idx){
                    System.out.println(i);
                    System.exit(0);
                    break;
                }
                if(isDown(i)) idx++;
            }
        }
        System.out.println("-1");
    }
}
