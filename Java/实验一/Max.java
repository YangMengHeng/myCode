import java.util.Scanner;

public class Max{
    public static void main(String args[])
    {
        double x, y;

        System.out.println("输入两个整数(x, y):");
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextDouble();
        y = scanner.nextDouble();

        if(x > y)
        {
            System.out.println("x更大! " + "x值为" + x);
        }
        else 
        {
            System.out.println("y更大! " + "y值为" + y);
        }
    }
}