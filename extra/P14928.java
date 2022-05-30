package extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P14928 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static BigInteger bi,bi2;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        bi = new BigInteger(st.nextToken());
        bi2 = new BigInteger(st.nextToken());
        System.out.println(bi.add(bi2));
    }
}
