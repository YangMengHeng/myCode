import java.util.*;

public class STRING{
    public static void main(String[] args) {
        ArrayList<Character> c = new ArrayList<Character>();
        Scanner in = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int[] temp = new int[26];

        System.out.println("Pls input string:");
        sb.append(in.nextLine());
        for(int i = 0; i < sb.length(); i++){
            c.add(sb.charAt(i));
        }
        for(int i = 0; i < c.size(); i++){
            int t = c.get(i).charValue();
            if((t >= 65) && (t <= 90)){
                temp[t - 65]++;
            }
            else if((t >= 97) && (t <= 122)){
                temp[t - 97]++;
            }
        }
        for(int i = 0; i < temp.length; i++){
            System.out.println((char)(i + 97) + "出现次数为:" + temp[i]);
        }
        in.close();
    }
}