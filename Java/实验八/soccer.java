import java.util.*;

public class soccer{
    public static void Ini(String[] t){
        t[0] = "科特迪瓦";
        t[1] = "阿根廷";
        t[2] = "澳大利亚";
        t[3] = "塞尔维亚";
        t[4] = "荷兰";
        t[5] = "尼日利亚";
        t[6] = "日本";
        t[7] = "美国";
        t[8] = "中国";
        t[9] = "新西兰";
        t[10] = "巴西";
        t[11] = "比利时";
        t[12] = "韩国";
        t[13] = "喀麦隆";
        t[14] = "洪都拉斯";
        t[15] = "意大利";
    }

    public static void main(String[] args)throws ArrayIndexOutOfBoundsException{
        ArrayList<String> ary = new ArrayList<String>();
        ArrayList<Integer> code = new ArrayList<Integer>();
        String[] temp = new String[16];
        int x;

        Ini(temp);
        while(code.size() < 16){
            x = (int)(Math.random() * 16);
            if(!code.contains(x)){
                code.add(x);
            }
        }
        for(int i = 0; i < temp.length; i++){
            ary.add(temp[code.get(i)]);
        }
        for(int i = 0; i < temp.length; i++){
            if(i == 0){
                System.out.println("第一组球队为：");
            }
            if(i == 4){
                System.out.println("第二组球队为：");
            }
            if(i == 8){
                System.out.println("第三组球队为：");
            }
            if(i == 12){
                System.out.println("第四组球队为：");
            }
            System.out.println(ary.get(i));
        }
    }
}