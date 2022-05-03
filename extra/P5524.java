package extra;

import java.io.*;
import java.util.Locale;

public class P5524 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        while(N-->0){
            bw.write(br.readLine().toLowerCase(Locale.ROOT));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
