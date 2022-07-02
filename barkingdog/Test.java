package barkingdog;

import java.io.*;
import java.util.*;

public class Test {

    public static void main(String[] args) {
        int N = 4;
        int[][] arr = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        int[][] temp = new int[N][N];
        for(int i=0; i<N; ++i){
            temp[i] = arr[i].clone();
        }

        for(int n=0; n<N; ++n){
            for(int m=0; m<N; ++m){
                arr[n][m] = temp[m][N-1-n];
            }
        }

        for(int i=0; i<N; ++i){
            System.out.println(Arrays.toString(arr[i]));
        }

    }
}
