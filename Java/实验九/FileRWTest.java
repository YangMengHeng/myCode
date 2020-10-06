import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.java.io.*;
import java.java.util.*;

public class FileRWTest{
    public static void main(String[] args)throws IOException {
        FileReader read = new FileReader("D:\\input.txt");
        FileWriter write = new FileWriter("D:\\output.txt", true);
        String s;
        String[] str;
        char[] cbuf = new char[20];

        do{
            int length = read.read(cbuf);
            if(length < 0) break;
            s = new String(cbuf, 0, length);
            System.out.println(s);
        }while(true);
        str = new String[5];
        try{
            for(int i = 0; i < 5; i++){
                str[i] = new String(Integer.toString(i + 10));
                str[i] = str[i] + '\n';
                write.write(str[i]);
                System.out.print(str[i]);
            }
        }catch(IOException e){
            System.out.println(e.getStackTrace());
        }
        write.close();
        read.close();
    }
}