package extra;

import java.io.*;
import java.util.StringTokenizer;

public class Bunsan {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int N,a,b,answer;

        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken())%10;
            b = Integer.parseInt(st.nextToken());
            answer = a;
            for(int j=1; j<b; j++){
                answer *= a;
                answer %= 10;
            }

            bw.write(answer==0?"10":String.valueOf(answer));
            bw.write("\n");
        }

        bw.flush();
        bw.close();




    }
}
