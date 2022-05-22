package barkingdog.x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P18869 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int M,N,ans;
    static int[][] arr;
    static int[] uni,temp;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[M][N];
        for(int i=0; i<M; ++i){
            uni = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            temp = Arrays.stream(uni).distinct().toArray();
            Arrays.sort(temp);
            for(int j=0; j<N; ++j) arr[i][j] = Arrays.binarySearch(temp,uni[j]);
        }
        for(int i=0; i<M-1; ++i){
            for(int j=i+1; j<M; ++j){
                if(Arrays.equals(arr[i],arr[j])) ans++;
            }
        }
        System.out.println(ans);
    }
}
