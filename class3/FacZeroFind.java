package class3;

import java.io.*;
import java.util.Arrays;

public class FacZeroFind {
    static int[] flagArr = new int[501];
    static int five,two;
    static int[] fivearr = new int[501];
    static int[] twoarr = new int[501];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        five = 0;
        two =0;
        int n = Integer.parseInt(br.readLine());
        for(int i=1; i<n+1; i++){
            String t = findFiveAndTwo(i,0,0);
            flagArr[i] = 1;
            fivearr[i] = Integer.parseInt(t.split(" ")[0]);
            twoarr[i] = Integer.parseInt(t.split(" ")[1]);
            five += fivearr[i];
            two += twoarr[i];
        }
        System.out.println(Math.min(five,two));
    }

    public static String findFiveAndTwo(int num,int f , int t){
        if(flagArr[num] == 1){
            return f+fivearr[num]+" "+(t+twoarr[num]);
        }
        if(num%5 == 0){
            num /= 5;
            String[] tmp = findFiveAndTwo(num,++f,t).split(" ");
            f = Integer.parseInt(tmp[0]);
            t = Integer.parseInt(tmp[1]);
            return f+" "+t;
        }
        if(num%2 == 0 ){
            num/=2;
            String[] tmp = findFiveAndTwo(num,f,++t).split(" ");
            f = Integer.parseInt(tmp[0]);
            t = Integer.parseInt(tmp[1]);
            return f+" "+t;
        }

        return f+" "+t;
    }

}
