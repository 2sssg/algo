package barkingdog;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        swap(a);
        System.out.println(Arrays.toString(a));
    }
    public static void swap(int[] r){
        int tmp = r[0];
        r[0] = r[1];
        r[1] = tmp;
    }
}
