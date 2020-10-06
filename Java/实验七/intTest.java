import java.util.*;

public class intTest{
    public static void main(String[] args) {
        int[] scan = new int[5];
        String[] temp = new String[5];
        Scanner in = new Scanner(System.in);
        boolean flag = true;

        do{
        try{
            System.out.println("Pls enter five numbers and separat by space:");
            for(int i = 0; i < 5; i++){
                temp[i] = in.next();
                scan[i] = Integer.parseInt(temp[i]);
            }
            for(int i = 0; i < 5; i++){
                System.out.println("the first numbers is " + scan[i]);
            }
            flag = false;
        }
        catch(NoSuchElementException nsc){
            System.out.println("pls enter five integers!come on!");
        }
        catch(ArrayIndexOutOfBoundsException aio){
            System.out.println("pls enter five integers!come on!");
        }
        catch(NumberFormatException nfe){
            System.out.println("pls enter integer!come on!");
        }
    }while(flag == true);
}
}