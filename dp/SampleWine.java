package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SampleWine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N,max,wineAmount,realmax;
        int[][] answer;
        N = Integer.parseInt(br.readLine());
        if(N == 1){
            System.out.println(br.readLine());
        }else{
            max = -999;
            answer = new int[2][N+2];
            Arrays.fill(answer[0],-9);
            Arrays.fill(answer[1],-9);
            answer[0][0] = Integer.parseInt(br.readLine());
            answer[0][1] = Integer.parseInt(br.readLine());
            answer[1][1] = answer[0][0] + answer[0][1];
            realmax = Math.max(Math.max(answer[0][0],answer[0][1]),answer[1][1]);
            for(int i = 2; i < N; i++){
                max = Math.max(Math.max(answer[0][i-2],answer[1][i-2]),max);
                wineAmount = Integer.parseInt(br.readLine());
                answer[0][i] = max+wineAmount;
                answer[1][i] = answer[0][i-1]+wineAmount;
                realmax = Math.max(Math.max(answer[0][i],answer[1][i]),realmax);
            }

            System.out.println(realmax);
        }

    }
}
/*
10
0
0
10
0
5
10
0
0
1
10
 */