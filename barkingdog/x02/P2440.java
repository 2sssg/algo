package barkingdog.x02;

import java.util.Scanner;

public class P2440 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=sc.nextInt(); i>0; i--){
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
