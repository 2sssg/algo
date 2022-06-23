package extra;

import Constant.Source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15829 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int L;
    static long ans;
    static String s;
//    static int

    // 10 9 8 7 6 5 4 3 2 1

    public static void main(String[] args) throws IOException {
        ans = 0;
        br = Source.getBufferedReader();
        L = Integer.parseInt(br.readLine());
        s = br.readLine();
        for(int i=0; i<L; ++i){
            long temp = (s.charAt(i)-'a'+1);
            for(int j=0; j<i; ++j){
                temp = temp*31%1234567891;
            }
            ans += temp;
            ans %= 1234567891;
        }
        System.out.println(ans);



    }
}
