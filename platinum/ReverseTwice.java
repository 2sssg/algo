package platinum;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseTwice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N, beforeSorted, afterSorted, oneLoc, tenLoc;
        boolean flag;

        oneLoc = -1;
        tenLoc = -1;
        beforeSorted = -1;
        afterSorted = -1;
        int[] arr,sortedArr;
        sortedArr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i =0; i<10; i++){
            if(arr[i]==1){
                oneLoc = i;
            }else if(arr[i]==10){
                tenLoc = i;
            }
        }
        for(int i=0; i<10; i++){
            if(!(arr[i] == i+1)){
                beforeSorted = i;
                break;
            }
        }
        for(int i=9; i>=0; i--){
            if(!(arr[i] == i+1)){
                afterSorted = i;
                break;
            }
        }

        // 중간에 바꾸고
        // 전체뒤집기

        // 처음~1값까지 바꾸고
        // 뒤에 정렬 직전값~ 정렬된부분까지 뒤집기 O

        // 10값~ 끝값까지 바꾸고
        // 정렬 된 다음부분~ 정렬된 다음값까지 뒤집기

        // 전체 두번 뒤집기
        ////////////////////////////////////////



        ////////////////////////////////////////

        arr = reverseRange(arr,0,oneLoc);
        for(int i=0; i<10; i++){
            if(!(arr[i] == i+1)){
                beforeSorted = i;
                break;
            }
        }
        for(int i=9; i>=0; i--){
            if(!(arr[i] == i+1)){
                afterSorted = i;
                break;
            }
        }
        arr = reverseRange(arr,beforeSorted,afterSorted);
        System.out.println(Arrays.toString(arr));

        for(int i=0; i<10; i++){
            if(arr[i] != i+1){
                flag = false;
                break;
            }
            flag = true;
        }




//        if(arr[0] == 1 && arr[9] == 10){
//
//        }else if(arr[0] == 1 && arr[9] != 10){
//
//        }else if(arr[0] != 1 && arr[9] == 10){
//
//        }else{
//
//        }
    }



    public static int[] reverseRange(int[] originArr, int beforeIndex, int afterIndex){
        int[] copy = Arrays.copyOfRange(originArr,beforeIndex,afterIndex+1);
        List<Integer> list = Arrays.stream(copy).boxed().collect(Collectors.toList());
        Collections.reverse(list);
        copy = list.stream().mapToInt(i->i).toArray();

        for(int i =0; i<copy.length; i++){
            originArr[beforeIndex++] = copy[i];
        }

        return originArr;
    }
}
