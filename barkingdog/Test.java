package barkingdog;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Test {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args){
        for(int i=0; i<100; i++){
            try{
                bw.write(br.readLine());
                bw.write("\n");
            }catch (Exception e){
                try{
                    bw.flush();
                    bw.close();
                }catch (Exception e1){
                }
            }
        }
    }
}
