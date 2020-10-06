import java.util.Scanner;

class Test{
    private static int x;
    private static int y;

    Test(){
        Test.x = 0;
        Test.y = 0;
    }
    static void SetXY(int x, int y){
        Test.x = x;
        Test.y = y;
    }
    static void CPlus(){
        int temp = Test.x + Test.y;
        System.out.println("XY相加后:" + temp);
    }
    static void CSub(){
        int temp = Test.x - Test.y;
        System.out.println("XY相减后:" + temp);
    }
    static void CCPlus(){
        int temp = Test.x * Test.y;
        System.out.println("XY相乘后:" + temp);
    }
    static void CDiv(){
        int temp = Test.x / Test.y;
        System.out.println("XY相除后:" + temp);
    }
    static void ShowXY(){
        System.out.println("x的值为：" + Test.x);
        System.out.println("y的值为：" + Test.y);
    }
}

public class file{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("输入静态变量x,y的值:");
        Test.SetXY(in.nextInt(), in.nextInt());
        System.out.println("输入后的XY值:");
        Test.ShowXY();
        Test.CPlus();
        Test.CSub();
        Test.CCPlus();
        Test.CDiv();
    }
}