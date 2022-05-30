package barkingdog.x16;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P19700 {
    static class Student implements Comparable<Student>{
        int height;
        int priority;

        public Student(int height, int priority) {
            this.height = height;
            this.priority = priority;
        }

        @Override
        public int compareTo(Student o) {
            if(this.height==o.height){
                return o.priority-this.priority;
            }
            return o.height-this.height;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "height=" + height +
                    ", priority=" + priority +
                    '}';
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,h,p;
    static Student[] students;
    static Student student;
    //조의 팀원 수[몇 조,몇 조]
    static TreeMap<Integer,HashSet<Integer>> tm = new TreeMap<>();
    static TreeSet<List<Integer>> ts = new TreeSet<>(new Comparator<List<Integer>>() {
        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
            if(o1.size()==1){
                if(o1.get(0)<0){
                    return (-1*o1.get(0))-o2.size();
                }
            }
            if(o1.size()==o2.size()){
                return -1;
            }
            return o1.size()-o2.size();
        }
    });

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        students = new Student[N];
        for(int i=0; i<N; ++i){
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            students[i] = new Student(h,p);
        }
        Arrays.sort(students);
//        System.out.println(Arrays.toString(students));
        for(int i=0; i<N; ++i){ //500,000
//            System.out.println(ts);
            student = students[i];
            List<Integer> temp = new ArrayList<>();
            temp.add(-1*student.priority);
            if(ts.lower(temp)!=null){
                ts.lower(temp).add(i);
//                System.out.println("TEMPTEMP");
            }else{
                temp.clear();
                temp.add(i);
//                System.out.println("temp : "+ temp);
                ts.add(temp);
            }
        }
        System.out.println(ts.size());
    }
}
