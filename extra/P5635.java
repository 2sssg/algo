package extra;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P5635 {
    static class Student implements Comparable<Student>{
        String name;
        int day;
        int month;
        int year;

        public String getName() {
            return name;
        }

        public Student(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }

        @Override
        public int compareTo(Student o) {
            if(this.year == o.year){
                if(this.month == o.month){
                    return this.day - o.day;
                }
                return this.month - o.month;
            }
            return this.year - o.year;
        }
    }static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void est() throws IOException {st = new StringTokenizer(br.readLine());}
    static int rstn() throws IOException{return Integer.parseInt(st.nextToken());}
    static List<Student> students = new ArrayList<>();
    static int N;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; ++i){
            est();
            students.add(new Student(st.nextToken(),rstn(),rstn(),rstn()));
        }
        Collections.sort(students);
        System.out.println(students.get(N-1).getName());
        System.out.println(students.get(0).getName());
    }
}
