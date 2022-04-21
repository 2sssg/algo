package barkingdog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        int a = Integer.parseInt(br.readLine());
        int tmp;
        while(true){
            tmp = Integer.parseInt(br.readLine());
            if(tmp == 0) break;
            else if((tmp%a)==0) System.out.printf("%d is a multiple of %d.\n",tmp,a);
            else System.out.printf("%d is NOT a multiple of %d.\n",tmp,a);
        }
    }
}
