public class multiple{
    public static void main(String args[]){
        double re = 1;
        double temp[] = new double[19];
        double q = 1;

        System.out.println("for循环实现:");
        for(int i = 2; i <= 20; i++)
        {
            q = 1;
            for(int j = i; j > 1; j--)
            {
                q *= j;
            } 
            temp[i - 2] = q;
        }
        System.out.print("第1项:" + re + ' ');
        for(int k = 1; k < 20; k++)
        {
            re += 1 / temp[k - 1];
            System.out.print("第" + (k + 1) + "项:" + (1 / temp[k - 1]) + ' ');
        }
        System.out.println("前二十项总和为:" + re);

        System.out.println("do-while循环实现:");
        int c = 2;
        re = 1;

        do{
            q = 1;
            int x = c;
            do{
                q *= x;
                x--;
            }while(x > 1);
            temp[c - 2] = q;
            c++;
        }while(c <= 20);
        System.out.print("第1项:" + re + ' ');
        int z = 1;
        do{
            re += 1 / temp[z - 1];
            System.out.print("第" + (z + 1) + "项:" + (1 / temp[z - 1]) + ' ');
            z++;
        }while(z < 20);
        System.out.println("前二十项总和为:" + re);
    }
}