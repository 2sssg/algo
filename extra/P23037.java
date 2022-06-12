package extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P23037 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).map(p->p*p*p*p*p).sum());
    }
}
