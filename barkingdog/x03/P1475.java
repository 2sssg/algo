package barkingdog.x03;

import java.io.*;

public class P1475 {
    static int[] room = new int[10];
    static String roomNum;
    static int max;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        roomNum = br.readLine();
        for(char oneNum : roomNum.toCharArray()) room[oneNum-'0']++;
        for(int i=0; i<10; i++){
            if(i==6 || i==9){
                if((room[6]+room[9] & 1) == 1) max = Math.max(max,(room[6]+room[9])/2 + 1);
                else max = Math.max(max,(room[6]+room[9])/2);
            }
            else max = Math.max(max,room[i]);
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();



    }
}
