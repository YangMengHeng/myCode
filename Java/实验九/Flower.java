import java.io.*;

public class Flower{
    public static void main(String[] args) throws IOException{
        int x,y,z,temp,i,j = 0;
        int[] t = new int[100];
        String[] str = new String[100];
        FileWriter w = new FileWriter("D:\\output.txt", true);

        for(i = 100; i <= 999; i++){
            x = i / 100;
            y = (i - x * 100) / 10;
            z = i % 10;
            temp = x*x*x + y*y*y + z*z*z;
            if(temp == i){
                t[j++] = temp;
                str[j - 1] = Integer.toString(i) + " = " + x + '*' + x + '*' + x + ' ' + y + '*' + y + '*' + y + ' ' + z + '*' + z + '*'  + z + '\n';
                w.write(str[j - 1]);
                System.out.print(str[j - 1]);
            }
        }
        w.close();
    }
}