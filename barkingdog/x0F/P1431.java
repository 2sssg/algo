package barkingdog.x0F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1431 {
    static class Guitar implements Comparable<Guitar>{
        String serial; int numsum=0;

        public Guitar(String serial) {
            this.serial = serial;
            for(int i=0; i<serial.length(); ++i){
                if(serial.charAt(i)>='0' && serial.charAt(i)<='9'){
                    numsum += serial.charAt(i)-'0';
                }
            }
        }

        @Override
        public String toString() {
            return serial;
        }

        @Override
        public int compareTo(Guitar o) {
            if(this.serial.length() != o.serial.length()){
                return this.serial.length()-o.serial.length();
            }
            else if(this.numsum != o.numsum){
                return this.numsum-o.numsum;
            }
            else{
                return this.serial.compareTo(o.serial);
            }
        }
    }
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Guitar[] guitars;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        guitars = new Guitar[N];
        for(int i=0; i<N; ++i){
            guitars[i] = new Guitar(br.readLine());
        }
        Arrays.sort(guitars);
        for(Guitar g : guitars){
            System.out.println(g);
        }
    }
}
