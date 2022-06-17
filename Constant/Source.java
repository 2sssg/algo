package Constant;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Source {
    private final static String inputFileSource = "/Users/2sssg/workspace/baekjoon/src/input.txt";
    public static String getInputFileSource(){
        return inputFileSource;
    }
    public static FileReader getInputFileReader() throws IOException {
        FileReader fr = new FileReader(getInputFileSource());
        int singleCh = 0;
        System.out.println("input : ");
        while((singleCh = fr.read()) != -1)
            System.out.print((char) singleCh);
        System.out.print("\n\noutput : \n");
        return new FileReader(getInputFileSource());
    }
}
