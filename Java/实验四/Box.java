import java.util.Scanner;

class boxs{
    private double width;
    private double length;
    private double height;

    boxs(){}
    boxs(double a, double b, double c){
        this.width = a;
        this.length = b;
        this.height = c;
    }
    void ShowBoxs(){
        System.out.println("宽度:" + this.width);
        System.out.println("长度:" + this.length);
        System.out.println("高度:" + this.height);
    }
}

public class Box{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a[] = new double[3];
        System.out.println("输入宽度:");
        a[0] = in.nextDouble();
        System.out.println("输入长度:");
        a[1] = in.nextDouble();
        System.out.println("输入高度:");
        a[2] = in.nextDouble();
        boxs BOX = new boxs(a[0], a[1], a[2]);

        BOX.ShowBoxs();
        in.close();
    }
}