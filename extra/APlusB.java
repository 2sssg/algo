package extra;

import java.io.*;
import java.util.StringTokenizer;

public class APlusB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T;

        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine(), ",");
            bw.write(String.valueOf(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken())));
            bw.write("\n");
        }
        bw.flush();
        bw.close();


    }
}
