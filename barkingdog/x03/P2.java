package barkingdog.x03;

import java.util.Arrays;

public class P2 {
    public static boolean func2(int[] arr, int len){
//        얘는 다 저장해놓고 한번에 확인
//        int[] flag = new int[51];
//        for(int arrVal: arr){
//            if(arrVal>50) flag[100-arrVal]++;
//            else flag[arrVal]++;
//        }
//        return Arrays.stream(flag).anyMatch(p-> p==2);

        // 얘는 맞는 친구 나오면 바로 끝!
        int[] flag = new int[101];
        for(int arrVal: arr){
            if(flag[100-arrVal]==1) return true;
            else flag[arrVal] = 1;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(func2(new int[]{1, 52, 48},3));
        System.out.println(func2(new int[]{50,42},2));
        System.out.println(func2(new int[]{4,13,63,87},4));
    }

}
