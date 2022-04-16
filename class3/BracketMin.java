package class3;

import java.io.*;
import java.util.Arrays;

public class BracketMin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split("-");
        int len = s.length;
        int answer = Arrays.stream(s[0].split("[+]")).mapToInt(Integer::parseInt).sum();
        for(int i=1; i<len; i++) answer -= Arrays.stream(s[i].split("[+]")).mapToInt(Integer::parseInt).sum();
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }
}
