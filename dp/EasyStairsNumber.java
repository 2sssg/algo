package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EasyStairsNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, number;
        int[] numberArr = new int[10];
        int[] tempNumberArr = new int[10];
        for(int i = 1; i<10; i++) numberArr[i]++;

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N-1; i++){
            for(int j = 0; j<10; j++) tempNumberArr[j] = numberArr[j];
            for(int j=0; j<10; j++){
                number = tempNumberArr[j];
                if(j==0) numberArr[j+1] += number;
                else if(j==9) numberArr[j-1] += number;
                else{
                    numberArr[j-1] += number;
                    numberArr[j+1] += number;
                }
            }
            for(int j = 0; j<10; j++){
                numberArr[j] -= tempNumberArr[j];
                numberArr[j] %= 1000000000;
            }

//                System.out.println(Arrays.toString(numberArr));
        }
        int sum = 0;
        for(int i =0; i<10; i++){
            sum += numberArr[i];
            sum %= 1000000000;

        }
        System.out.println(sum);


    }
}
