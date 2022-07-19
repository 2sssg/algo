package extra;

import Constant.Source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1083 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,s;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        br = Source.getBufferedReader();
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        s = Integer.parseInt(br.readLine());
        for (int i = 0; i < N && s>0; i++) {
            int max = arr[i], maxi = i;
            for (int j = i + 1; j < N && j <= i + s; j++) {
                if (max < arr[j]) {
                    max = arr[j];
                    maxi = j;
                }
            }
            s -= maxi - i;
            while (maxi > i) {
                arr[maxi] = arr[maxi - 1];
                maxi--;
            }
            arr[i] = max;
        }
        System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]",""));
    }
}