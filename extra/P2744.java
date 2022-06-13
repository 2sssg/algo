package extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class P2744 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        System.out.println(br.readLine().chars().map(p-> 'a'<=p && p<='z'?p-32:p+32).mapToObj(i->(char)i).map(String::valueOf).collect(Collectors.joining()));
    }
}
