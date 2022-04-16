package barkingdog.x03;
public class Lecture {
    public static int insert(int idx, int num, int[] arr, int len){
//        임시변수를 만들고 하기
//        int tempNum;
//        for(int i=idx; i<len; i++){
//            tempNum = arr[i];
//            arr[i] = num;
//            num = tempNum;
//        }

//      임시변수를 생성하지 않고 하는 법
        for(int i=len; i>idx; i--) arr[i] = arr[i-1];
        arr[idx] = num;
        return ++len;
    }
    public static int erase(int idx, int[] arr, int len){
        for(int i=idx; i<len; i++) arr[i] = arr[i+1];

        return --len;
    }
    public static void printArr(int[] arr,int len){
        for(int i=0; i<len; i++) System.out.print(arr[i]+" ");
        System.out.println("\n");
    }
    public static void insert_test(){
        int[] arr = new int[10];
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        int len = 3;
        len = insert(3,40,arr,len);
        printArr(arr,len);
        len = insert(1,50,arr,len);
        printArr(arr,len);
        len = insert(0,15,arr,len);
        printArr(arr,len);
    }
    public static void erase_test(){
        int[] arr = new int[10];
        arr[0] = 10;
        arr[1] = 50;
        arr[2] = 40;
        arr[3] = 30;
        arr[4] = 70;
        arr[5] = 20;
        int len = 6;
        len = erase(4,arr,len);
        printArr(arr,len);
        len = erase(1,arr,len);
        printArr(arr,len);
        len = erase(3,arr,len);
        printArr(arr,len);
    }
    public static void main(String[] args) {
        insert_test();
        erase_test();
    }

}
