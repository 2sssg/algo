package barkingdog.x10;

import java.io.*;

public class P9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println((Integer.parseInt(br.readLine())&1)==1?"SK":"CY");
    }
}
