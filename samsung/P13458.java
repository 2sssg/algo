package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P13458 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,master,sub;
    static long ans;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        st = new StringTokenizer(br.readLine());
        master = Integer.parseInt(st.nextToken());
        sub = Integer.parseInt(st.nextToken());
        System.out.println(Arrays.stream(arr).map(p->p-master<=0?0:(p-master)%sub==0?(p-master)/sub:(p-master)/sub+1).sum());
        for(int temp : Arrays.stream(arr).map(p->p-master<=0?0:(p-master)%sub==0?(p-master)/sub:(p-master)/sub+1).toArray()) ans += temp;
        System.out.println(ans+(long)N);
    }
}
