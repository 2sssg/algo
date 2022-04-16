package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class IntegerTriangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] triangleArray,answer;

        StringTokenizer st;
        int N,count;

        N = Integer.parseInt(br.readLine());
        if(N == 1){
            System.out.println(br.readLine());
        }else{
            triangleArray = new int[N][N];
            answer = new int[N][N];

            for(int i = 0; i < N; i++){
                Arrays.fill(answer[i],-9999999);
            }

            for(int i = 0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                count = 0;
                while(st.hasMoreTokens()){
                    triangleArray[i][count++] = Integer.parseInt(st.nextToken());
                }
            }

            answer[0][0] = triangleArray[0][0];
            answer[1][0] = answer[0][0] + triangleArray[1][0];
            answer[1][1] = answer[0][0] + triangleArray[1][1];
            for(int i = 2; i < N; i++){
                for(int j = 0; j <= i; j++){
                    if(j==0){
                        answer[i][j] = answer[i-1][j]+ triangleArray[i][j];
                    }else{
                        answer[i][j] = Math.max(answer[i-1][j]+triangleArray[i][j], answer[i-1][j-1]+triangleArray[i][j]);
                    }
                }
            }

            System.out.println(Arrays.stream(answer[N-1]).max().getAsInt());

        }

    }
}
