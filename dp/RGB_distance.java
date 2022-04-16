package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RGB_distance {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N;
        final int R,G,B;
        R = 0;
        G = 1;
        B = 2;

        int[][] answer = new int[1001][3];
        int[][] rgb = new int[1001][3];

        N = Integer.parseInt(br.readLine());
        // 배열 저장
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<3; j++){
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //answer배열 최대값으로 초기화
        for(int i = 0; i<1001; i++){
            Arrays.fill(answer[i],10000);
        }

        answer[0][R] = rgb[0][R];
        answer[0][G] = rgb[0][G];
        answer[0][B] = rgb[0][B];

        for(int i = 1; i<N; i++){
            answer[i][R] = Math.min(answer[i-1][G]+rgb[i][R], answer[i-1][B]+rgb[i][R]);
            answer[i][G] = Math.min(answer[i-1][R]+rgb[i][G], answer[i-1][B]+rgb[i][G]);
            answer[i][B] = Math.min(answer[i-1][R]+rgb[i][B], answer[i-1][G]+rgb[i][B]);
        }

        System.out.println(Math.min(Math.min(answer[N-1][R], answer[N-1][G]),answer[N-1][B]));









    }
}
