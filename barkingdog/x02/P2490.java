package barkingdog.x02;

import java.io.*;
import java.util.Arrays;

public class P2490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<3; i++){
            switch (Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum()){
                case 0:
                    bw.write("D\n");
                    break;
                case 1:
                    bw.write("C\n");
                    break;
                case 2:
                    bw.write("B\n");
                    break;
                case 3:
                    bw.write("A\n");
                    break;
                case 4:
                    bw.write("E\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
