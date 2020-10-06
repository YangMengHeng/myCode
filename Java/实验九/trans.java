import java.io.*;

public class trans{
    public static String[] Read(String fname)throws IOException{
        FileInputStream is = new FileInputStream(fname);
        BufferedReader read = new BufferedReader(new InputStreamReader(is));
        String[] str = new String[20];
        int i = 0;

        while((str[i++] = read.readLine()) != null){
            System.out.println(str[i - 1]);
        }
        read.close();
        is.close();

        return str;
    }
    public static void Write(String fname, String[] str)throws IOException{
        FileOutputStream os = new FileOutputStream(fname, true);
        BufferedWriter write = new BufferedWriter(new OutputStreamWriter(os));

        for(int i = 0;i < str.length && str[i] != null; i++){
            str[i] += '\n';
            System.out.print(str[i]);
            write.write(str[i]);
        }
        write.close();
        os.close();
    }
    public static void Statics(String[] str, int[] num)throws NullPointerException{
        int i;
        int j = 0;
        char[] temp;

        for(i = 0; i < str.length; i++){
            try{
                temp = str[i].toCharArray();
            }catch(NullPointerException np){
                return;
            }
            for(int k = 0 ; k < str[i].length(); k++){
                if(temp[k] >= 'a' && temp[k] <= 'z'){
                    num[0]++;
                }
                else if(temp[k] >= 'A' && temp[k] <= 'Z'){
                    num[1]++;
                }
            }
        }
    }
    public static void main(String[] args)throws IOException ,NullPointerException{
        String[] str = Read("D:\\Precaution.txt");
        int[] num = new int[2];

        Statics(str, num);
        System.out.println("大写字母次数为：" + num[1]);
        System.out.println("小写字母次数为：" + num[0]);
        try{
            for(int i = 0; i < str.length; i++){
                str[i] = str[i].toUpperCase();
                System.out.println(str[i]);
            }
        }catch(NullPointerException np){}
        Write("D:\\result.txt", str);
    }
}