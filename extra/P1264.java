package extra;

import java.util.Scanner;

public class P1264 {
    public static void main(String[] args){
        String temp;
        Scanner sc = new Scanner(System.in);
        while(true){
            temp = sc.nextLine();
            if(temp.equals("#")) break;
            System.out.println(temp.split("[aeiouAEIOU]").length-1);
        }
    }
}
