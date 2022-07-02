package Constant;

import barkingdog.BaekjoonStarter;
import barkingdog.x04.P1406;
import barkingdog.x1B.P1647;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class Source {
    //origin test case file path
    //절대경로를 넣어주어야 합니다.
    static String originFilePath = "/Users/2sssg/workspace/baekjoon/src/Constant/";

    //origin test case file name
    static String originFileName = "input.txt";

    static String testFileName = "input%filenum%.txt";

    //별도의 설정이 없을 시 같은 디렉토리에 만들어지게 됩니다
    //수정이 필요할 시 코드에서 수정이 필요합니다
    static String testFilePath = originFilePath;

    public static int filecnt = 1;

    private static int curfilenum;

    //설정, 내부로직으로 사용됨
    private static BufferedReader getBufferedReader(String FilePath){
        try{
            return new BufferedReader(new FileReader(FilePath));
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("파일 경로 또는 파일명이 잘못되었습니다.");
            System.out.println("콘솔 입력으로 진행합니다.");
            return new BufferedReader(new InputStreamReader(System.in));
        }
    }

    // default => input output 둘 다 보여줌
    public static BufferedReader getBufferedReader(){
        try{
            print(new BufferedReader(new FileReader(testFilePath+"input"+ curfilenum+".txt")),true,true);
            return new BufferedReader(new FileReader(testFilePath+"input"+ curfilenum+".txt"));
        }catch(Exception e){
            System.out.println("파일 경로 또는 파일명이 잘못되었습니다.");
            System.out.println("콘솔 입력으로 진행합니다.");
            return new BufferedReader(new InputStreamReader(System.in));
        }
    }

    //input만 보여줄지 안보여줄지
    public static BufferedReader getBufferedReader(boolean showInput){
        try{
            print(new BufferedReader(new FileReader(testFilePath+"input"+ curfilenum+".txt")),showInput,true);
            return new BufferedReader(new FileReader(testFilePath+"input"+ curfilenum+".txt"));
        }catch(Exception e){
            System.out.println("파일 경로 또는 파일명이 잘못되었습니다.");
            System.out.println("콘솔 입력으로 진행합니다.");
            return new BufferedReader(new InputStreamReader(System.in));
        }
    }

    //input, output 둘 다 선택
    public static BufferedReader getBufferedReader(boolean showInput, boolean showOutput){
        try{
            print(new BufferedReader(new FileReader(testFilePath+"input"+ curfilenum+".txt")),showInput,showOutput);
            return new BufferedReader(new FileReader(testFilePath+"input"+ curfilenum+".txt"));
        }catch(Exception e){
            System.out.println("파일 경로 또는 파일명이 잘못되었습니다.");
            System.out.println("콘솔 입력으로 진행합니다.");
            return new BufferedReader(new InputStreamReader(System.in));
        }
    }

    private static void initTestCaseFile() throws IOException {
        BufferedReader br = new BufferedReader(getBufferedReader(originFilePath+originFileName));
        String writeLine;
        String filename = testFileName.replace("%filenum%",String.valueOf(filecnt++));
        FileWriter fw;
        fw = new FileWriter(testFilePath + filename, false); // 파일이 있을경우 덮어쓰기

        while((writeLine = br.readLine()) != null){
            if(writeLine.equals("")){
                fw.close();
                filename = testFileName.replace("%filenum%",String.valueOf(filecnt++));
                fw = new FileWriter(testFilePath + filename, false);
                continue;
            }
            fw.write(writeLine);
            fw.write("\r\n");
        }
        fw.close();
    }

    private static void printInput(BufferedReader br) throws IOException {
        String printLine;
        System.out.println("\nInput : ");
        while((printLine = br.readLine())!= null)
            System.out.println(printLine);
    }
    private static void printOutput(){
        System.out.println("\noutput : ");
    }
    private static void print(BufferedReader br,boolean showInput, boolean showOutput) throws IOException {
        if(showInput)
            printInput(br);
        if(showOutput)
            printOutput();
    }


    public static void runClass(String runClassName) throws IOException {
        initTestCaseFile();
        try{
            File dir = new File(originFilePath.split("src")[0]+"src");
            Class<?> obj;
            try{
                obj = Class.forName(showFilesInDIr(dir.toString(),runClassName)
                    .replace(".java","")
                    .replaceAll("/",".")
                    .split("src.")[1]
                );
            }catch (IndexOutOfBoundsException e){
                if(showFilesInDIr(dir.toString(),runClassName).equals("NONE")){
                    System.out.println(runClassName + "파일이 없습니다.");
                }else{
                    System.out.println("다른 오류");
                }
                return;
            }

            Method meth = obj.getMethod("main", String[].class);
            String[] params = null; // init params accordingly
            for(int i=1; i<Source.filecnt; ++i){
                curfilenum = i;
                meth.invoke(null, (Object) params);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static String showFilesInDIr(String dirPath,String runClassName) {
        File dir = new File(dirPath);
        File files[] = dir.listFiles();

        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            if (file.isDirectory()) {
                String temp = showFilesInDIr(file.getPath(),runClassName);
                if(!temp.equals("NONE")){
                    return temp;
                }
            } else {
                if(file.toString().contains(runClassName)){
                    return file.toString();
                }
            }
        }
        return "NONE";
    }


}
