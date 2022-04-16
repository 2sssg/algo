package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ClimbStairs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        int[][] answer;
        int[] stairs;
        int[] stairsFlag;
        N = Integer.parseInt(br.readLine());
        stairs = new int[N+1];
        answer = new int[N+1][2];

        for(int i=0; i<N; i++) stairs[i] = Integer.parseInt(br.readLine());
        stairs[N] = -99999999;

        for(int i = 0; i<N+1; i++){
            Arrays.fill(answer[i],-999999999);
        }
        answer[0][0] = stairs[0];
        answer[1][0] = stairs[1];
        answer[1][1] = stairs[1]+stairs[0];

        for(int i = 2; i<N; i++){
            answer[i][0] = Math.max(answer[i-2][0],answer[i-2][1])+stairs[i];
            answer[i][1] = answer[i-1][0]+stairs[i];
        }

//        for(int i =0; i<answer.length; i++){
//            System.out.print(answer[i][0] +"    ");
//            System.out.println(answer[i][1]);
//        }
        System.out.println(Math.max(answer[N-1][0],answer[N-1][1]));
    }
}
