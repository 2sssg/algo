package extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2845 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int p;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken())*Integer.parseInt(st.nextToken());
        System.out.println(Arrays.toString(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).map(t->t-p).toArray()).replaceAll("[\\[\\],]",""));
    }
}
