package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LIS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N,count;
        int[] arr,answer;

        //////////////////////////////////////////////////

        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        answer = new int[N];
        answer[0] = 1;
        for(int i=1; i<N; i++){
            count = i;
            for(int j=i; j>=0; j--){
                if(arr[i]>arr[j]){
                    count = answer[count]<answer[j]?j:count;
                }
            }
            if(count == i){
                answer[i] = 1;
            }else{
                answer[i] = answer[count]+1;
            }
        }

//        Arrays.stream(answer).forEach(System.out::println);
        System.out.println(Arrays.stream(answer).max().getAsInt());

    }
}
