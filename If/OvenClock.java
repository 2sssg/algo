package If;

import java.io.*;
import java.util.StringTokenizer;

public class OvenClock {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int time;

        st = new StringTokenizer(br.readLine());
        time = Integer.parseInt(st.nextToken()) * 60;
        time += Integer.parseInt(st.nextToken());
        time += Integer.parseInt(br.readLine());

        bw.write(time/60>23?String.valueOf(time/60 - 24):String.valueOf(time/60));
        bw.write(" ");
        bw.write(String.valueOf(time%60));

        bw.flush();
        bw.close();
    }
}
